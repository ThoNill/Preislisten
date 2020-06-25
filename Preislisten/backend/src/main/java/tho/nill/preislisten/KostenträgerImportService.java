package tho.nill.preislisten;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

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

	public KostenträgerImportService(PlatformTransactionManager transactionManager) {
		super(transactionManager);
	}

	/*
	 * UNH+00002+KOTR:02:001:KV' 
	 * IDK+101320032+99+SECURVITA BKK' 
	 * VDT+20100701'
	 * FKT+01' 
	 * VKG+01+101320032+5++++++00' 
	 * VKG+03+107436557+5++07++++00'
	 * VKG+09+107436557+5++28++++00' 
	 * VKG+09+107436557+5++29++++00'
	 * NAM+01+SECURVITA+Betriebskrankenkasse' 
	 * ANS+1+20099+Hamburg+Lübeckertordamm 1-3' 
	 * ANS+2+20039+Hamburg+105829' 
	 * UNT+000012+00002'
	 */

	@Override
	public void performService(String dateiName) {

		TagProvider tags = createTagProvider();
		KasseZelt kasseZelt = new KasseZelt(kasseRepo);
		VersandZielZelt versandZielZelt = new VersandZielZelt(versandZielRepo);

		Consumer<Segment> idkFelder = new SetterList(kasseZelt::setIkWithString, kasseZelt::skip,
				kasseZelt::setFirmaWithString);

		Consumer<Segment> ansFelder = new SetterList(kasseZelt::skip, kasseZelt::setPlzWithString,
				kasseZelt::setOrtWithString, kasseZelt::setStraßeWithString);

		Consumer<Segment> vkgFelder = new SetterList(versandZielZelt::setVerweisWithString,
				versandZielZelt::setNach_ikWithString, versandZielZelt::setLeistungserbringergruppeWithString,
				versandZielZelt::setAbrechnungsstelleWithString, versandZielZelt::setArtWithString,
				versandZielZelt::setMediumWithString, versandZielZelt::setLandWithString,
				versandZielZelt::setBezirkWithString, versandZielZelt::setAbrechnungscodeWithString,
				versandZielZelt::setTarifkennzeichenWithString);
		try {
			EdifactReader edifactReader = new EdifactReader(new FileReader(dateiName, StandardCharsets.UTF_8), tags,
					50);
			while (edifactReader.hasNext()) {
				Segment seg = edifactReader.next();
				tagsBehandeln(kasseZelt, versandZielZelt, idkFelder, ansFelder, vkgFelder, seg);
			}

		} catch (IOException e) {
			log.error(e.getLocalizedMessage());
		}

	}

	private void tagsBehandeln(KasseZelt kasseZelt, VersandZielZelt versandZielZelt, Consumer<Segment> idkFelder,
			Consumer<Segment> ansFelder, Consumer<Segment> vkgFelder, Segment seg) {
		switch (seg.getTag().name()) {
		case "UNH":
			kasseZelt.create();
			break;
		case "IDK":
			idkFelder.accept(seg);
			break;
		case "ANS":
			if ("1".contentEquals(seg.getGroup(0).getElement(0))) {
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
		return tags;
	}

}
