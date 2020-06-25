package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.HMVGruppe;
import repositories.HMVGruppeRepository;

import java.lang.Long;

import java.lang.String;

import java.lang.String;

import java.lang.String;

import java.lang.String;



import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
public class HMVGruppeEntityService  {

    	@Autowired
    	HMVGruppeRepository repo;

    	@Autowired
    	repositories.HMVUntergruppeRepository hmvuntergruppeRepo;


    	public HMVGruppeEntityService() {
    		super();
    	}

    	public Optional<HMVGruppe> get(long id) {
    		return repo.findById(id);
    	}

    	public HMVGruppe create(Long  nummer, String  bezeichnung, String  definition, String  indikation, String  querverweise, long hmvuntergruppe 
    ) {
    		HMVGruppe d = new HMVGruppe();
    		felderSetzen(d, nummer, bezeichnung, definition, indikation, querverweise, hmvuntergruppe
    );
    		return repo.save(d);
    	}

    	public void update(long id, Long  nummer, String  bezeichnung, String  definition, String  indikation, String  querverweise, long hmvuntergruppe 
    ) {
    		HMVGruppe d = repo.getOne(id);
    		felderSetzen(d, nummer, bezeichnung, definition, indikation, querverweise, hmvuntergruppe
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(HMVGruppe d, 
    	Long  nummer, String  bezeichnung, String  definition, String  indikation, String  querverweise, long hmvuntergruppe 

    	) {
    	d.setNummer(nummer);
    	d.setBezeichnung(bezeichnung);
    	d.setDefinition(definition);
    	d.setIndikation(indikation);
    	d.setQuerverweise(querverweise);

    	if (hmvuntergruppe > 0) {
    	    Optional<entities.HMVUntergruppe> hmvuntergruppeEntity =  hmvuntergruppeRepo.findById(hmvuntergruppe);
    	    if (hmvuntergruppeEntity.isPresent()) {
    	       d.addHMVUntergruppe(hmvuntergruppeEntity.get());
    	    }
    	}	
    	}


}