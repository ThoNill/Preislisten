package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.PreislisteBezug;


import tho.nill.preislisten.simpleAttributes.BezugArt;



@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class PreislisteBezugEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der PreislisteBezug Datensatz mit der ";
    	@Autowired
    	private PreislisteBezugEntityService service;

    	public PreislisteBezugEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislistebezug/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "nummer") long nummer
     // value
    , @RequestParam(name = "art") BezugArt art
     // enumeration
    , @RequestParam(name = "preislistekopf") long preislistekopf // PreislisteKopf
     // toone2many
    ) {

    		try {
    			PreislisteBezug d = service.create(nummer, art, preislistekopf);
    			return DER_DATENSATZ_MIT_DER + d.getPreislisteBezugId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines PreislisteBezug Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislistebezug/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "nummer") long nummer
    	               // value
    	              , @RequestParam(name = "art") BezugArt art
    	               // enumeration
    	              , @RequestParam(name = "preislistekopf") long preislistekopf // PreislisteKopf
    	               // toone2many
    ) {

    		try {
    			service.update(id,nummer, art, preislistekopf);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des PreislisteBezug Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislistebezug/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des PreislisteBezug Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislistebezug/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public PreislisteBezug get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<PreislisteBezug> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}