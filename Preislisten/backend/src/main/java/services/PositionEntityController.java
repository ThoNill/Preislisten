package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Position;

import tho.nill.preislisten.simpleAttributes.PositionsArt;

import java.lang.String;



@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class PositionEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der Position Datensatz mit der ";
    	@Autowired
    	private PositionEntityService service;

    	public PositionEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/position/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "art") PositionsArt art
     // enumeration
    , @RequestParam(name = "nummer") String nummer
     // value
    , @RequestParam(name = "preislisteposition") long preislisteposition // PreislistePosition
     // fromone2many
    ) {

    		try {
    			Position d = service.create(art, nummer, preislisteposition);
    			return DER_DATENSATZ_MIT_DER + d.getPositionId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines Position Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/position/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "art") PositionsArt art
    	               // enumeration
    	              , @RequestParam(name = "nummer") String nummer
    	               // value
    	              , @RequestParam(name = "preislisteposition") long preislisteposition // PreislistePosition
    	               // fromone2many
    ) {

    		try {
    			service.update(id,art, nummer, preislisteposition);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des Position Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/position/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des Position Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/position/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public Position get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<Position> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}