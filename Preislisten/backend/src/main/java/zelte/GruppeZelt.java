package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Gruppe;
import repositories.GruppeRepository;
import tho.nill.preislisten.simpleAttributes.GruppeArt;

public class GruppeZelt extends StandardZelt {


	private Gruppe entity;

	@Autowired
	private GruppeRepository repo;

	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getGruppeId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new Gruppe();
	}


	Gruppe getEntity() {
		return entity;
	}

    public java.lang.Long getGruppeId() {
			return entity.getGruppeId();    
    }

         


     	    public GruppeArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToGruppeArt( value));
     	        }

     	   public GruppeArt convertToGruppeArt(String value) {
     					return GruppeArt.valueOf(value);
     				}   


     	    public Long getNummer() {
     	         return entity.getNummer(); 
     	    }
     	    public void setNummerWithString(String value) {
     	        	entity.setNummer(convertToLong( value));
     	        }
         


     	    public String getBezeichnung() {
     	         return entity.getBezeichnung(); 
     	    }
     	    public void setBezeichnungWithString(String value) {
     	        	entity.setBezeichnung(convertToString( value));
     	        }
         


     	    public String getWert() {
     	         return entity.getWert(); 
     	    }
     	    public void setWertWithString(String value) {
     	        	entity.setWert(convertToString( value));
     	        }

}


