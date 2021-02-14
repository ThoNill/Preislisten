package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.HMVProdukt;
import repositories.HMVProduktRepository;

import java.lang.Long;

import java.lang.Long;

import java.lang.Long;

import java.lang.Long;

import java.lang.Long;

import java.lang.String;

import org.nill.vorlagen.compiler.markerClasses.CharBLOB;

import java.lang.String;

import org.nill.vorlagen.compiler.markerClasses.CharBLOB;

import java.time.LocalDate;



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

    	public HMVProdukt create(Long  produkt, Long  art, Long  gruppe, Long  untergruppe, Long  ort, String  hilfsmittelnr, String  bezeichnung, String  hersteller, String  merkmale, LocalDate  änderung, long hmvart 
    ) {
    		HMVProdukt d = new HMVProdukt();
    		felderSetzen(d, produkt, art, gruppe, untergruppe, ort, hilfsmittelnr, bezeichnung, hersteller, merkmale, änderung, hmvart
    );
    		return repo.save(d);
    	}

    	public void update(long id, Long  produkt, Long  art, Long  gruppe, Long  untergruppe, Long  ort, String  hilfsmittelnr, String  bezeichnung, String  hersteller, String  merkmale, LocalDate  änderung, long hmvart 
    ) {
    		HMVProdukt d = repo.getOne(id);
    		felderSetzen(d, produkt, art, gruppe, untergruppe, ort, hilfsmittelnr, bezeichnung, hersteller, merkmale, änderung, hmvart
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(HMVProdukt d, 
    	Long  produkt, Long  art, Long  gruppe, Long  untergruppe, Long  ort, String  hilfsmittelnr, String  bezeichnung, String  hersteller, String  merkmale, LocalDate  änderung, long hmvart 

    	) {
    	d.setProdukt(produkt);
    	d.setArt(art);
    	d.setGruppe(gruppe);
    	d.setUntergruppe(untergruppe);
    	d.setOrt(ort);
    	d.setHilfsmittelnr(hilfsmittelnr);
    	d.setHersteller(hersteller);

    	if (hmvart > 0) {
    	   Optional<entities.HMVArt> hmvartEntity =  hmvartRepo.findById(hmvart);
    	   if (hmvartEntity.isPresent()) {
    	   	  d.setHMVArt(hmvartEntity.get());
    	   }
    	}  	
    	}


}