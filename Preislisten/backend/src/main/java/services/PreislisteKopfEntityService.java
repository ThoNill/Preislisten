package services;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.PreislisteKopf;
import repositories.PreislisteKopfRepository;
import tho.nill.preislisten.simpleAttributes.DatumArt;
import tho.nill.preislisten.simpleAttributes.PreislisteArt;

@Service
public class PreislisteKopfEntityService  {

    	@Autowired
    	PreislisteKopfRepository repo;

    	@Autowired
    	repositories.PreislisteBezugRepository preislistebezugRepo;
    	@Autowired
    	repositories.PreislistePositionRepository preislistepositionRepo;


    	public PreislisteKopfEntityService() {
    		super();
    	}

    	public Optional<PreislisteKopf> get(long id) {
    		return repo.findById(id);
    	}

    	public PreislisteKopf create(PreislisteArt  art, String  tarifkennzeichen, LocalDate  gültigAb, DatumArt  dart, long preislistebezug 
    , long preislisteposition 
    ) {
    		PreislisteKopf d = new PreislisteKopf();
    		felderSetzen(d, art, tarifkennzeichen, gültigAb, dart, preislistebezug
    , preislisteposition
    );
    		return repo.save(d);
    	}

    	public void update(long id, PreislisteArt  art, String  tarifkennzeichen, LocalDate  gültigAb, DatumArt  dart, long preislistebezug 
    , long preislisteposition 
    ) {
    		PreislisteKopf d = repo.getOne(id);
    		felderSetzen(d, art, tarifkennzeichen, gültigAb, dart, preislistebezug
    , preislisteposition
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(PreislisteKopf d, 
    	PreislisteArt  art, String  tarifkennzeichen, LocalDate  gültigAb, DatumArt  dart, long preislistebezug 
    	, long preislisteposition 

    	) {
    	d.setArt(art);
    	d.setTarifkennzeichen(tarifkennzeichen);
    	d.setDart(dart);

    	if (preislistebezug > 0) {
    	    Optional<entities.PreislisteBezug> preislistebezugEntity =  preislistebezugRepo.findById(preislistebezug);
    	    if (preislistebezugEntity.isPresent()) {
    	       d.addPreislisteBezug(preislistebezugEntity.get());
    	    }
    	}
    	if (preislisteposition > 0) {
    	    Optional<entities.PreislistePosition> preislistepositionEntity =  preislistepositionRepo.findById(preislisteposition);
    	    if (preislistepositionEntity.isPresent()) {
    	       d.addPreislistePosition(preislistepositionEntity.get());
    	    }
    	}	
    	}


}