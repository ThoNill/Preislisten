package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Kunde;
import repositories.KundeRepository;

import tho.nill.preislisten.simpleAttributes.IK;

import tho.nill.preislisten.simpleAttributes.Tarifbereich;

import tho.nill.preislisten.simpleAttributes.Abrechnungscode;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
public class KundeEntityService  {

    	@Autowired
    	KundeRepository repo;



    	public KundeEntityService() {
    		super();
    	}

    	public Optional<Kunde> get(long id) {
    		return repo.findById(id);
    	}

    	public Kunde create(IK  ik, Tarifbereich  tarifbereich, Abrechnungscode  abrechnungscode, String  ansprechpartner, String  firma, String  plz, String  ort, String  straße, String  telefon, String  email) {
    		Kunde d = new Kunde();
    		felderSetzen(d, ik, tarifbereich, abrechnungscode, ansprechpartner, firma, plz, ort, straße, telefon, email);
    		return repo.save(d);
    	}

    	public void update(long id, IK  ik, Tarifbereich  tarifbereich, Abrechnungscode  abrechnungscode, String  ansprechpartner, String  firma, String  plz, String  ort, String  straße, String  telefon, String  email) {
    		Kunde d = repo.getOne(id);
    		felderSetzen(d, ik, tarifbereich, abrechnungscode, ansprechpartner, firma, plz, ort, straße, telefon, email);
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(Kunde d, 
    	IK  ik, Tarifbereich  tarifbereich, Abrechnungscode  abrechnungscode, String  ansprechpartner, String  firma, String  plz, String  ort, String  straße, String  telefon, String  email
    	) {
    	d.setIk(ik);
    	d.setTarifbereich(tarifbereich);
    	d.setAbrechnungscode(abrechnungscode);
    	d.setAnsprechpartner(ansprechpartner);
    	d.setFirma(firma);
    	d.setPlz(plz);
    	d.setOrt(ort);
    	d.setStraße(straße);
    	d.setTelefon(telefon);
    	d.setEmail(email);
    	
    	}


}