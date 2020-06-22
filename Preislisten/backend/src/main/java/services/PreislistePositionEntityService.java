package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.PreislistePosition;
import repositories.PreislistePositionRepository;


import tho.nill.preislisten.simpleAttributes.Mwst;




import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
public class PreislistePositionEntityService  {

    	@Autowired
    	PreislistePositionRepository repo;

    	@Autowired
    	repositories.PreislisteKopfRepository preislistekopfRepo;
    	@Autowired
    	repositories.PositionRepository positionRepo;


    	public PreislistePositionEntityService() {
    		super();
    	}

    	public Optional<PreislistePosition> get(long id) {
    		return repo.findById(id);
    	}

    	public PreislistePosition create(double  preis, Mwst  mwst, long preislistekopf 
    , long position 
    ) {
    		PreislistePosition d = new PreislistePosition();
    		felderSetzen(d, preis, mwst, preislistekopf
    , position
    );
    		return repo.save(d);
    	}

    	public void update(long id, double  preis, Mwst  mwst, long preislistekopf 
    , long position 
    ) {
    		PreislistePosition d = repo.getOne(id);
    		felderSetzen(d, preis, mwst, preislistekopf
    , position
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(PreislistePosition d, 
    	double  preis, Mwst  mwst, long preislistekopf 
    	, long position 

    	) {
    	d.setPreis(preis);
    	d.setMwst(mwst);

    	if (preislistekopf > 0) {
    	   Optional<entities.PreislisteKopf> preislistekopfEntity =  preislistekopfRepo.findById(preislistekopf);
    	   if (preislistekopfEntity.isPresent()) {
    	   	  d.setPreislisteKopf(preislistekopfEntity.get());
    	   }
    	}  
    	if (position > 0) {
    	   Optional<entities.Position> positionEntity =  positionRepo.findById(position);
    	   if (positionEntity.isPresent()) {
    	   	  d.setPosition(positionEntity.get());
    	   }
    	}  	
    	}


}