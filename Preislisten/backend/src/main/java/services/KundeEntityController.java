package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Kunde;

import tho.nill.preislisten.simpleAttributes.IK;

import tho.nill.preislisten.simpleAttributes.Tarifbereich;

import tho.nill.preislisten.simpleAttributes.Abrechnungscode;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;


@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class KundeEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der Kunde Datensatz mit der ";
    	@Autowired
    	private KundeEntityService service;

    	public KundeEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/kunde/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "ik") IK ik
     // value
    , @RequestParam(name = "tarifbereich") Tarifbereich tarifbereich
     // enumeration
    , @RequestParam(name = "abrechnungscode") Abrechnungscode abrechnungscode
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
    ) {

    		try {
    			Kunde d = service.create(ik, tarifbereich, abrechnungscode, ansprechpartner, firma, plz, ort, straße, telefon, email);
    			return DER_DATENSATZ_MIT_DER + d.getKundeId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines Kunde Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/kunde/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "ik") IK ik
    	               // value
    	              , @RequestParam(name = "tarifbereich") Tarifbereich tarifbereich
    	               // enumeration
    	              , @RequestParam(name = "abrechnungscode") Abrechnungscode abrechnungscode
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
    ) {

    		try {
    			service.update(id,ik, tarifbereich, abrechnungscode, ansprechpartner, firma, plz, ort, straße, telefon, email);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des Kunde Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/kunde/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des Kunde Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/kunde/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public Kunde get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<Kunde> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}