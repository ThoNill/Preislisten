package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.HMVArt;
import repositories.HMVArtRepository;

import java.lang.Long;

import java.lang.Long;

import java.lang.Long;

import java.lang.Long;

import java.lang.String;

import org.nill.vorlagen.compiler.markerClasses.CharBLOB;

import org.nill.vorlagen.compiler.markerClasses.CharBLOB;




import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
public class HMVArtEntityService  {

    	@Autowired
    	HMVArtRepository repo;

    	@Autowired
    	repositories.HMVUntergruppeRepository hmvuntergruppeRepo;
    	@Autowired
    	repositories.HMVProduktRepository hmvproduktRepo;


    	public HMVArtEntityService() {
    		super();
    	}

    	public Optional<HMVArt> get(long id) {
    		return repo.findById(id);
    	}

    	public HMVArt create(Long  art, Long  gruppe, Long  untergruppe, Long  ort, String  bezeichnung, String  beschreibung, String  indikation, long hmvuntergruppe 
    , long hmvprodukt 
    ) {
    		HMVArt d = new HMVArt();
    		felderSetzen(d, art, gruppe, untergruppe, ort, bezeichnung, beschreibung, indikation, hmvuntergruppe
    , hmvprodukt
    );
    		return repo.save(d);
    	}

    	public void update(long id, Long  art, Long  gruppe, Long  untergruppe, Long  ort, String  bezeichnung, String  beschreibung, String  indikation, long hmvuntergruppe 
    , long hmvprodukt 
    ) {
    		HMVArt d = repo.getOne(id);
    		felderSetzen(d, art, gruppe, untergruppe, ort, bezeichnung, beschreibung, indikation, hmvuntergruppe
    , hmvprodukt
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(HMVArt d, 
    	Long  art, Long  gruppe, Long  untergruppe, Long  ort, String  bezeichnung, String  beschreibung, String  indikation, long hmvuntergruppe 
    	, long hmvprodukt 

    	) {
    	d.setArt(art);
    	d.setGruppe(gruppe);
    	d.setUntergruppe(untergruppe);
    	d.setOrt(ort);
    	d.setBezeichnung(bezeichnung);

    	if (hmvuntergruppe > 0) {
    	   Optional<entities.HMVUntergruppe> hmvuntergruppeEntity =  hmvuntergruppeRepo.findById(hmvuntergruppe);
    	   if (hmvuntergruppeEntity.isPresent()) {
    	   	  d.setHMVUntergruppe(hmvuntergruppeEntity.get());
    	   }
    	}  
    	if (hmvprodukt > 0) {
    	    Optional<entities.HMVProdukt> hmvproduktEntity =  hmvproduktRepo.findById(hmvprodukt);
    	    if (hmvproduktEntity.isPresent()) {
    	       d.addHMVProdukt(hmvproduktEntity.get());
    	    }
    	}	
    	}


}