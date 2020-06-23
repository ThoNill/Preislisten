package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Kasse;
import entities.VersandZiel;
import repositories.KasseRepository;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KasseArt;
import tho.nill.preislisten.simpleAttributes.KassenFunktion;

public class KasseZelt extends StandardZelt {


	private Kasse entity;

	@Autowired
	private KasseRepository repo;

	@Override
	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getKasseId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	@Override
	public void create() {
		save();
		entity = new Kasse();
	}


	Kasse getEntity() {
		return entity;
	}

    public java.lang.Long getKasseId() {
			return entity.getKasseId();    
    }

         


     	    public IK getIk() {
     	         return entity.getIk(); 
     	    }
     	    public void setIkWithString(String value) {
     	        	entity.setIk(convertToIK( value));
     	        }
         


     	    public KasseArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToKasseArt( value));
     	        }

     	   public KasseArt convertToKasseArt(String value) {
     					return KasseArt.valueOf(value);
     				}   


     	    public KassenFunktion getFunktion() {
     	         return entity.getFunktion(); 
     	    }
     	    public void setFunktionWithString(String value) {
     	        	entity.setFunktion(convertToKassenFunktion( value));
     	        }

     	   public KassenFunktion convertToKassenFunktion(String value) {
     					return KassenFunktion.valueOf(value);
     				}   


     	    public String getAnsprechpartner() {
     	         return entity.getAnsprechpartner(); 
     	    }
     	    public void setAnsprechpartnerWithString(String value) {
     	        	entity.setAnsprechpartner(convertToString( value));
     	        }
         


     	    public String getFirma() {
     	         return entity.getFirma(); 
     	    }
     	    public void setFirmaWithString(String value) {
     	        	entity.setFirma(convertToString( value));
     	        }
         


     	    public String getPlz() {
     	         return entity.getPlz(); 
     	    }
     	    public void setPlzWithString(String value) {
     	        	entity.setPlz(convertToString( value));
     	        }
         


     	    public String getOrt() {
     	         return entity.getOrt(); 
     	    }
     	    public void setOrtWithString(String value) {
     	        	entity.setOrt(convertToString( value));
     	        }
         


     	    public String getStraße() {
     	         return entity.getStraße(); 
     	    }
     	    public void setStraßeWithString(String value) {
     	        	entity.setStraße(convertToString( value));
     	        }
         


     	    public String getTelefon() {
     	         return entity.getTelefon(); 
     	    }
     	    public void setTelefonWithString(String value) {
     	        	entity.setTelefon(convertToString( value));
     	        }
         


     	    public String getEmail() {
     	         return entity.getEmail(); 
     	    }
     	    public void setEmailWithString(String value) {
     	        	entity.setEmail(convertToString( value));
     	        }
         




     	    public void connectKasse(VersandZielZelt x) {
     	        VersandZiel target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addVersandZiel(target);
     	        target.setKasse(entity);
     	    }


     	    public void disconnectKasse(VersandZielZelt x) {
     	        VersandZiel target = x.getEntity();
     	        entity.removeVersandZiel(target);
     	        target.setKasse(null);
     	    }


}


