package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.HMVGruppe;
import repositories.HMVGruppeRepository;

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

    	public HMVGruppe create(Long  gruppe, String  bezeichnung, String  definition, String  indikation, String  querverweise, long hmvuntergruppe 
    ) {
    		HMVGruppe d = new HMVGruppe();
    		felderSetzen(d, gruppe, bezeichnung, definition, indikation, querverweise, hmvuntergruppe
    );
    		return repo.save(d);
    	}

    	public void update(long id, Long  gruppe, String  bezeichnung, String  definition, String  indikation, String  querverweise, long hmvuntergruppe 
    ) {
    		HMVGruppe d = repo.getOne(id);
    		felderSetzen(d, gruppe, bezeichnung, definition, indikation, querverweise, hmvuntergruppe
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(HMVGruppe d, 
    	Long  gruppe, String  bezeichnung, String  definition, String  indikation, String  querverweise, long hmvuntergruppe 

    	) {
    	d.setGruppe(gruppe);

    	if (hmvuntergruppe > 0) {
    	    Optional<entities.HMVUntergruppe> hmvuntergruppeEntity =  hmvuntergruppeRepo.findById(hmvuntergruppe);
    	    if (hmvuntergruppeEntity.isPresent()) {
    	       d.addHMVUntergruppe(hmvuntergruppeEntity.get());
    	    }
    	}	
    	}


}