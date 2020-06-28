package zelte;

import entities.Position;
import entities.PreislistePosition;
import repositories.PositionRepository;
import tho.nill.preislisten.simpleAttributes.PositionsArt;

public class PositionZelt extends StandardZelt {


	private Position entity;

	private PositionRepository repo;

	public PositionZelt(PositionRepository repo) {
		super();
		this.repo = repo;
	}


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

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new Position();
	}


	public Position getEntity() {
		return entity;
	}

	public void setEntity(Position entity) {
         this.entity = entity;
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
     					return PositionsArt.search(value);
     				}   


     	    public String getNummer() {
     	         return entity.getNummer(); 
     	    }
     	    public void setNummerWithString(String value) {
     	        	entity.setNummer(convertToString( value));
     	        }
         




     	    public void connectPosition(PreislistePositionZelt x) {

     	        if (entity!=null) {
     	        	saveIfNeeded();
     	        	x.saveIfNeeded();

     	        	PreislistePosition target = x.getEntity();
     	        	entity.addPreislistePosition(target);
     	        	target.setPosition(entity);

     	        	saveIfNeeded();
     	        	x.saveIfNeeded();
     	        };

     	    }


     	    public void disconnectPosition(PreislistePositionZelt x) {
     	      if (entity!=null) {
     	        PreislistePosition target = x.getEntity();
     	        entity.removePreislistePosition(target);
     	        target.setPosition(null);

     	        saveIfNeeded();
     	        x.saveIfNeeded();
     	      };
     	    }


}


