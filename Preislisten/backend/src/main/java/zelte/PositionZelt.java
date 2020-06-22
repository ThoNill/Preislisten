package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Position;
import entities.PreislistePosition;
import repositories.PositionRepository;
import tho.nill.preislisten.simpleAttributes.PositionsArt;

public class PositionZelt extends StandardZelt {


	private Position entity;

	@Autowired
	private PositionRepository repo;

	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getPositionId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new Position();
	}


	Position getEntity() {
		return entity;
	}

    public java.lang.Long getPositionId() {
			return entity.getPositionId();    
    }

         


     	    public PositionsArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToPositionsArt( value));
     	        }

     	   public PositionsArt convertToPositionsArt(String value) {
     					return PositionsArt.valueOf(value);
     				}   


     	    public String getNummer() {
     	         return entity.getNummer(); 
     	    }
     	    public void setNummerWithString(String value) {
     	        	entity.setNummer(convertToString( value));
     	        }
         




     	    public void connectPosition(PreislistePositionZelt x) {
     	        PreislistePosition target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addPreislistePosition(target);
     	        target.setPosition(entity);
     	    }


     	    public void disconnectPosition(PreislistePositionZelt x) {
     	        PreislistePosition target = x.getEntity();
     	        entity.removePreislistePosition(target);
     	        target.setPosition(null);
     	    }


}


