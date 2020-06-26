package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.PreislistePosition;
import tho.nill.preislisten.simpleAttributes.Mwst;




@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class PreislistePositionEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der PreislistePosition Datensatz mit der ";
    	@Autowired
    	private PreislistePositionEntityService service;

    	public PreislistePositionEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislisteposition/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "preis") double preis
     // value
    , @RequestParam(name = "mwst") Mwst mwst
     // enumeration
    , @RequestParam(name = "preislistekopf") long preislistekopf // PreislisteKopf
     // toone2many
    , @RequestParam(name = "position") long position // Position
     // toone2many
    ) {

    		try {
    			PreislistePosition d = service.create(preis, mwst, preislistekopf, position);
    			return DER_DATENSATZ_MIT_DER + d.getPreislistePositionId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines PreislistePosition Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislisteposition/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "preis") double preis
    	               // value
    	              , @RequestParam(name = "mwst") Mwst mwst
    	               // enumeration
    	              , @RequestParam(name = "preislistekopf") long preislistekopf // PreislisteKopf
    	               // toone2many
    	              , @RequestParam(name = "position") long position // Position
    	               // toone2many
    ) {

    		try {
    			service.update(id,preis, mwst, preislistekopf, position);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des PreislistePosition Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislisteposition/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des PreislistePosition Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislisteposition/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public PreislistePosition get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<PreislistePosition> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}