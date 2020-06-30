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
		felder.add(new EnumFilter(abfrage.getAbrechnungscode(),Abrechnungscode.Sammelschlüssel_00, "abrechnungscode",
				(VersandZiel z) -> z.getAbrechnungscode()));
		return felder;
	}

	@Override
	public P302Ergebnis performService(VersandzielAbfrageDaten abfrage) {
		IK versichertenkarte = abfrage.getIk();
		
		
		
		List<Kasse> lk = kasseRepo.findByIk(versichertenkarte);
		for(Kasse ka : lk) {
			for(VersandZiel z : ka.getVersandZiel()) {
				System.out.println("z von IK: " + z.getVon_ik());
				System.out.println("z nach IK: " + z.getNach_ik());
				System.out.println("z Abrechnungscode: " + z.getAbrechnungscode());
				System.out.println("z Art: " + z.getArt());
				System.out.println("z Leistungserbringergruppe: " + z.getLeistungserbringergruppe());
				System.out.println("z Tarifkennzeichen: " + z.getTarifkennzeichen());
				System.out.println("z Bezirk: " + z.getBezirk());
				System.out.println("z Land: " + z.getLand());
			}
		}
		
		
		
		
		Optional<IK> kostenträger = queryResult(abfrage.getIk(), null, VerweisArt.VerweisKostenträger_01, abfrage);
		Optional<IK> prüfstelle = Optional.empty();
		Optional<IK> papier = Optional.empty();
		Optional<IK> datenannahmestelle = Optional.empty();
		if (kostenträger.isPresent()) {
			prüfstelle = queryResult(kostenträger.get(), kostenträger.get(), VerweisArt.VerweisPrüfstelle_03, abfrage);
			papier = queryResult(kostenträger.get(), kostenträger.get(), VerweisArt.VerweisPapierannahme_09,
					abfrage);
			if (prüfstelle.isPresent()) {
				datenannahmestelle = queryResult(prüfstelle.get(), kostenträger.get(),
						VerweisArt.VerweisDatenannahme_02, abfrage);
				if (datenannahmestelle==null) {
					datenannahmestelle= prüfstelle;
				}
			}
		}
		return new P302Ergebnis(versichertenkarte, optionalUmsetzen(kostenträger), optionalUmsetzen(papier),
				optionalUmsetzen(prüfstelle), optionalUmsetzen(datenannahmestelle));
	}

	public IK optionalUmsetzen(Optional<IK> ik) {
		return (ik.isPresent()) ? ik.get() : null;
	}

	private Optional<IK> queryResult(IK ik, IK kostenträger, VerweisArt verweisArt, VersandzielAbfrageDaten abfrage) {
		FilterList filter = createFilterList(abfrage);
		String stmt = createQuery(ik, kostenträger, verweisArt, filter, abfrage);
		log.info(stmt);
		Query query = entityManager.createQuery(stmt);
		List<VersandZiel> ziele = (List<VersandZiel>) query.getResultList();
		if (ziele.size() > 0) {
			Optional<VersandZiel> ziel = filter.bestesZiel(ziele);
			if (ziel.isPresent()) {
				return Optional.of(ziel.get().getNach_ik());
			}
		}
		return Optional.empty();
	}

	private String createQuery(IK ik, IK kostenträger, VerweisArt verweisArt, FilterList filter,
			VersandzielAbfrageDaten abfrage) {
		StringBuilder builder = new StringBuilder();
		builder.append("select z from VersandZiel z where z.von_ik = " + ik);
		addDatenlieferungsart(builder, abfrage.getArt());
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
		builder.append(" and z.art in " + art.getSuche() + " ");
	}

	private void addVerweisArt(StringBuilder builder, VerweisArt verweisArt) {
		builder.append(" and z.verweis = " + verweisArt.ordinal() + " ");
	}

	private void addLeistungserbringergruppe(StringBuilder builder, Leistungserbringergruppe gruppe) {
		builder.append(" and z.leistungserbringergruppe = " + gruppe.ordinal() + " ");
	}

}
