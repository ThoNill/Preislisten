package zelte;

import entities.PreislisteBezug;
import repositories.PreislisteBezugRepository;
import tho.nill.preislisten.simpleAttributes.BezugArt;

public class PreislisteBezugZelt extends StandardZelt {


	private PreislisteBezug entity;

	private PreislisteBezugRepository repo;

	public PreislisteBezugZelt(PreislisteBezugRepository repo) {
		super();
		this.repo = repo;
	}


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

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new PreislisteBezug();
	}


	public PreislisteBezug getEntity() {
		return entity;
	}

	public void setEntity(PreislisteBezug entity) {
         this.entity = entity;
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
     					return BezugArt.search(value);
     				}   


}


