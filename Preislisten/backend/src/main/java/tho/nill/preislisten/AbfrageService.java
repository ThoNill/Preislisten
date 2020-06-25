package tho.nill.preislisten;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import entities.Kasse;
import entities.Kunde;
import entities.PreislistePosition;
import lombok.extern.slf4j.Slf4j;
import repositories.KasseRepository;
import repositories.KundeRepository;
import tho.nill.preislisten.abfrage.AbfrageDaten;
import tho.nill.preislisten.abfrage.AbfrageDatum;
import tho.nill.preislisten.abfrage.AbfragePreislisteBezug;
import tho.nill.preislisten.abfrage.AddOrList;
import tho.nill.preislisten.simpleAttributes.BezugArt;
import tho.nill.preislisten.simpleAttributes.DatumArt;

@Slf4j
@Service
public class AbfrageService extends BasisServiceWithResult<AbfrageDaten,Optional<PreislistePosition>>{

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private KundeRepository kundeRepo;
	
	@Autowired
	private KasseRepository kasseRepo;
	
	public AbfrageService(PlatformTransactionManager transactionManager) {
		super(transactionManager);
	}

	
	@Override
	public Optional<PreislistePosition> performService(AbfrageDaten abfrage) {
		return queryResult(abfrage);
	}


	private Optional<PreislistePosition> queryResult(AbfrageDaten abfrage) {
		Kunde kunde = kundeRepo.getOne(abfrage.getKundenId());
		Kasse kasse = kasseRepo.getOne(abfrage.getKassenId());
		String stmt = createQuery(kunde,kasse,abfrage);
		log.info(stmt);
		Query query = entityManager.createQuery(stmt);
		List<?> list = query.getResultList();
		if (list.size()>0) {
			return Optional.of((PreislistePosition)list.get(0));
		}
		return Optional.empty();
	}

	private String createQuery(Kunde kunde, Kasse kasse,AbfrageDaten abfrage) {
		StringBuilder builder = new StringBuilder();
		builder.append("select plp from PreislistePosition plp, PreislisteKopf plk,   PreislisteBezug  bkunde, PreislisteBezug  bkasse  where plp.PreislisteKopf = plk  and bkunde.PreislisteKopf = plk  and bkasse.PreislisteKopf = plk  ");
		builder.append(" and plk.art=" + abfrage.getArtDerPreisliste().ordinal());
		addBezüge(builder, kunde, kasse, abfrage);
		builder.append( " order by bkunde.art desc, bkasse.art desc, plp.Position.art desc");
		return builder.toString();
	}


	private void addBezüge(StringBuilder builder,Kunde kunde,Kasse kasse,AbfrageDaten abfrage) {
		addPreislisteBezüge(builder,"bkunde",createBezüge(kunde));
		addPreislisteBezüge(builder,"bkasse",createBezüge(kasse));
		addDatumBezüge(builder,"plk", abfrage.getAbDatumAuswahl());
		addPositionBezüge(builder,"plp",createBezüge(abfrage.getPosnummer()));
		builder.append( " ");
	}

	
	
	private void addPreislisteBezug(StringBuilder builder, String alias,AbfragePreislisteBezug bezug) {
		builder.append(" ( ");
		builder.append(alias);
		builder.append(".art= "+bezug.getArt().ordinal());
		builder.append(" and ");
		builder.append(alias);
		builder.append(".nummer="+bezug.getNummer());
		builder.append(" ) ");
	}

	private void addPreislisteBezüge(StringBuilder builder, String alias,List<AbfragePreislisteBezug> bezüge) {
		new AddOrList<AbfragePreislisteBezug>() {
			@Override
			protected void addPosition(StringBuilder builder, String alias,AbfragePreislisteBezug bezug) {
				addPreislisteBezug(builder, alias, bezug);
			}
		}.addPositionBezüge(builder, alias, bezüge);
	}

	private void addPositionBezug(StringBuilder builder, String alias,String posnummer) {
		builder.append(" ");
		builder.append(alias);
		builder.append(".Position.nummer='"+posnummer);
		builder.append("' ");
	}

	private void addPositionBezüge(StringBuilder builder, String alias,List<String> bezüge) {
		new AddOrList<String>() {
			@Override
			protected void addPosition(StringBuilder builder, String alias,String bezug) {
				addPositionBezug(builder, alias, bezug);
			}
		}.addPositionBezüge(builder, alias, bezüge);
	}

	private void addDatumBezüge(StringBuilder builder, String alias,HashMap<DatumArt,AbfrageDatum> bezüge) {
		new AddOrList<AbfrageDatum>() {
			@Override
			protected void addPosition(StringBuilder builder, String alias,AbfrageDatum bezug) {
				addDatumBezug(builder, alias, bezug);
			}

		}.addPositionBezüge(builder, alias, bezüge.values());
	}

	private void addDatumBezug(StringBuilder builder, String alias, AbfrageDatum bezug) {
		builder.append(" ( ");
		builder.append(alias);
		builder.append(".dart="+bezug.getArt().ordinal());
		builder.append(" and  ");
		builder.append(alias);
		builder.append(".gültigAb>='"+bezug.getDatum());
		builder.append("' ) ");

	}
	
	private List<AbfragePreislisteBezug> createBezüge(Kunde kunde) {
		List<AbfragePreislisteBezug> bezüge = new ArrayList<>();
		bezüge.add(createBezug(BezugArt.Tarifbereich,kunde.getTarifbereich().ordinal()));
		bezüge.add(createBezug(BezugArt.KundenID,kunde.getKundeId()));
		return bezüge;
	}
	
	private List<AbfragePreislisteBezug> createBezüge(Kasse kasse) {
		List<AbfragePreislisteBezug> bezüge = new ArrayList<>();
		bezüge.add(createBezug(BezugArt.Kassenart,kasse.getArt().ordinal()));
		bezüge.add(createBezug(BezugArt.KassenID,kasse.getKasseId()));
		return bezüge;
	}

	private List<String> createBezüge(String posnummer) {
		List<String> bezüge = new ArrayList<>();
		bezüge.add(posnummer);
		bezüge.add(posnummer.substring(0,7));
		return bezüge;
	}


	private AbfragePreislisteBezug createBezug(BezugArt art, long posnummer) {
		return new AbfragePreislisteBezug(art,posnummer);
	}


	
	
}

