package tho.nill.preislisten;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import entities.Kasse;
import entities.VersandZiel;
import lombok.extern.slf4j.Slf4j;
import repositories.KasseRepository;
import repositories.KundeRepository;
import repositories.VersandZielRepository;
import tho.nill.preislisten.simpleAttributes.Abrechnungscode;
import tho.nill.preislisten.simpleAttributes.DatenlieferungsArt;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.Leistungserbringergruppe;
import tho.nill.preislisten.simpleAttributes.VerweisArt;
import tho.nill.preislisten.versandziel.EnumFilter;
import tho.nill.preislisten.versandziel.FilterList;
import tho.nill.preislisten.versandziel.P302Ergebnis;
import tho.nill.preislisten.versandziel.TarifkennzeichenFilter;
import tho.nill.preislisten.versandziel.VersandzielAbfrageDaten;

@Slf4j
@Service
public class KostenträgerInfoService extends BasisServiceWithResult<VersandzielAbfrageDaten, P302Ergebnis> {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private VersandZielRepository versandZielRepo;

	@Autowired
	private KundeRepository kundeRepo;

	@Autowired
	private KasseRepository kasseRepo;

	private FilterList felder = new FilterList();

	public KostenträgerInfoService(PlatformTransactionManager transactionManager) {
		super(transactionManager);
	}

	private FilterList createFilterList(VersandzielAbfrageDaten abfrage) {
		felder = new FilterList();
		felder.add(new EnumFilter(abfrage.getLand(), "land", (VersandZiel z) -> z.getLand()));
		felder.add(new TarifkennzeichenFilter(abfrage.getTarifkennzeichen()));
		felder.add(new EnumFilter(abfrage.getBezirk(), "bezirk", (VersandZiel z) -> z.getBezirk()));
		felder.add(new EnumFilter(abfrage.getAbrechnungscode(), Abrechnungscode.Sammelschlüssel_00, "abrechnungscode",
				(VersandZiel z) -> z.getAbrechnungscode()));
		return felder;
	}

	@Override
	public P302Ergebnis performService(VersandzielAbfrageDaten abfrage) {
		IK versichertenkarte = abfrage.getIk();

		List<Kasse> lk = kasseRepo.findByIk(versichertenkarte);
		for (Kasse ka : lk) {
			anzeigen(ka.getVersandZiel());
		}

		Optional<IK> kostenträger = queryResult(abfrage.getIk(), null, VerweisArt.VerweisKostenträger_01, null,
				abfrage);
		Optional<IK> prüfstelle = Optional.empty();
		Optional<IK> papier = Optional.empty();
		Optional<IK> datenannahmestelle = Optional.empty();
		if (kostenträger.isPresent()) {
			prüfstelle = queryResult(kostenträger.get(), VerweisArt.VerweisPrüfstelle_03, abfrage.getArt(), abfrage,
					kostenträger.get(), versichertenkarte);
			papier = queryResult(kostenträger.get(), VerweisArt.VerweisPapierannahme_09,
					DatenlieferungsArt.RechnungPapier_21, abfrage, kostenträger.get(), versichertenkarte);
			if (prüfstelle.isPresent()) {
				datenannahmestelle = queryResult(kostenträger.get(), VerweisArt.VerweisDatenannahme_02,
						abfrage.getArt(), abfrage, prüfstelle.get(), kostenträger.get());
				if (datenannahmestelle.isEmpty()) {
					datenannahmestelle = prüfstelle;
				}
			}
		}
		return new P302Ergebnis(versichertenkarte, optionalUmsetzen(kostenträger), optionalUmsetzen(papier),
				optionalUmsetzen(prüfstelle), optionalUmsetzen(datenannahmestelle));
	}

	public IK optionalUmsetzen(Optional<IK> ik) {
		return (ik.isPresent()) ? ik.get() : null;
	}

	private Optional<IK> queryResult(IK kostenträger, VerweisArt verweisArt, DatenlieferungsArt art,
			VersandzielAbfrageDaten abfrage, IK... iks) {
		for (IK ik : iks) {
			Optional<IK> verweisIk = queryResult(ik, kostenträger, verweisArt, art, abfrage);
			if (verweisIk.isPresent()) {
				return verweisIk;
			}
		}
		return Optional.empty();
	}

	private Optional<IK> queryResult(IK ik, IK kostenträger, VerweisArt verweisArt, DatenlieferungsArt art,
			VersandzielAbfrageDaten abfrage) {
		FilterList filter = createFilterList(abfrage);
		String stmt = createQuery(ik, kostenträger, verweisArt, art, filter, abfrage);
		log.info(stmt);
		Query query = entityManager.createQuery(stmt);
		List<VersandZiel> ziele = (List<VersandZiel>) query.getResultList();
		if (ziele.size() > 0) {
			log.info("Abfrage ergibt " + ziele.size() + " Einträge");
			anzeigen(ziele);
			Optional<VersandZiel> ziel = filter.bestesZiel(ziele);
			if (ziel.isPresent()) {
				return Optional.of(ziel.get().getNach_ik());
			}
		} else {
			log.info("Abfrage ergibt leeres Resultat");
		}
		return Optional.empty();
	}

	private String createQuery(IK ik, IK kostenträger, VerweisArt verweisArt, DatenlieferungsArt art, FilterList filter,
			VersandzielAbfrageDaten abfrage) {
		StringBuilder builder = new StringBuilder();
		builder.append("select z from VersandZiel z where z.von_ik = " + ik);
		addDatenlieferungsart(builder, art);
		addLeistungserbringergruppe(builder, abfrage.getLeistungserbringergruppe());
		addVerweisArt(builder, verweisArt);
		addKostenträger(builder, kostenträger);
		filter.append(builder);
		return builder.toString();
	}

	private void addKostenträger(StringBuilder builder, IK kostenträger) {
		if (kostenträger != null) {
			builder.append(" and ( z.kostenträger = " + kostenträger + " or z.kostenträger is null )  ");
		}

	}

	private void addDatenlieferungsart(StringBuilder builder, DatenlieferungsArt art) {
		if (art != null) {
			builder.append(" and ( z.art in " + art.getSuche() + " or z.art is null) ");
		}
	}

	private void addVerweisArt(StringBuilder builder, VerweisArt verweisArt) {
		if (verweisArt != null) {
			builder.append(" and z.verweis = " + verweisArt.ordinal() + " ");
		}
	}

	private void addLeistungserbringergruppe(StringBuilder builder, Leistungserbringergruppe gruppe) {
		if (gruppe != null) {
			builder.append(" and z.leistungserbringergruppe = " + gruppe.ordinal() + " ");
		}
	}

	private void anzeigen(Iterable<VersandZiel> ziele) {
		if (log.isDebugEnabled()) {
			for (VersandZiel z : ziele) {
				log.debug("z von IK: " + z.getVon_ik());
				log.debug("z nach IK: " + z.getNach_ik());
				log.debug("z Abrechnungscode: " + z.getAbrechnungscode());
				log.debug("z Art: " + z.getArt());
				log.debug("z Leistungserbringergruppe: " + z.getLeistungserbringergruppe());
				log.debug("z Tarifkennzeichen: " + z.getTarifkennzeichen());
				log.debug("z Bezirk: " + z.getBezirk());
				log.debug("z Land: " + z.getLand());
				log.debug("z Verweis: " + z.getVerweis());
			}
		}
	}
}
