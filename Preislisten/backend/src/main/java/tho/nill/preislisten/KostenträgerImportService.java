package tho.nill.preislisten;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import entities.Kasse;
import entities.VersandZiel;
import lombok.extern.slf4j.Slf4j;
import repositories.KasseRepository;
import repositories.VersandZielRepository;
import tho.nill.edifact.EdifactReader;
import tho.nill.edifact.Segment;
import tho.nill.edifact.TagProvider;
import tho.nill.edifact.zelt.SetterList;
import zelte.KasseZelt;
import zelte.VersandZielZelt;

@Slf4j
@Service
public class KostenträgerImportService extends BasisServiceWithoutResult<String> {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private VersandZielRepository versandZielRepo;

	@Autowired
	private KasseRepository kasseRepo;

	KasseZelt kasseZelt;
	VersandZielZelt versandZielZelt;

	Consumer<Segment> idkFelder;
	Consumer<Segment> ansFelder;
	Consumer<Segment> vkgFelder;
	Consumer<Segment> vdtFelder;
	Consumer<Segment> ktoFelder;
	Consumer<Segment> namFelder;
	Consumer<Segment> aspFelder;
	Consumer<Segment> uemFelder;
	Consumer<Segment> dfuFelder;

	public KostenträgerImportService(PlatformTransactionManager transactionManager) {
		super(transactionManager);
	}

	private void init() {
		kasseZelt = new ImportKasseZelt(kasseRepo);
		versandZielZelt = new VersandZielZelt(versandZielRepo);

		idkFelder = new SetterList(kasseZelt::setIkWithString, kasseZelt::skip, kasseZelt::setFirmaWithString);

		ansFelder = new SetterList(kasseZelt::skip, kasseZelt::setPlzWithString, kasseZelt::setOrtWithString,
				kasseZelt::setStraßeWithString);

		vkgFelder = new SetterList(versandZielZelt::setVerweisWithString, versandZielZelt::setNach_ikWithString,
				versandZielZelt::setLeistungserbringergruppeWithString, versandZielZelt::setAbrechnungsstelleWithString,
				versandZielZelt::setArtWithString, versandZielZelt::setMediumWithString,
				versandZielZelt::setLandWithString, versandZielZelt::setBezirkWithString,
				versandZielZelt::setAbrechnungscodeWithString, versandZielZelt::setTarifkennzeichenWithString);

		vdtFelder = new SetterList(kasseZelt::setGültigAbWithString, kasseZelt::setGültigBisWithString);
		ktoFelder = new SetterList(kasseZelt::skip, kasseZelt::skip, kasseZelt::skip, kasseZelt::setIbanWithString,
				kasseZelt::setBicWithString, kasseZelt::setKontoinhaberWithString);
		namFelder = new SetterList(kasseZelt::skip, kasseZelt::setNameWithString, kasseZelt::setName2WithString,
				kasseZelt::setName3WithString, kasseZelt::setName4WithString);
		aspFelder = new SetterList(kasseZelt::skip, kasseZelt::setTelefonWithString, kasseZelt::setFaxWithString,
				kasseZelt::setAnsprechpartnerWithString, kasseZelt::setArbeitsgebietWithString);
		uemFelder = new SetterList(kasseZelt::setMediumWithString, kasseZelt::setParameterWithString,
				kasseZelt::setZeichensatzWithString, kasseZelt::setKomprimierungWithString);
		dfuFelder = new SetterList(kasseZelt::skip, kasseZelt::setProtokollWithString,
				kasseZelt::setBenutzerkennungWithString, kasseZelt::setÜbertragung_vonWithString,
				kasseZelt::setÜbertragung_bisWithString, kasseZelt::setÜbertragungstageWithString,
				kasseZelt::setKommunikationskanalWithString);

	}

	/*
	 * UNH+00002+KOTR:02:001:KV' IDK+101320032+99+SECURVITA BKK' VDT+20100701'
	 * gültigab, gültigbis FKT+01' VKG+01+101320032+5++++++00'
	 * VKG+03+107436557+5++07++++00' VKG+09+107436557+5++28++++00'
	 * VKG+09+107436557+5++29++++00' NAM+01+SECURVITA+Betriebskrankenkasse'
	 * ANS+1+20099+Hamburg+Lübeckertordamm 1-3' ANS+2+20039+Hamburg+105829'
	 * UNT+000012+00002'
	 */

	@Override
	public void performService(String dateiName) {
		init();
		TagProvider tags = createTagProvider();

		int zeile = 1;
		Segment seg = null;
		try {
			EdifactReader edifactReader = new EdifactReader(new FileReader(dateiName, StandardCharsets.UTF_8), tags,
					50);
			while (edifactReader.hasNext()) {
				seg = edifactReader.next();
				log.info(seg.toString());
				tagsBehandeln(seg);
				zeile++;
			}
		} catch (IOException | RuntimeException e) {
			log.error("Fehler in Zeile {} {} {}", zeile, seg, e.getLocalizedMessage());
		}

	}

	private void tagsBehandeln(Segment seg) {
		switch (seg.getTag().name()) {
		case "UNH":
			kasseZelt.create();
			break;
		case "IDK":
			idkFelder.accept(seg);
			break;
		case "VDT":
			vdtFelder.accept(seg);
			bisherigeKassenEinträgeBerücksichtigen();
			break;
		case "KTO":
			ktoFelder.accept(seg);
			break;
		case "NAM":
			namFelder.accept(seg);
			break;
		case "ASP":
			aspFelder.accept(seg);
			break;
		case "UEM":
			uemFelder.accept(seg);
			break;
		case "DFU":
			// Internet
			if ("070".contentEquals(seg.getGroupAsText(1))) {
				dfuFelder.accept(seg);
			}
			break;
		case "ANS":
			if ("1".contentEquals(seg.getGroupAsText(0))) {
				ansFelder.accept(seg);
			}
			break;
		case "VKG": {
			versandZielZelt.create();
			vkgFelder.accept(seg);
			kasseZelt.connectKasse(versandZielZelt);
			versandZielZelt.getEntity().setVon_ik(kasseZelt.getIk());
			versandZielZelt.save();
		}
			break;
		case "UNT":
			kasseZelt.save();
			break;
		default:
		}
	}

	private void bisherigeKassenEinträgeBerücksichtigen() {
		Kasse entity = kasseZelt.getEntity();
		List<Kasse> vorhandeneKassen = kasseRepo.findByIkAndGültigAb(entity.getIk(), entity.getGültigAb());
		if (vorhandeneKassen.size() == 1) {
			Kasse k = vorhandeneKassen.get(0);
			kasseZelt.setEntity(k);
			bisherigeVersandZieleEntfernen(k);
		}
		if (vorhandeneKassen.size() > 1) {
			throw new RuntimeException("Zuviele Einträge für IK " + entity.getIk() + " " + entity.getGültigAb());
		}
	}

	private void bisherigeVersandZieleEntfernen(Kasse k) {
		List<VersandZiel> arbeitsKopie = new ArrayList<VersandZiel>(k.getVersandZiel());
		for (VersandZiel z : arbeitsKopie) {
			k.removeVersandZiel(z);
			z.setKasse(null);
		}
		versandZielRepo.deleteAll(arbeitsKopie);
	}

	private TagProvider createTagProvider() {
		TagProvider tags = new TagProvider();
		tags.getOrCreateEnum("IDK");
		tags.getOrCreateEnum("VDT");
		tags.getOrCreateEnum("FKT");
		tags.getOrCreateEnum("VKG");
		tags.getOrCreateEnum("NAM");
		tags.getOrCreateEnum("ANS");
		tags.getOrCreateEnum("DFU");
		tags.getOrCreateEnum("UEM");
		tags.getOrCreateEnum("ASP");
		tags.getOrCreateEnum("KTO");
		return tags;
	}

}
