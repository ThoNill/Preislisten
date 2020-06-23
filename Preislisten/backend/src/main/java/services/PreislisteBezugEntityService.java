package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.PreislisteBezug;
import repositories.PreislisteBezugRepository;
import tho.nill.preislisten.simpleAttributes.BezugArt;

@Service
public class PreislisteBezugEntityService  {

    	@Autowired
    	PreislisteBezugRepository repo;

    	@Autowired
    	repositories.PreislisteKopfRepository preislistekopfRepo;


    	public PreislisteBezugEntityService() {
    		super();
    	}

    	public Optional<PreislisteBezug> get(long id) {
    		return repo.findById(id);
    	}

    	public PreislisteBezug create(long  nummer, BezugArt  art, long preislistekopf 
    ) {
    		PreislisteBezug d = new PreislisteBezug();
    		felderSetzen(d, nummer, art, preislistekopf
    );
    		return repo.save(d);
    	}

    	public void update(long id, long  nummer, BezugArt  art, long preislistekopf 
    ) {
    		PreislisteBezug d = repo.getOne(id);
    		felderSetzen(d, nummer, art, preislistekopf
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(PreislisteBezug d, 
    	long  nummer, BezugArt  art, long preislistekopf 

    	) {
    	d.setNummer(nummer);
    	d.setArt(art);

    	if (preislistekopf > 0) {
    	   Optional<entities.PreislisteKopf> preislistekopfEntity =  preislistekopfRepo.findById(preislistekopf);
    	   if (preislistekopfEntity.isPresent()) {
    	   	  d.setPreislisteKopf(preislistekopfEntity.get());
    	   }
    	}  	
    	}


}