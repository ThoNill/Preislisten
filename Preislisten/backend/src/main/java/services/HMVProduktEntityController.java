package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.HMVProdukt;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;



@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class HMVProduktEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der HMVProdukt Datensatz mit der ";
    	@Autowired
    	private HMVProduktEntityService service;

    	public HMVProduktEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvprodukt/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "hilfsmittelnr") String hilfsmittelnr
     // value
    , @RequestParam(name = "produkt") String produkt
     // value
    , @RequestParam(name = "bezeichnung") String bezeichnung
     // value
    , @RequestParam(name = "hersteller") String hersteller
     // value
    , @RequestParam(name = "merkmal") String merkmal
     // value
    , @RequestParam(name = "hmvart") long hmvart // HMVArt
     // toone2many
    ) {

    		try {
    			HMVProdukt d = service.create(hilfsmittelnr, produkt, bezeichnung, hersteller, merkmal, hmvart);
    			return DER_DATENSATZ_MIT_DER + d.getHMVProduktId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines HMVProdukt Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvprodukt/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "hilfsmittelnr") String hilfsmittelnr
    	               // value
    	              , @RequestParam(name = "produkt") String produkt
    	               // value
    	              , @RequestParam(name = "bezeichnung") String bezeichnung
    	               // value
    	              , @RequestParam(name = "hersteller") String hersteller
    	               // value
    	              , @RequestParam(name = "merkmal") String merkmal
    	               // value
    	              , @RequestParam(name = "hmvart") long hmvart // HMVArt
    	               // toone2many
    ) {

    		try {
    			service.update(id,hilfsmittelnr, produkt, bezeichnung, hersteller, merkmal, hmvart);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des HMVProdukt Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvprodukt/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des HMVProdukt Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/hmvprodukt/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public HMVProdukt get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<HMVProdukt> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}