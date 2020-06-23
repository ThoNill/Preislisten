package services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.VersandZiel;
import repositories.VersandZielRepository;
import tho.nill.preislisten.simpleAttributes.Abrechnungscode;
import tho.nill.preislisten.simpleAttributes.Bundesland;
import tho.nill.preislisten.simpleAttributes.DFÜMedium;
import tho.nill.preislisten.simpleAttributes.DatenlieferungsArt;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KVBezirk;
import tho.nill.preislisten.simpleAttributes.Kostenträger;
import tho.nill.preislisten.simpleAttributes.Tarifkennzeichen;

@Service
public class VersandZielEntityService  {

    	@Autowired
    	VersandZielRepository repo;

    	@Autowired
    	repositories.KasseRepository kasseRepo;


    	public VersandZielEntityService() {
    		super();
    	}

    	public Optional<VersandZiel> get(long id) {
    		return repo.findById(id);
    	}

    	public VersandZiel create(IK  von_ik, IK  nach_ik, IK  abrechnungsstelle, DatenlieferungsArt  art, Kostenträger  verweis, DFÜMedium  medium, Bundesland  land, KVBezirk  bezirk, Abrechnungscode  abrechnungscode, Tarifkennzeichen  tarifkennzeichen, long kasse 
    ) {
    		VersandZiel d = new VersandZiel();
    		felderSetzen(d, von_ik, nach_ik, abrechnungsstelle, art, verweis, medium, land, bezirk, abrechnungscode, tarifkennzeichen, kasse
    );
    		return repo.save(d);
    	}

    	public void update(long id, IK  von_ik, IK  nach_ik, IK  abrechnungsstelle, DatenlieferungsArt  art, Kostenträger  verweis, DFÜMedium  medium, Bundesland  land, KVBezirk  bezirk, Abrechnungscode  abrechnungscode, Tarifkennzeichen  tarifkennzeichen, long kasse 
    ) {
    		VersandZiel d = repo.getOne(id);
    		felderSetzen(d, von_ik, nach_ik, abrechnungsstelle, art, verweis, medium, land, bezirk, abrechnungscode, tarifkennzeichen, kasse
    );
    		repo.save(d);
    	}

    	public void delete(long id) {
    		repo.deleteById(id);
    	}

    	private void felderSetzen(VersandZiel d, 
    	IK  von_ik, IK  nach_ik, IK  abrechnungsstelle, DatenlieferungsArt  art, Kostenträger  verweis, DFÜMedium  medium, Bundesland  land, KVBezirk  bezirk, Abrechnungscode  abrechnungscode, Tarifkennzeichen  tarifkennzeichen, long kasse 

    	) {
    	d.setVon_ik(von_ik);
    	d.setNach_ik(nach_ik);
    	d.setAbrechnungsstelle(abrechnungsstelle);
    	d.setArt(art);
    	d.setVerweis(verweis);
    	d.setMedium(medium);
    	d.setLand(land);
    	d.setBezirk(bezirk);
    	d.setAbrechnungscode(abrechnungscode);
    	d.setTarifkennzeichen(tarifkennzeichen);

    	if (kasse > 0) {
    	   Optional<entities.Kasse> kasseEntity =  kasseRepo.findById(kasse);
    	   if (kasseEntity.isPresent()) {
    	   	  d.setKasse(kasseEntity.get());
    	   }
    	}  	
    	}


}