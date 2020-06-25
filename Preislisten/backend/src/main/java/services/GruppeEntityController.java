package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Gruppe;

import tho.nill.preislisten.simpleAttributes.GruppeArt;

import java.lang.Long;

import java.lang.String;

import java.lang.String;


@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class GruppeEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der Gruppe Datensatz mit der ";
    	@Autowired
    	private GruppeEntityService service;

    	public GruppeEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/gruppe/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "art") GruppeArt art
     // enumeration
    , @RequestParam(name = "nummer") Long nummer
     // value
    , @RequestParam(name = "bezeichnung") String bezeichnung
     // value
    , @RequestParam(name = "wert") String wert
     // value
    ) {

    		try {
    			Gruppe d = service.create(art, nummer, bezeichnung, wert);
    			return DER_DATENSATZ_MIT_DER + d.getGruppeId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines Gruppe Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/gruppe/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "art") GruppeArt art
    	               // enumeration
    	              , @RequestParam(name = "nummer") Long nummer
    	               // value
    	              , @RequestParam(name = "bezeichnung") String bezeichnung
    	               // value
    	              , @RequestParam(name = "wert") String wert
    	               // value
    ) {

    		try {
    			service.update(id,art, nummer, bezeichnung, wert);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des Gruppe Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/gruppe/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des Gruppe Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/gruppe/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public Gruppe get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<Gruppe> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}