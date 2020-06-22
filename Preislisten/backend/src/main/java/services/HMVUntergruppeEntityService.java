package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.HMVUntergruppe;
import repositories.HMVUntergruppeRepository;

@Service
public class HMVUntergruppeEntityService  {

    	@Autowired
    	HMVUntergruppeRepository repo;

    	@Autowired
    	repositories.HMVGruppeRepository hmvgruppeRepo;
    	@Autowired
    	repositories.HMVOrtRepository hmvortRepo;
    	@Autowired
    	repositories.HMVArtRepository hmvartRepo;


    	public HMVUntergruppeEntityService() {
    		super();
    	}

    	public Optional<HMVUntergruppe> get(long id) {
    		return repo.findById(id);
    	}

    	public HMVUntergruppe create(String  untergruppe, String  bezeichnung, String  anforderungen, long hmvgruppe 
    , long hmvort 
    , long hmvart 
    ) {
    		HMVUntergruppe d = new HMVUntergruppe();
    		felderSetzen(d, untergruppe, bezeichnung, anforderungen, hmvgruppe
    , hmvort
    , hmvart
    );
    		return repo.save(d);
    	}

    	public void update(long id, String  untergruppe, String  bezeichnung, String  anforderungen, long hmvgruppe 
    , long hmvort 
    , long hmvart 
    ) {
    		HMVUntergruppe d = repo.getOne(id);
    		felderSetzen(d, untergruppe, bezeichnung, anforderungen, hmvgruppe
    , hmvort
    , hmvart
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(HMVUntergruppe d, 
    	String  untergruppe, String  bezeichnung, String  anforderungen, long hmvgruppe 
    	, long hmvort 
    	, long hmvart 

    	) {
    	d.setUntergruppe(untergruppe);
    	d.setBezeichnung(bezeichnung);
    	d.setAnforderungen(anforderungen);

    	if (hmvgruppe > 0) {
    	   Optional<entities.HMVGruppe> hmvgruppeEntity =  hmvgruppeRepo.findById(hmvgruppe);
    	   if (hmvgruppeEntity.isPresent()) {
    	   	  d.setHMVGruppe(hmvgruppeEntity.get());
    	   }
    	}  
    	if (hmvort > 0) {
    	   Optional<entities.HMVOrt> hmvortEntity =  hmvortRepo.findById(hmvort);
    	   if (hmvortEntity.isPresent()) {
    	   	  d.setHMVOrt(hmvortEntity.get());
    	   }
    	}  
    	if (hmvart > 0) {
    	    Optional<entities.HMVArt> hmvartEntity =  hmvartRepo.findById(hmvart);
    	    if (hmvartEntity.isPresent()) {
    	       d.addHMVArt(hmvartEntity.get());
    	    }
    	}	
    	}


}