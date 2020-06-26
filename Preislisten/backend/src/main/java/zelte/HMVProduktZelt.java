package zelte;

import java.time.LocalDate;

import entities.HMVProdukt;
import repositories.HMVProduktRepository;

public class HMVProduktZelt extends StandardZelt {


	private HMVProdukt entity;

	private HMVProduktRepository repo;

	public HMVProduktZelt(HMVProduktRepository repo) {
		super();
		this.repo = repo;
	}


	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getHMVProduktId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new HMVProdukt();
	}


	public HMVProdukt getEntity() {
		return entity;
	}

    public java.lang.Long getHMVProduktId() {
			return entity.getHMVProduktId();    
    }

         


     	    public Long getProdukt() {
     	         return entity.getProdukt(); 
     	    }
     	    public void setProduktWithString(String value) {
     	        	entity.setProdukt(convertToLong( value));
     	        }
         


     	    public String getHilfsmittelnr() {
     	         return entity.getHilfsmittelnr(); 
     	    }
     	    public void setHilfsmittelnrWithString(String value) {
     	        	entity.setHilfsmittelnr(convertToString( value));
     	        }
         


     	    public String getBezeichnung() {
     	         return entity.getBezeichnung(); 
     	    }
     	    public void setBezeichnungWithString(String value) {
     	        	entity.setBezeichnung(convertToString( value));
     	        }
         


     	    public String getHersteller() {
     	         return entity.getHersteller(); 
     	    }
     	    public void setHerstellerWithString(String value) {
     	        	entity.setHersteller(convertToString( value));
     	        }
         


     	    public String getMerkmale() {
     	         return entity.getMerkmale(); 
     	    }
     	    public void setMerkmaleWithString(String value) {
     	        	entity.setMerkmale(convertToString( value));
     	        }
         


     		    public LocalDate getÄnderung() {
     		         return entity.getÄnderung(); 
     		    }
     		    public void setÄnderungWithString(String value) {
     		        	entity.setÄnderung(convertToLocalDate( value));
     		        }
         


}


