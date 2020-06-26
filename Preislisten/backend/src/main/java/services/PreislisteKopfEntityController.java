package services;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.PreislisteKopf;
import tho.nill.preislisten.simpleAttributes.DatumArt;
import tho.nill.preislisten.simpleAttributes.PreislisteArt;




@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class PreislisteKopfEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der PreislisteKopf Datensatz mit der ";
    	@Autowired
    	private PreislisteKopfEntityService service;

    	public PreislisteKopfEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislistekopf/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "art") PreislisteArt art
     // enumeration
    , @RequestParam(name = "tarifkennzeichen") String tarifkennzeichen
     // value
    , @RequestParam(name = "gültigAb") LocalDate gültigAb
     // LocalDate
    , @RequestParam(name = "dart") DatumArt dart
     // enumeration
    , @RequestParam(name = "preislistebezug") long preislistebezug // PreislisteBezug
     // fromone2many
    , @RequestParam(name = "preislisteposition") long preislisteposition // PreislistePosition
     // fromone2many
    ) {

    		try {
    			PreislisteKopf d = service.create(art, tarifkennzeichen, gültigAb, dart, preislistebezug, preislisteposition);
    			return DER_DATENSATZ_MIT_DER + d.getPreislisteKopfId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines PreislisteKopf Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislistekopf/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "art") PreislisteArt art
    	               // enumeration
    	              , @RequestParam(name = "tarifkennzeichen") String tarifkennzeichen
    	               // value
    	              , @RequestParam(name = "gültigAb") LocalDate gültigAb
    	               // LocalDate
    	              , @RequestParam(name = "dart") DatumArt dart
    	               // enumeration
    	              , @RequestParam(name = "preislistebezug") long preislistebezug // PreislisteBezug
    	               // fromone2many
    	              , @RequestParam(name = "preislisteposition") long preislisteposition // PreislistePosition
    	               // fromone2many
    ) {

    		try {
    			service.update(id,art, tarifkennzeichen, gültigAb, dart, preislistebezug, preislisteposition);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des PreislisteKopf Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislistekopf/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des PreislisteKopf Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/preislistekopf/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public PreislisteKopf get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<PreislisteKopf> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}