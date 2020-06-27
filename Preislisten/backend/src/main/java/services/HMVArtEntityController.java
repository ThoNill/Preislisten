package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.HMVArt;




@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class HMVArtEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der HMVArt Datensatz mit der ";
    	@Autowired
    	private HMVArtEntityService service;

    	public HMVArtEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvart/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "art") Long art
     // value
    , @RequestParam(name = "gruppe") Long gruppe
     // value
    , @RequestParam(name = "untergruppe") Long untergruppe
     // value
    , @RequestParam(name = "ort") Long ort
     // value
    , @RequestParam(name = "bezeichnung") String bezeichnung
     // value
    , @RequestParam(name = "beschreibung") String beschreibung
     // CharBLOB
    , @RequestParam(name = "indikation") String indikation
     // CharBLOB
    , @RequestParam(name = "hmvuntergruppe") long hmvuntergruppe // HMVUntergruppe
     // toone2many
    , @RequestParam(name = "hmvprodukt") long hmvprodukt // HMVProdukt
     // fromone2many
    ) {

    		try {
    			HMVArt d = service.create(art, gruppe, untergruppe, ort, bezeichnung, beschreibung, indikation, hmvuntergruppe, hmvprodukt);
    			return DER_DATENSATZ_MIT_DER + d.getHMVArtId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines HMVArt Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvart/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "art") Long art
    	               // value
    	              , @RequestParam(name = "gruppe") Long gruppe
    	               // value
    	              , @RequestParam(name = "untergruppe") Long untergruppe
    	               // value
    	              , @RequestParam(name = "ort") Long ort
    	               // value
    	              , @RequestParam(name = "bezeichnung") String bezeichnung
    	               // value
    	              , @RequestParam(name = "beschreibung") String beschreibung
    	               // CharBLOB
    	              , @RequestParam(name = "indikation") String indikation
    	               // CharBLOB
    	              , @RequestParam(name = "hmvuntergruppe") long hmvuntergruppe // HMVUntergruppe
    	               // toone2many
    	              , @RequestParam(name = "hmvprodukt") long hmvprodukt // HMVProdukt
    	               // fromone2many
    ) {

    		try {
    			service.update(id,art, gruppe, untergruppe, ort, bezeichnung, beschreibung, indikation, hmvuntergruppe, hmvprodukt);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des HMVArt Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvart/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des HMVArt Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvart/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public HMVArt get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<HMVArt> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}