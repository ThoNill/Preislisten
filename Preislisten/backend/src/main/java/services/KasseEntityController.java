package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Kasse;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KasseArt;
import tho.nill.preislisten.simpleAttributes.KassenFunktion;



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
    , @RequestParam(name = "ansprechpartner") String ansprechpartner
     // value
    , @RequestParam(name = "firma") String firma
     // value
    , @RequestParam(name = "plz") String plz
     // value
    , @RequestParam(name = "ort") String ort
     // value
    , @RequestParam(name = "straße") String straße
     // value
    , @RequestParam(name = "telefon") String telefon
     // value
    , @RequestParam(name = "email") String email
     // value
    , @RequestParam(name = "versandziel") long versandziel // VersandZiel
     // fromone2many
    ) {

    		try {
    			Kasse d = service.create(ik, art, funktion, ansprechpartner, firma, plz, ort, straße, telefon, email, versandziel);
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
    	              , @RequestParam(name = "ansprechpartner") String ansprechpartner
    	               // value
    	              , @RequestParam(name = "firma") String firma
    	               // value
    	              , @RequestParam(name = "plz") String plz
    	               // value
    	              , @RequestParam(name = "ort") String ort
    	               // value
    	              , @RequestParam(name = "straße") String straße
    	               // value
    	              , @RequestParam(name = "telefon") String telefon
    	               // value
    	              , @RequestParam(name = "email") String email
    	               // value
    	              , @RequestParam(name = "versandziel") long versandziel // VersandZiel
    	               // fromone2many
    ) {

    		try {
    			service.update(id,ik, art, funktion, ansprechpartner, firma, plz, ort, straße, telefon, email, versandziel);
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