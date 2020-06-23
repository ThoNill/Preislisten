package tho.nill.preislisten;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import entities.Kasse;
import entities.Kunde;
import entities.Position;
import entities.PreislisteBezug;
import entities.PreislisteKopf;
import entities.PreislistePosition;
import repositories.KasseRepository;
import repositories.KundeRepository;
import repositories.PositionRepository;
import repositories.PreislisteBezugRepository;
import repositories.PreislisteKopfRepository;
import repositories.PreislistePositionRepository;
import tho.nill.preislisten.simpleAttributes.BezugArt;
import tho.nill.preislisten.simpleAttributes.DatumArt;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KasseArt;
import tho.nill.preislisten.simpleAttributes.PreislisteArt;
import tho.nill.preislisten.simpleAttributes.Tarifbereich;


@SpringBootTest
public class AbfrageTest {
	
	@Autowired
	AbfrageService abfrageService;

	@Autowired
	public KundeRepository kundeRepository;

	@Autowired
	public KasseRepository kasseRepository;

	@Autowired
	public PositionRepository positionRepository;

	@Autowired
	public PreislisteKopfRepository preislisteKopfRepository;

	@Autowired
	public PreislistePositionRepository preislistePositionRepository;

	@Autowired
	public PreislisteBezugRepository preislisteBezugRepository;

	@BeforeTestMethod
	public void init() {
		Check.clearDb(preislisteBezugRepository,preislistePositionRepository,positionRepository,preislisteKopfRepository,kasseRepository,kasseRepository);
	}


	@Test
	public void testOhneErgebnis() throws IOException {
		AbfrageDaten d = testDatenErzeugen(false);
		d.add(new AbfrageDatum(DatumArt.Leistungsdatum,LocalDate.now().minusYears(2)));
		d.setArtDerPreisliste(PreislisteArt.Kinder);
		Optional<PreislistePosition> erg = abfrageService.service(d);
		assertTrue(erg.isEmpty());
	}

	@Test
	public void testMitErgebnis() throws IOException {
		AbfrageDaten d = testDatenErzeugen(true);
		d.add(new AbfrageDatum(DatumArt.Leistungsdatum,LocalDate.now().minusYears(2)));
		d.setArtDerPreisliste(PreislisteArt.Kinder);
		Optional<PreislistePosition> erg = abfrageService.service(d);
		assertFalse(erg.isEmpty());
	}


	private AbfrageDaten testDatenErzeugen(boolean mitBezügen) {
		Kunde kunde = new Kunde();
		kunde.setIk(new IK(999999999));
		kunde.setTarifbereich(Tarifbereich.Bayern_02);
		kunde = kundeRepository.saveAndFlush(kunde);

		Kasse kasse = new Kasse();
		kasse.setArt(KasseArt.AOK);
		kasse.setIk(new IK(888888888));
		kasse = kasseRepository.saveAndFlush(kasse);
		
		Position position = new Position();
		position.setNummer("1001001001");
		position = positionRepository.saveAndFlush(position);

		PreislistePosition preislistePosition = new PreislistePosition();
		preislistePosition.setPosition(position);
		preislistePosition = preislistePositionRepository.saveAndFlush(preislistePosition);
		
		PreislisteKopf preislisteKopf = new PreislisteKopf();
		preislisteKopf.setArt(PreislisteArt.Kinder);
		preislisteKopf.setDart(DatumArt.Leistungsdatum);
		preislisteKopf.setGültigAb(LocalDate.now());
		preislisteKopf = preislisteKopfRepository.saveAndFlush(preislisteKopf);
		
		preislisteKopf.addPreislistePosition(preislistePosition);
		preislisteKopfRepository.saveAndFlush(preislisteKopf);
		preislistePositionRepository.saveAndFlush(preislistePosition);

		if (mitBezügen) {
			addBezug(preislisteKopf,BezugArt.Kassenart,kasse.getArt().ordinal());
			addBezug(preislisteKopf,BezugArt.KassenID,kasse.getKasseId());
			addBezug(preislisteKopf,BezugArt.Tarifbereich,kunde.getTarifbereich().ordinal());
			addBezug(preislisteKopf,BezugArt.KundenID,kunde.getKundeId());

		}
		
		return new AbfrageDaten(kunde.getKundeId(), kasse.getKasseId(),position.getNummer());
	}
	
	private void addBezug(PreislisteKopf preislisteKopf,BezugArt art, long posnummer) {
		PreislisteBezug preislisteBezug = new PreislisteBezug();
		preislisteBezug.setArt(art);
		preislisteBezug.setNummer(posnummer);
		preislisteBezug = preislisteBezugRepository.saveAndFlush(preislisteBezug);
		preislisteKopf.addPreislisteBezug(preislisteBezug);
		preislisteBezugRepository.saveAndFlush(preislisteBezug);
	}

}
