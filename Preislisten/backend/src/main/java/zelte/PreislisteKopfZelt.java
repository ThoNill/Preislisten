package zelte;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import entities.PreislisteBezug;
import entities.PreislisteKopf;
import entities.PreislistePosition;
import repositories.PreislisteKopfRepository;
import tho.nill.preislisten.simpleAttributes.DatumArt;
import tho.nill.preislisten.simpleAttributes.PreislisteArt;

public class PreislisteKopfZelt extends StandardZelt {


	private PreislisteKopf entity;

	@Autowired
	private PreislisteKopfRepository repo;

	@Override
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




	@Override
	public void create() {
		save();
		entity = new PreislisteKopf();
	}


	PreislisteKopf getEntity() {
		return entity;
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
     					return PreislisteArt.valueOf(value);
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
     					return DatumArt.valueOf(value);
     				}   




     	    public void connectPreislisteKopf(PreislisteBezugZelt x) {
     	        PreislisteBezug target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addPreislisteBezug(target);
     	        target.setPreislisteKopf(entity);
     	    }


     	    public void disconnectPreislisteKopf(PreislisteBezugZelt x) {
     	        PreislisteBezug target = x.getEntity();
     	        entity.removePreislisteBezug(target);
     	        target.setPreislisteKopf(null);
     	    }

         




     	    public void connectPreislisteKopf(PreislistePositionZelt x) {
     	        PreislistePosition target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addPreislistePosition(target);
     	        target.setPreislisteKopf(entity);
     	    }


     	    public void disconnectPreislisteKopf(PreislistePositionZelt x) {
     	        PreislistePosition target = x.getEntity();
     	        entity.removePreislistePosition(target);
     	        target.setPreislisteKopf(null);
     	    }


}


