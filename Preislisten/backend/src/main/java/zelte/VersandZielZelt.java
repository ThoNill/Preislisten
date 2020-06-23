package zelte;

import org.springframework.beans.factory.annotation.Autowired;

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

public class VersandZielZelt extends StandardZelt {


	private VersandZiel entity;

	@Autowired
	private VersandZielRepository repo;

	@Override
	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getVersandZielId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	@Override
	public void create() {
		save();
		entity = new VersandZiel();
	}


	VersandZiel getEntity() {
		return entity;
	}

    public java.lang.Long getVersandZielId() {
			return entity.getVersandZielId();    
    }

         


     	    public IK getVon_ik() {
     	         return entity.getVon_ik(); 
     	    }
     	    public void setVon_ikWithString(String value) {
     	        	entity.setVon_ik(convertToIK( value));
     	        }
         


     	    public IK getNach_ik() {
     	         return entity.getNach_ik(); 
     	    }
     	    public void setNach_ikWithString(String value) {
     	        	entity.setNach_ik(convertToIK( value));
     	        }
         


     	    public IK getAbrechnungsstelle() {
     	         return entity.getAbrechnungsstelle(); 
     	    }
     	    public void setAbrechnungsstelleWithString(String value) {
     	        	entity.setAbrechnungsstelle(convertToIK( value));
     	        }
         


     	    public DatenlieferungsArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToDatenlieferungsArt( value));
     	        }

     	   public DatenlieferungsArt convertToDatenlieferungsArt(String value) {
     					return DatenlieferungsArt.valueOf(value);
     				}   


     	    public Kostenträger getVerweis() {
     	         return entity.getVerweis(); 
     	    }
     	    public void setVerweisWithString(String value) {
     	        	entity.setVerweis(convertToKostenträger( value));
     	        }

     	   public Kostenträger convertToKostenträger(String value) {
     					return Kostenträger.valueOf(value);
     				}   


     	    public DFÜMedium getMedium() {
     	         return entity.getMedium(); 
     	    }
     	    public void setMediumWithString(String value) {
     	        	entity.setMedium(convertToDFÜMedium( value));
     	        }

     	   public DFÜMedium convertToDFÜMedium(String value) {
     					return DFÜMedium.valueOf(value);
     				}   


     	    public Bundesland getLand() {
     	         return entity.getLand(); 
     	    }
     	    public void setLandWithString(String value) {
     	        	entity.setLand(convertToBundesland( value));
     	        }

     	   public Bundesland convertToBundesland(String value) {
     					return Bundesland.valueOf(value);
     				}   


     	    public KVBezirk getBezirk() {
     	         return entity.getBezirk(); 
     	    }
     	    public void setBezirkWithString(String value) {
     	        	entity.setBezirk(convertToKVBezirk( value));
     	        }

     	   public KVBezirk convertToKVBezirk(String value) {
     					return KVBezirk.valueOf(value);
     				}   


     	    public Abrechnungscode getAbrechnungscode() {
     	         return entity.getAbrechnungscode(); 
     	    }
     	    public void setAbrechnungscodeWithString(String value) {
     	        	entity.setAbrechnungscode(convertToAbrechnungscode( value));
     	        }

     	   public Abrechnungscode convertToAbrechnungscode(String value) {
     					return Abrechnungscode.valueOf(value);
     				}   


     	    public Tarifkennzeichen getTarifkennzeichen() {
     	         return entity.getTarifkennzeichen(); 
     	    }
     	    public void setTarifkennzeichenWithString(String value) {
     	        	entity.setTarifkennzeichen(convertToTarifkennzeichen( value));
     	        }
         


}


