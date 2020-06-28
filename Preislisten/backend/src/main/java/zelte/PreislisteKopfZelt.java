package zelte;

import java.time.LocalDate;

import entities.PreislisteBezug;
import entities.PreislisteKopf;
import entities.PreislistePosition;
import repositories.PreislisteKopfRepository;
import tho.nill.preislisten.simpleAttributes.DatumArt;
import tho.nill.preislisten.simpleAttributes.PreislisteArt;

public class PreislisteKopfZelt extends StandardZelt {


	private PreislisteKopf entity;

	private PreislisteKopfRepository repo;

	public PreislisteKopfZelt(PreislisteKopfRepository repo) {
		super();
		this.repo = repo;
	}


	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getPreislisteKopfId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new PreislisteKopf();
	}


	public PreislisteKopf getEntity() {
		return entity;
	}

	public void setEntity(PreislisteKopf entity) {
         this.entity = entity;
	}	


    public java.lang.Long getPreislisteKopfId() {
			return entity.getPreislisteKopfId();    
    }

         


     	    public PreislisteArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToPreislisteArt( value));
     	        }

     	   public PreislisteArt convertToPreislisteArt(String value) {
     					return PreislisteArt.search(value);
     				}   


     	    public String getTarifkennzeichen() {
     	         return entity.getTarifkennzeichen(); 
     	    }
     	    public void setTarifkennzeichenWithString(String value) {
     	        	entity.setTarifkennzeichen(convertToString( value));
     	        }
         


     		    public LocalDate getGültigAb() {
     		         return entity.getGültigAb(); 
     		    }
     		    public void setGültigAbWithString(String value) {
     		        	entity.setGültigAb(convertToLocalDate( value));
     		        }
         


     	    public DatumArt getDart() {
     	         return entity.getDart(); 
     	    }
     	    public void setDartWithString(String value) {
     	        	entity.setDart(convertToDatumArt( value));
     	        }

     	   public DatumArt convertToDatumArt(String value) {
     					return DatumArt.search(value);
     				}   




     	    public void connectPreislisteKopf(PreislisteBezugZelt x) {

     	        if (entity!=null) {
     	        	saveIfNeeded();
     	        	x.saveIfNeeded();

     	        	PreislisteBezug target = x.getEntity();
     	        	entity.addPreislisteBezug(target);
     	        	target.setPreislisteKopf(entity);

     	        	saveIfNeeded();
     	        	x.saveIfNeeded();
     	        };

     	    }


     	    public void disconnectPreislisteKopf(PreislisteBezugZelt x) {
     	      if (entity!=null) {
     	        PreislisteBezug target = x.getEntity();
     	        entity.removePreislisteBezug(target);
     	        target.setPreislisteKopf(null);

     	        saveIfNeeded();
     	        x.saveIfNeeded();
     	      };
     	    }

         




     	    public void connectPreislisteKopf(PreislistePositionZelt x) {

     	        if (entity!=null) {
     	        	saveIfNeeded();
     	        	x.saveIfNeeded();

     	        	PreislistePosition target = x.getEntity();
     	        	entity.addPreislistePosition(target);
     	        	target.setPreislisteKopf(entity);

     	        	saveIfNeeded();
     	        	x.saveIfNeeded();
     	        };

     	    }


     	    public void disconnectPreislisteKopf(PreislistePositionZelt x) {
     	      if (entity!=null) {
     	        PreislistePosition target = x.getEntity();
     	        entity.removePreislistePosition(target);
     	        target.setPreislisteKopf(null);

     	        saveIfNeeded();
     	        x.saveIfNeeded();
     	      };
     	    }


}


