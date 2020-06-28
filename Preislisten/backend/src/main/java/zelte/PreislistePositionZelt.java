package zelte;

import entities.PreislistePosition;
import repositories.PreislistePositionRepository;
import tho.nill.preislisten.simpleAttributes.Mwst;

public class PreislistePositionZelt extends StandardZelt {


	private PreislistePosition entity;

	private PreislistePositionRepository repo;

	public PreislistePositionZelt(PreislistePositionRepository repo) {
		super();
		this.repo = repo;
	}


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

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new PreislistePosition();
	}


	public PreislistePosition getEntity() {
		return entity;
	}

	public void setEntity(PreislistePosition entity) {
         this.entity = entity;
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
     					return Mwst.search(value);
     				}   

         


}


