package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.PreislisteBezug;
import repositories.PreislisteBezugRepository;
import tho.nill.preislisten.simpleAttributes.BezugArt;

public class PreislisteBezugZelt extends StandardZelt {


	private PreislisteBezug entity;

	@Autowired
	private PreislisteBezugRepository repo;

	@Override
	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getPreislisteBezugId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	@Override
	public void create() {
		save();
		entity = new PreislisteBezug();
	}


	PreislisteBezug getEntity() {
		return entity;
	}

    public java.lang.Long getPreislisteBezugId() {
			return entity.getPreislisteBezugId();    
    }

         


     	    public long getNummer() {
     	         return entity.getNummer(); 
     	    }
     	    public void setNummerWithString(String value) {
     	        	entity.setNummer(convertToLong( value));
     	        }
         


     	    public BezugArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToBezugArt( value));
     	        }

     	   public BezugArt convertToBezugArt(String value) {
     					return BezugArt.valueOf(value);
     				}   


}


