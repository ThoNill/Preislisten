package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.HMVGruppe;

import java.lang.Long;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;



@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class HMVGruppeEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der HMVGruppe Datensatz mit der ";
    	@Autowired
    	private HMVGruppeEntityService service;

    	public HMVGruppeEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvgruppe/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "nummer") Long nummer
     // value
    , @RequestParam(name = "bezeichnung") String bezeichnung
     // value
    , @RequestParam(name = "definition") String definition
     // value
    , @RequestParam(name = "indikation") String indikation
     // value
    , @RequestParam(name = "querverweise") String querverweise
     // value
    , @RequestParam(name = "hmvuntergruppe") long hmvuntergruppe // HMVUntergruppe
     // fromone2many
    ) {

    		try {
    			HMVGruppe d = service.create(nummer, bezeichnung, definition, indikation, querverweise, hmvuntergruppe);
    			return DER_DATENSATZ_MIT_DER + d.getHMVGruppeId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines HMVGruppe Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvgruppe/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "nummer") Long nummer
    	               // value
    	              , @RequestParam(name = "bezeichnung") String bezeichnung
    	               // value
    	              , @RequestParam(name = "definition") String definition
    	               // value
    	              , @RequestParam(name = "indikation") String indikation
    	               // value
    	              , @RequestParam(name = "querverweise") String querverweise
    	               // value
    	              , @RequestParam(name = "hmvuntergruppe") long hmvuntergruppe // HMVUntergruppe
    	               // fromone2many
    ) {

    		try {
    			service.update(id,nummer, bezeichnung, definition, indikation, querverweise, hmvuntergruppe);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des HMVGruppe Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvgruppe/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des HMVGruppe Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvgruppe/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public HMVGruppe get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<HMVGruppe> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}