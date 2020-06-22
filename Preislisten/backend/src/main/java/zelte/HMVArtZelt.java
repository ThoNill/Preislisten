package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.HMVArt;
import entities.HMVProdukt;
import repositories.HMVArtRepository;

public class HMVArtZelt extends StandardZelt {


	private HMVArt entity;

	@Autowired
	private HMVArtRepository repo;

	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getHMVArtId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new HMVArt();
	}


	HMVArt getEntity() {
		return entity;
	}

    public java.lang.Long getHMVArtId() {
			return entity.getHMVArtId();    
    }

         


     	    public String getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToString( value));
     	        }
         


     	    public String getBezeichnung() {
     	         return entity.getBezeichnung(); 
     	    }
     	    public void setBezeichnungWithString(String value) {
     	        	entity.setBezeichnung(convertToString( value));
     	        }
         


     	    public String getDefinition() {
     	         return entity.getDefinition(); 
     	    }
     	    public void setDefinitionWithString(String value) {
     	        	entity.setDefinition(convertToString( value));
     	        }
         


     	    public String getIndikation() {
     	         return entity.getIndikation(); 
     	    }
     	    public void setIndikationWithString(String value) {
     	        	entity.setIndikation(convertToString( value));
     	        }
         

         




     	    public void connectHMVArt(HMVProduktZelt x) {
     	        HMVProdukt target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addHMVProdukt(target);
     	        target.setHMVArt(entity);
     	    }


     	    public void disconnectHMVArt(HMVProduktZelt x) {
     	        HMVProdukt target = x.getEntity();
     	        entity.removeHMVProdukt(target);
     	        target.setHMVArt(null);
     	    }


}


