package tho.nill.preislisten;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import entities.HMVArt;
import entities.HMVGruppe;
import entities.HMVOrt;
import entities.HMVProdukt;
import entities.HMVUntergruppe;
import janus.reader.Reader;
import lombok.extern.slf4j.Slf4j;
import repositories.HMVArtRepository;
import repositories.HMVGruppeRepository;
import repositories.HMVOrtRepository;
import repositories.HMVProduktRepository;
import repositories.HMVUntergruppeRepository;
import tho.nill.edifact.Segment;
import tho.nill.preislisten.hilfsmittelverzechnis.XmlHMVArt;
import tho.nill.preislisten.hilfsmittelverzechnis.XmlHMVGruppe;
import tho.nill.preislisten.hilfsmittelverzechnis.XmlHMVOrt;
import tho.nill.preislisten.hilfsmittelverzechnis.XmlHMVProdukt;
import tho.nill.preislisten.hilfsmittelverzechnis.XmlHMVUntergruppe;

@Slf4j
@Service
public class HilfsmittelVerzeichnisImport extends BasisServiceWithoutResult<String> {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private HMVArtRepository hmvArtRepository;
	private HMVArt art;

	@Autowired
	private HMVGruppeRepository hmvGruppeRepository;
	private HMVGruppe gruppe;
	
	@Autowired
	private HMVOrtRepository hmvOrtRepository;
	private HMVOrt ort;
	
	@Autowired
	private HMVUntergruppeRepository hmvUntergruppeRepository;
	private HMVUntergruppe unterGruppe;
	
	@Autowired
	private HMVProduktRepository hmvProduktRepository;
	private HMVProdukt produkt;
	
	public HilfsmittelVerzeichnisImport(PlatformTransactionManager transactionManager) {
		super(transactionManager);
	}

	@Override
	public void performService(String dateiName) {
		int zeile = 1;
		Segment seg = null;
		try {

			Reader reader = new Reader(XmlHMVArt.class, XmlHMVGruppe.class, XmlHMVOrt.class, XmlHMVProdukt.class,
					XmlHMVUntergruppe.class);
			reader.read(dateiName);
			while (reader.hasNext()) {
				Object elem = reader.next();
				if (elem instanceof XmlHMVArt) {
					bearbeiteArt((XmlHMVArt) elem);
				}
				if (elem instanceof XmlHMVGruppe) {
					bearbeiteGruppe((XmlHMVGruppe) elem);
				}
				if (elem instanceof XmlHMVOrt) {
					bearbeiteOrt((XmlHMVOrt) elem);
				}
				if (elem instanceof XmlHMVUntergruppe) {
					bearbeiteUnterGruppe((XmlHMVUntergruppe) elem);
				}
				if (elem instanceof XmlHMVProdukt) {
					bearbeiteProdukt((XmlHMVProdukt) elem);
				}
				log.info("Element {}", elem);
				zeile++;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			log.error("Fehler in Zeile {} {} {}", zeile, seg, e.getLocalizedMessage());
		}

	}

	private void bearbeiteArt(XmlHMVArt elem) {
		art = hmvArtRepository.save(elem.getEntity());
	}
	
	private void bearbeiteGruppe(XmlHMVGruppe elem) {
		gruppe = hmvGruppeRepository.save(elem.getEntity());
	}
	
	private void bearbeiteOrt(XmlHMVOrt elem) {
		ort = hmvOrtRepository.save(elem.getEntity());
	}
	
	private void bearbeiteProdukt(XmlHMVProdukt elem) {
		produkt = hmvProduktRepository.save(elem.getEntity());
	}
	
	private void bearbeiteUnterGruppe(XmlHMVUntergruppe elem) {
		unterGruppe = hmvUntergruppeRepository.save(elem.getEntity());
	}

}
