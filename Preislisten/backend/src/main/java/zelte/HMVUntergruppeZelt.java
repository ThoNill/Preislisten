package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.HMVArt;
import entities.HMVUntergruppe;
import repositories.HMVUntergruppeRepository;

public class HMVUntergruppeZelt extends StandardZelt {


	private HMVUntergruppe entity;

	@Autowired
	private HMVUntergruppeRepository repo;

	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getHMVUntergruppeId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new HMVUntergruppe();
	}


	HMVUntergruppe getEntity() {
		return entity;
	}

    public java.lang.Long getHMVUntergruppeId() {
			return entity.getHMVUntergruppeId();    
    }

         


     	    public String getUntergruppe() {
     	         return entity.getUntergruppe(); 
     	    }
     	    public void setUntergruppeWithString(String value) {
     	        	entity.setUntergruppe(convertToString( value));
     	        }
         


     	    public String getBezeichnung() {
     	         return entity.getBezeichnung(); 
     	    }
     	    public void setBezeichnungWithString(String value) {
     	        	entity.setBezeichnung(convertToString( value));
     	        }
         


     	    public String getAnforderungen() {
     	         return entity.getAnforderungen(); 
     	    }
     	    public void setAnforderungenWithString(String value) {
     	        	entity.setAnforderungen(convertToString( value));
     	        }
         

         

         




     	    public void connectHMVUntergruppe(HMVArtZelt x) {
     	        HMVArt target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addHMVArt(target);
     	        target.setHMVUntergruppe(entity);
     	    }


     	    public void disconnectHMVUntergruppe(HMVArtZelt x) {
     	        HMVArt target = x.getEntity();
     	        entity.removeHMVArt(target);
     	        target.setHMVUntergruppe(null);
     	    }


}


