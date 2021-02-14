package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.HMVOrt;
import repositories.HMVOrtRepository;

import java.lang.Long;

import java.lang.String;



import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
public class HMVOrtEntityService  {

    	@Autowired
    	HMVOrtRepository repo;

    	@Autowired
    	repositories.HMVUntergruppeRepository hmvuntergruppeRepo;


    	public HMVOrtEntityService() {
    		super();
    	}

    	public Optional<HMVOrt> get(long id) {
    		return repo.findById(id);
    	}

    	public HMVOrt create(Long  ort, String  bezeichnung, long hmvuntergruppe 
    ) {
    		HMVOrt d = new HMVOrt();
    		felderSetzen(d, ort, bezeichnung, hmvuntergruppe
    );
    		return repo.save(d);
    	}

    	public void update(long id, Long  ort, String  bezeichnung, long hmvuntergruppe 
    ) {
    		HMVOrt d = repo.getOne(id);
    		felderSetzen(d, ort, bezeichnung, hmvuntergruppe
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(HMVOrt d, 
    	Long  ort, String  bezeichnung, long hmvuntergruppe 

    	) {
    	d.setOrt(ort);
    	d.setBezeichnung(bezeichnung);

    	if (hmvuntergruppe > 0) {
    	    Optional<entities.HMVUntergruppe> hmvuntergruppeEntity =  hmvuntergruppeRepo.findById(hmvuntergruppe);
    	    if (hmvuntergruppeEntity.isPresent()) {
    	       d.addHMVUntergruppe(hmvuntergruppeEntity.get());
    	    }
    	}	
    	}


}