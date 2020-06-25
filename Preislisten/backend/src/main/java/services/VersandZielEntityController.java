package services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.VersandZiel;

import tho.nill.preislisten.simpleAttributes.IK;

import tho.nill.preislisten.simpleAttributes.IK;

import tho.nill.preislisten.simpleAttributes.IK;

import tho.nill.preislisten.simpleAttributes.DatenlieferungsArt;

import tho.nill.preislisten.simpleAttributes.VerweisArt;

import tho.nill.preislisten.simpleAttributes.DFÜMedium;

import tho.nill.preislisten.simpleAttributes.Bundesland;

import tho.nill.preislisten.simpleAttributes.KVBezirk;

import tho.nill.preislisten.simpleAttributes.Abrechnungscode;

import tho.nill.preislisten.simpleAttributes.Tarifkennzeichen;

import tho.nill.preislisten.simpleAttributes.Leistungserbringergruppe;



@RestController
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class VersandZielEntityController  {



    	private static final String DER_DATENSATZ_MIT_DER = "Der VersandZiel Datensatz mit der ";
    	@Autowired
    	private VersandZielEntityService service;

    	public VersandZielEntityController() {
    		super();
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/versandziel/insert", produces = "application/json", method = RequestMethod.POST)
    	public String create(@RequestParam(name = "von_ik") IK von_ik
     // value
    , @RequestParam(name = "nach_ik") IK nach_ik
     // value
    , @RequestParam(name = "abrechnungsstelle") IK abrechnungsstelle
     // value
    , @RequestParam(name = "art") DatenlieferungsArt art
     // enumeration
    , @RequestParam(name = "verweis") VerweisArt verweis
     // enumeration
    , @RequestParam(name = "medium") DFÜMedium medium
     // enumeration
    , @RequestParam(name = "land") Bundesland land
     // enumeration
    , @RequestParam(name = "bezirk") KVBezirk bezirk
     // enumeration
    , @RequestParam(name = "abrechnungscode") Abrechnungscode abrechnungscode
     // enumeration
    , @RequestParam(name = "tarifkennzeichen") Tarifkennzeichen tarifkennzeichen
     // value
    , @RequestParam(name = "leistungserbringergruppe") Leistungserbringergruppe leistungserbringergruppe
     // enumeration
    , @RequestParam(name = "kasse") long kasse // Kasse
     // toone2many
    ) {

    		try {
    			VersandZiel d = service.create(von_ik, nach_ik, abrechnungsstelle, art, verweis, medium, land, bezirk, abrechnungscode, tarifkennzeichen, leistungserbringergruppe, kasse);
    			return DER_DATENSATZ_MIT_DER + d.getVersandZielId() + " wurden erfolgreich angelegt";
    		} catch (Exception e) {
    			return "Beim Anlegen eines VersandZiel Datensatzes trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/versandziel/update/{id}", produces = "application/json", method = RequestMethod.PUT)
    	public String update(@PathVariable(name = "id") long id,
    	              @RequestParam(name = "von_ik") IK von_ik
    	               // value
    	              , @RequestParam(name = "nach_ik") IK nach_ik
    	               // value
    	              , @RequestParam(name = "abrechnungsstelle") IK abrechnungsstelle
    	               // value
    	              , @RequestParam(name = "art") DatenlieferungsArt art
    	               // enumeration
    	              , @RequestParam(name = "verweis") VerweisArt verweis
    	               // enumeration
    	              , @RequestParam(name = "medium") DFÜMedium medium
    	               // enumeration
    	              , @RequestParam(name = "land") Bundesland land
    	               // enumeration
    	              , @RequestParam(name = "bezirk") KVBezirk bezirk
    	               // enumeration
    	              , @RequestParam(name = "abrechnungscode") Abrechnungscode abrechnungscode
    	               // enumeration
    	              , @RequestParam(name = "tarifkennzeichen") Tarifkennzeichen tarifkennzeichen
    	               // value
    	              , @RequestParam(name = "leistungserbringergruppe") Leistungserbringergruppe leistungserbringergruppe
    	               // enumeration
    	              , @RequestParam(name = "kasse") long kasse // Kasse
    	               // toone2many
    ) {

    		try {
    			service.update(id,von_ik, nach_ik, abrechnungsstelle, art, verweis, medium, land, bezirk, abrechnungscode, tarifkennzeichen, leistungserbringergruppe, kasse);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich geändert";
    		} catch (Exception e) {
    			return "Beim Ändern des VersandZiel Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/versandziel/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    	public String delete(@PathVariable(name = "id") long id) {

    		try {
    			service.delete(id);
    			return DER_DATENSATZ_MIT_DER + id + " wurden erfolgreich entfernt";
    		} catch (Exception e) {
    			return "Beim Entfernen des VersandZiel Datensatzes mit der " + id + " trat ein Fehler auf";
    		}
    	}

    	@CrossOrigin
    	@RequestMapping(path = "/entity/versandziel/get/{id}", produces = "application/json", method = RequestMethod.GET)
    	public VersandZiel get(@PathVariable(name = "id") long id) {

    		try {
    			Optional<VersandZiel> o = service.get(id);
    			if (o.isPresent()) {
    				return o.get();
    			}
    		} catch (Exception e) {
    			throw new RuntimeException("Exception bei get ", e);
    		}
    		return null;
    	}




}