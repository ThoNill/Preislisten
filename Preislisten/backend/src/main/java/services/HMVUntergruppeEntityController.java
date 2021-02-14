package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.HMVUntergruppe;

import java.lang.Long;

import java.lang.Long;

import java.lang.Long;

import org.nill.vorlagen.compiler.markerClasses.CharBLOB;

import org.nill.vorlagen.compiler.markerClasses.CharBLOB;





@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class HMVUntergruppeEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der HMVUntergruppe Datensatz mit der ";
    	@Autowired
    	private HMVUntergruppeEntityService service;

    	public HMVUntergruppeEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvuntergruppe/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "gruppe") Long gruppe
     // value
    , @RequestParam(name = "untergruppe") Long untergruppe
     // value
    , @RequestParam(name = "ort") Long ort
     // value
    , @RequestParam(name = "bezeichnung") String bezeichnung
     // CharBLOB
    , @RequestParam(name = "anforderungen") String anforderungen
     // CharBLOB
    , @RequestParam(name = "hmvgruppe") long hmvgruppe // HMVGruppe
     // toone2many
    , @RequestParam(name = "hmvort") long hmvort // HMVOrt
     // toone2many
    , @RequestParam(name = "hmvart") long hmvart // HMVArt
     // fromone2many
    ) {

    		try {
    			HMVUntergruppe d = service.create(gruppe, untergruppe, ort, bezeichnung, anforderungen, hmvgruppe, hmvort, hmvart);
    			return DER_DATENSATZ_MIT_DER + d.getHMVUntergruppeId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines HMVUntergruppe Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvuntergruppe/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "gruppe") Long gruppe
    	               // value
    	              , @RequestParam(name = "untergruppe") Long untergruppe
    	               // value
    	              , @RequestParam(name = "ort") Long ort
    	               // value
    	              , @RequestParam(name = "bezeichnung") String bezeichnung
    	               // CharBLOB
    	              , @RequestParam(name = "anforderungen") String anforderungen
    	               // CharBLOB
    	              , @RequestParam(name = "hmvgruppe") long hmvgruppe // HMVGruppe
    	               // toone2many
    	              , @RequestParam(name = "hmvort") long hmvort // HMVOrt
    	               // toone2many
    	              , @RequestParam(name = "hmvart") long hmvart // HMVArt
    	               // fromone2many
    ) {

    		try {
    			service.update(id,gruppe, untergruppe, ort, bezeichnung, anforderungen, hmvgruppe, hmvort, hmvart);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des HMVUntergruppe Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvuntergruppe/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des HMVUntergruppe Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvuntergruppe/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public HMVUntergruppe get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<HMVUntergruppe> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}