package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.HMVOrt;



@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class HMVOrtEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der HMVOrt Datensatz mit der ";
    	@Autowired
    	private HMVOrtEntityService service;

    	public HMVOrtEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvort/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "ort") Long ort
     // value
    , @RequestParam(name = "bezeichnung") String bezeichnung
     // value
    , @RequestParam(name = "hmvuntergruppe") long hmvuntergruppe // HMVUntergruppe
     // fromone2many
    ) {

    		try {
    			HMVOrt d = service.create(ort, bezeichnung, hmvuntergruppe);
    			return DER_DATENSATZ_MIT_DER + d.getHMVOrtId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines HMVOrt Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvort/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "ort") Long ort
    	               // value
    	              , @RequestParam(name = "bezeichnung") String bezeichnung
    	               // value
    	              , @RequestParam(name = "hmvuntergruppe") long hmvuntergruppe // HMVUntergruppe
    	               // fromone2many
    ) {

    		try {
    			service.update(id,ort, bezeichnung, hmvuntergruppe);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des HMVOrt Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvort/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des HMVOrt Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvort/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public HMVOrt get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<HMVOrt> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}