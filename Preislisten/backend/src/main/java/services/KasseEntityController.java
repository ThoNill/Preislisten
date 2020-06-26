package services;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Kasse;
import tho.nill.preislisten.simpleAttributes.DFÜMedium;
import tho.nill.preislisten.simpleAttributes.DFÜParameter;
import tho.nill.preislisten.simpleAttributes.DFÜProtokoll;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KasseArt;
import tho.nill.preislisten.simpleAttributes.KassenFunktion;
import tho.nill.preislisten.simpleAttributes.Komprimierungsart;
import tho.nill.preislisten.simpleAttributes.Übermittlungszeichensatz;
import tho.nill.preislisten.simpleAttributes.Übertragungstage;



@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class KasseEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der Kasse Datensatz mit der ";
    	@Autowired
    	private KasseEntityService service;

    	public KasseEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/kasse/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "ik") IK ik
     // value
    , @RequestParam(name = "art") KasseArt art
     // enumeration
    , @RequestParam(name = "funktion") KassenFunktion funktion
     // enumeration
    , @RequestParam(name = "firma") String firma
     // value
    , @RequestParam(name = "plz") String plz
     // value
    , @RequestParam(name = "ort") String ort
     // value
    , @RequestParam(name = "straße") String straße
     // value
    , @RequestParam(name = "email") String email
     // value
    , @RequestParam(name = "gültigAb") LocalDate gültigAb
     // LocalDate
    , @RequestParam(name = "gültigBis") LocalDate gültigBis
     // LocalDate
    , @RequestParam(name = "iban") String iban
     // value
    , @RequestParam(name = "bic") String bic
     // value
    , @RequestParam(name = "kontoinhaber") String kontoinhaber
     // value
    , @RequestParam(name = "name") String name
     // value
    , @RequestParam(name = "name2") String name2
     // value
    , @RequestParam(name = "name3") String name3
     // value
    , @RequestParam(name = "name4") String name4
     // value
    , @RequestParam(name = "ansprechpartner") String ansprechpartner
     // value
    , @RequestParam(name = "telefon") String telefon
     // value
    , @RequestParam(name = "fax") String fax
     // value
    , @RequestParam(name = "arbeitsgebiet") String arbeitsgebiet
     // value
    , @RequestParam(name = "medium") DFÜMedium medium
     // enumeration
    , @RequestParam(name = "parameter") DFÜParameter parameter
     // enumeration
    , @RequestParam(name = "zeichensatz") Übermittlungszeichensatz zeichensatz
     // enumeration
    , @RequestParam(name = "komprimierung") Komprimierungsart komprimierung
     // enumeration
    , @RequestParam(name = "protokoll") DFÜProtokoll protokoll
     // enumeration
    , @RequestParam(name = "benutzerkennung") String benutzerkennung
     // value
    , @RequestParam(name = "übertragung_von") String übertragung_von
     // value
    , @RequestParam(name = "übertragung_bis") String übertragung_bis
     // value
    , @RequestParam(name = "übertragungstage") Übertragungstage übertragungstage
     // enumeration
    , @RequestParam(name = "kommunikationskanal") String kommunikationskanal
     // value
    , @RequestParam(name = "versandziel") long versandziel // VersandZiel
     // fromone2many
    ) {

    		try {
    			Kasse d = service.create(ik, art, funktion, firma, plz, ort, straße, email, gültigAb, gültigBis, iban, bic, kontoinhaber, name, name2, name3, name4, ansprechpartner, telefon, fax, arbeitsgebiet, medium, parameter, zeichensatz, komprimierung, protokoll, benutzerkennung, übertragung_von, übertragung_bis, übertragungstage, kommunikationskanal, versandziel);
    			return DER_DATENSATZ_MIT_DER + d.getKasseId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines Kasse Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/kasse/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "ik") IK ik
    	               // value
    	              , @RequestParam(name = "art") KasseArt art
    	               // enumeration
    	              , @RequestParam(name = "funktion") KassenFunktion funktion
    	               // enumeration
    	              , @RequestParam(name = "firma") String firma
    	               // value
    	              , @RequestParam(name = "plz") String plz
    	               // value
    	              , @RequestParam(name = "ort") String ort
    	               // value
    	              , @RequestParam(name = "straße") String straße
    	               // value
    	              , @RequestParam(name = "email") String email
    	               // value
    	              , @RequestParam(name = "gültigAb") LocalDate gültigAb
    	               // LocalDate
    	              , @RequestParam(name = "gültigBis") LocalDate gültigBis
    	               // LocalDate
    	              , @RequestParam(name = "iban") String iban
    	               // value
    	              , @RequestParam(name = "bic") String bic
    	               // value
    	              , @RequestParam(name = "kontoinhaber") String kontoinhaber
    	               // value
    	              , @RequestParam(name = "name") String name
    	               // value
    	              , @RequestParam(name = "name2") String name2
    	               // value
    	              , @RequestParam(name = "name3") String name3
    	               // value
    	              , @RequestParam(name = "name4") String name4
    	               // value
    	              , @RequestParam(name = "ansprechpartner") String ansprechpartner
    	               // value
    	              , @RequestParam(name = "telefon") String telefon
    	               // value
    	              , @RequestParam(name = "fax") String fax
    	               // value
    	              , @RequestParam(name = "arbeitsgebiet") String arbeitsgebiet
    	               // value
    	              , @RequestParam(name = "medium") DFÜMedium medium
    	               // enumeration
    	              , @RequestParam(name = "parameter") DFÜParameter parameter
    	               // enumeration
    	              , @RequestParam(name = "zeichensatz") Übermittlungszeichensatz zeichensatz
    	               // enumeration
    	              , @RequestParam(name = "komprimierung") Komprimierungsart komprimierung
    	               // enumeration
    	              , @RequestParam(name = "protokoll") DFÜProtokoll protokoll
    	               // enumeration
    	              , @RequestParam(name = "benutzerkennung") String benutzerkennung
    	               // value
    	              , @RequestParam(name = "übertragung_von") String übertragung_von
    	               // value
    	              , @RequestParam(name = "übertragung_bis") String übertragung_bis
    	               // value
    	              , @RequestParam(name = "übertragungstage") Übertragungstage übertragungstage
    	               // enumeration
    	              , @RequestParam(name = "kommunikationskanal") String kommunikationskanal
    	               // value
    	              , @RequestParam(name = "versandziel") long versandziel // VersandZiel
    	               // fromone2many
    ) {

    		try {
    			service.update(id,ik, art, funktion, firma, plz, ort, straße, email, gültigAb, gültigBis, iban, bic, kontoinhaber, name, name2, name3, name4, ansprechpartner, telefon, fax, arbeitsgebiet, medium, parameter, zeichensatz, komprimierung, protokoll, benutzerkennung, übertragung_von, übertragung_bis, übertragungstage, kommunikationskanal, versandziel);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des Kasse Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/kasse/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des Kasse Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/kasse/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public Kasse get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<Kasse> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}