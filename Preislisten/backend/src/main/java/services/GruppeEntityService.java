package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Gruppe;
import repositories.GruppeRepository;

import tho.nill.preislisten.simpleAttributes.GruppeArt;

import java.lang.Long;

import java.lang.String;

import java.lang.String;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
public class GruppeEntityService  {

    	@Autowired
    	GruppeRepository repo;



    	public GruppeEntityService() {
    		super();
    	}

    	public Optional<Gruppe> get(long id) {
    		return repo.findById(id);
    	}

    	public Gruppe create(GruppeArt  art, Long  nummer, String  bezeichnung, String  wert) {
    		Gruppe d = new Gruppe();
    		felderSetzen(d, art, nummer, bezeichnung, wert);
    		return repo.save(d);
    	}

    	public void update(long id, GruppeArt  art, Long  nummer, String  bezeichnung, String  wert) {
    		Gruppe d = repo.getOne(id);
    		felderSetzen(d, art, nummer, bezeichnung, wert);
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(Gruppe d, 
    	GruppeArt  art, Long  nummer, String  bezeichnung, String  wert
    	) {
    	d.setArt(art);
    	d.setNummer(nummer);
    	d.setBezeichnung(bezeichnung);
    	d.setWert(wert);
    	
    	}


}