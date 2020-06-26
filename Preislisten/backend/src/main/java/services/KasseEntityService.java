package services;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Kasse;
import repositories.KasseRepository;
import tho.nill.preislisten.simpleAttributes.DFÜMedium;
import tho.nill.preislisten.simpleAttributes.DFÜParameter;
import tho.nill.preislisten.simpleAttributes.DFÜProtokoll;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KasseArt;
import tho.nill.preislisten.simpleAttributes.KassenFunktion;
import tho.nill.preislisten.simpleAttributes.Komprimierungsart;
import tho.nill.preislisten.simpleAttributes.Übermittlungszeichensatz;
import tho.nill.preislisten.simpleAttributes.Übertragungstage;

@Service
public class KasseEntityService  {

    	@Autowired
    	KasseRepository repo;

    	@Autowired
    	repositories.VersandZielRepository versandzielRepo;


    	public KasseEntityService() {
    		super();
    	}

    	public Optional<Kasse> get(long id) {
    		return repo.findById(id);
    	}

    	public Kasse create(IK  ik, KasseArt  art, KassenFunktion  funktion, String  firma, String  plz, String  ort, String  straße, String  email, LocalDate  gültigAb, LocalDate  gültigBis, String  iban, String  bic, String  kontoinhaber, String  name, String  name2, String  name3, String  name4, String  ansprechpartner, String  telefon, String  fax, String  arbeitsgebiet, DFÜMedium  medium, DFÜParameter  parameter, Übermittlungszeichensatz  zeichensatz, Komprimierungsart  komprimierung, DFÜProtokoll  protokoll, String  benutzerkennung, String  übertragung_von, String  übertragung_bis, Übertragungstage  übertragungstage, String  kommunikationskanal, long versandziel 
    ) {
    		Kasse d = new Kasse();
    		felderSetzen(d, ik, art, funktion, firma, plz, ort, straße, email, gültigAb, gültigBis, iban, bic, kontoinhaber, name, name2, name3, name4, ansprechpartner, telefon, fax, arbeitsgebiet, medium, parameter, zeichensatz, komprimierung, protokoll, benutzerkennung, übertragung_von, übertragung_bis, übertragungstage, kommunikationskanal, versandziel
    );
    		return repo.save(d);
    	}

    	public void update(long id, IK  ik, KasseArt  art, KassenFunktion  funktion, String  firma, String  plz, String  ort, String  straße, String  email, LocalDate  gültigAb, LocalDate  gültigBis, String  iban, String  bic, String  kontoinhaber, String  name, String  name2, String  name3, String  name4, String  ansprechpartner, String  telefon, String  fax, String  arbeitsgebiet, DFÜMedium  medium, DFÜParameter  parameter, Übermittlungszeichensatz  zeichensatz, Komprimierungsart  komprimierung, DFÜProtokoll  protokoll, String  benutzerkennung, String  übertragung_von, String  übertragung_bis, Übertragungstage  übertragungstage, String  kommunikationskanal, long versandziel 
    ) {
    		Kasse d = repo.getOne(id);
    		felderSetzen(d, ik, art, funktion, firma, plz, ort, straße, email, gültigAb, gültigBis, iban, bic, kontoinhaber, name, name2, name3, name4, ansprechpartner, telefon, fax, arbeitsgebiet, medium, parameter, zeichensatz, komprimierung, protokoll, benutzerkennung, übertragung_von, übertragung_bis, übertragungstage, kommunikationskanal, versandziel
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(Kasse d, 
    	IK  ik, KasseArt  art, KassenFunktion  funktion, String  firma, String  plz, String  ort, String  straße, String  email, LocalDate  gültigAb, LocalDate  gültigBis, String  iban, String  bic, String  kontoinhaber, String  name, String  name2, String  name3, String  name4, String  ansprechpartner, String  telefon, String  fax, String  arbeitsgebiet, DFÜMedium  medium, DFÜParameter  parameter, Übermittlungszeichensatz  zeichensatz, Komprimierungsart  komprimierung, DFÜProtokoll  protokoll, String  benutzerkennung, String  übertragung_von, String  übertragung_bis, Übertragungstage  übertragungstage, String  kommunikationskanal, long versandziel 

    	) {
    	d.setIk(ik);
    	d.setArt(art);
    	d.setFunktion(funktion);
    	d.setFirma(firma);
    	d.setPlz(plz);
    	d.setOrt(ort);
    	d.setStraße(straße);
    	d.setEmail(email);
    	d.setIban(iban);
    	d.setBic(bic);
    	d.setKontoinhaber(kontoinhaber);
    	d.setName(name);
    	d.setName2(name2);
    	d.setName3(name3);
    	d.setName4(name4);
    	d.setAnsprechpartner(ansprechpartner);
    	d.setTelefon(telefon);
    	d.setFax(fax);
    	d.setArbeitsgebiet(arbeitsgebiet);
    	d.setMedium(medium);
    	d.setParameter(parameter);
    	d.setZeichensatz(zeichensatz);
    	d.setKomprimierung(komprimierung);
    	d.setProtokoll(protokoll);
    	d.setBenutzerkennung(benutzerkennung);
    	d.setÜbertragung_von(übertragung_von);
    	d.setÜbertragung_bis(übertragung_bis);
    	d.setÜbertragungstage(übertragungstage);
    	d.setKommunikationskanal(kommunikationskanal);

    	if (versandziel > 0) {
    	    Optional<entities.VersandZiel> versandzielEntity =  versandzielRepo.findById(versandziel);
    	    if (versandzielEntity.isPresent()) {
    	       d.addVersandZiel(versandzielEntity.get());
    	    }
    	}	
    	}


}