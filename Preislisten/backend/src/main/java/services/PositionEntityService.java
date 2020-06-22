package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Position;
import repositories.PositionRepository;

import tho.nill.preislisten.simpleAttributes.PositionsArt;

import java.lang.String;



import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
public class PositionEntityService  {

    	@Autowired
    	PositionRepository repo;

    	@Autowired
    	repositories.PreislistePositionRepository preislistepositionRepo;


    	public PositionEntityService() {
    		super();
    	}

    	public Optional<Position> get(long id) {
    		return repo.findById(id);
    	}

    	public Position create(PositionsArt  art, String  nummer, long preislisteposition 
    ) {
    		Position d = new Position();
    		felderSetzen(d, art, nummer, preislisteposition
    );
    		return repo.save(d);
    	}

    	public void update(long id, PositionsArt  art, String  nummer, long preislisteposition 
    ) {
    		Position d = repo.getOne(id);
    		felderSetzen(d, art, nummer, preislisteposition
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(Position d, 
    	PositionsArt  art, String  nummer, long preislisteposition 

    	) {
    	d.setArt(art);
    	d.setNummer(nummer);

    	if (preislisteposition > 0) {
    	    Optional<entities.PreislistePosition> preislistepositionEntity =  preislistepositionRepo.findById(preislisteposition);
    	    if (preislistepositionEntity.isPresent()) {
    	       d.addPreislistePosition(preislistepositionEntity.get());
    	    }
    	}	
    	}


}