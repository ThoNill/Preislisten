package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.HMVArt;
import repositories.HMVArtRepository;

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

    	public HMVArt create(String  art, String  bezeichnung, String  definition, String  indikation, long hmvuntergruppe 
    , long hmvprodukt 
    ) {
    		HMVArt d = new HMVArt();
    		felderSetzen(d, art, bezeichnung, definition, indikation, hmvuntergruppe
    , hmvprodukt
    );
    		return repo.save(d);
    	}

    	public void update(long id, String  art, String  bezeichnung, String  definition, String  indikation, long hmvuntergruppe 
    , long hmvprodukt 
    ) {
    		HMVArt d = repo.getOne(id);
    		felderSetzen(d, art, bezeichnung, definition, indikation, hmvuntergruppe
    , hmvprodukt
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(HMVArt d, 
    	String  art, String  bezeichnung, String  definition, String  indikation, long hmvuntergruppe 
    	, long hmvprodukt 

    	) {
    	d.setArt(art);
    	d.setBezeichnung(bezeichnung);
    	d.setDefinition(definition);
    	d.setIndikation(indikation);

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