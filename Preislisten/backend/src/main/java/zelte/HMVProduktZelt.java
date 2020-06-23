package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.HMVProdukt;
import repositories.HMVProduktRepository;

public class HMVProduktZelt extends StandardZelt {


	private HMVProdukt entity;

	@Autowired
	private HMVProduktRepository repo;

	@Override
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




	@Override
	public void create() {
		save();
		entity = new HMVProdukt();
	}


	HMVProdukt getEntity() {
		return entity;
	}

    public java.lang.Long getHMVProduktId() {
			return entity.getHMVProduktId();    
    }

         


     	    public String getHilfsmittelnr() {
     	         return entity.getHilfsmittelnr(); 
     	    }
     	    public void setHilfsmittelnrWithString(String value) {
     	        	entity.setHilfsmittelnr(convertToString( value));
     	        }
         


     	    public String getProdukt() {
     	         return entity.getProdukt(); 
     	    }
     	    public void setProduktWithString(String value) {
     	        	entity.setProdukt(convertToString( value));
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
         


     	    public String getMerkmal() {
     	         return entity.getMerkmal(); 
     	    }
     	    public void setMerkmalWithString(String value) {
     	        	entity.setMerkmal(convertToString( value));
     	        }
         


}


