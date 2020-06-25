package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.HMVProdukt;
import repositories.HMVProduktRepository;

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
public class HMVProduktEntityService  {

    	@Autowired
    	HMVProduktRepository repo;

    	@Autowired
    	repositories.HMVArtRepository hmvartRepo;


    	public HMVProduktEntityService() {
    		super();
    	}

    	public Optional<HMVProdukt> get(long id) {
    		return repo.findById(id);
    	}

    	public HMVProdukt create(String  hilfsmittelnr, String  produkt, String  bezeichnung, String  hersteller, String  merkmal, long hmvart 
    ) {
    		HMVProdukt d = new HMVProdukt();
    		felderSetzen(d, hilfsmittelnr, produkt, bezeichnung, hersteller, merkmal, hmvart
    );
    		return repo.save(d);
    	}

    	public void update(long id, String  hilfsmittelnr, String  produkt, String  bezeichnung, String  hersteller, String  merkmal, long hmvart 
    ) {
    		HMVProdukt d = repo.getOne(id);
    		felderSetzen(d, hilfsmittelnr, produkt, bezeichnung, hersteller, merkmal, hmvart
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(HMVProdukt d, 
    	String  hilfsmittelnr, String  produkt, String  bezeichnung, String  hersteller, String  merkmal, long hmvart 

    	) {
    	d.setHilfsmittelnr(hilfsmittelnr);
    	d.setProdukt(produkt);
    	d.setBezeichnung(bezeichnung);
    	d.setHersteller(hersteller);
    	d.setMerkmal(merkmal);

    	if (hmvart > 0) {
    	   Optional<entities.HMVArt> hmvartEntity =  hmvartRepo.findById(hmvart);
    	   if (hmvartEntity.isPresent()) {
    	   	  d.setHMVArt(hmvartEntity.get());
    	   }
    	}  	
    	}


}