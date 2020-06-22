package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Kasse;
import repositories.KasseRepository;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KasseArt;
import tho.nill.preislisten.simpleAttributes.KassenFunktion;

@Service
public class KasseEntityService  {

    	@Autowired
    	KasseRepository repo;

    	@Autowired
    	repositories.VersandZielRepository versandzielRepo;


    	public KasseEntityService() {
    		super();
    	}

    	public Optional<Kasse> get(long id) {
    		return repo.findById(id);
    	}

    	public Kasse create(IK  ik, KasseArt  art, KassenFunktion  funktion, String  ansprechpartner, String  firma, String  plz, String  ort, String  straße, String  telefon, String  email, long versandziel 
    ) {
    		Kasse d = new Kasse();
    		felderSetzen(d, ik, art, funktion, ansprechpartner, firma, plz, ort, straße, telefon, email, versandziel
    );
    		return repo.save(d);
    	}

    	public void update(long id, IK  ik, KasseArt  art, KassenFunktion  funktion, String  ansprechpartner, String  firma, String  plz, String  ort, String  straße, String  telefon, String  email, long versandziel 
    ) {
    		Kasse d = repo.getOne(id);
    		felderSetzen(d, ik, art, funktion, ansprechpartner, firma, plz, ort, straße, telefon, email, versandziel
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(Kasse d, 
    	IK  ik, KasseArt  art, KassenFunktion  funktion, String  ansprechpartner, String  firma, String  plz, String  ort, String  straße, String  telefon, String  email, long versandziel 

    	) {
    	d.setIk(ik);
    	d.setArt(art);
    	d.setFunktion(funktion);
    	d.setAnsprechpartner(ansprechpartner);
    	d.setFirma(firma);
    	d.setPlz(plz);
    	d.setOrt(ort);
    	d.setStraße(straße);
    	d.setTelefon(telefon);
    	d.setEmail(email);

    	if (versandziel > 0) {
    	    Optional<entities.VersandZiel> versandzielEntity =  versandzielRepo.findById(versandziel);
    	    if (versandzielEntity.isPresent()) {
    	       d.addVersandZiel(versandzielEntity.get());
    	    }
    	}	
    	}


}