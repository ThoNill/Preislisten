package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.PreislistePosition;
import repositories.PreislistePositionRepository;
import tho.nill.preislisten.simpleAttributes.Mwst;

public class PreislistePositionZelt extends StandardZelt {


	private PreislistePosition entity;

	@Autowired
	private PreislistePositionRepository repo;

	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getPreislistePositionId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new PreislistePosition();
	}


	PreislistePosition getEntity() {
		return entity;
	}

    public java.lang.Long getPreislistePositionId() {
			return entity.getPreislistePositionId();    
    }

         


     	    public double getPreis() {
     	         return entity.getPreis(); 
     	    }
     	    public void setPreisWithString(String value) {
     	        	entity.setPreis(convertToDouble( value));
     	        }
         


     	    public Mwst getMwst() {
     	         return entity.getMwst(); 
     	    }
     	    public void setMwstWithString(String value) {
     	        	entity.setMwst(convertToMwst( value));
     	        }

     	   public Mwst convertToMwst(String value) {
     					return Mwst.valueOf(value);
     				}   

         


}


