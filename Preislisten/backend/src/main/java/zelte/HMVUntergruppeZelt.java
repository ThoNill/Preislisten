package zelte;

import entities.HMVArt;
import entities.HMVUntergruppe;
import repositories.HMVUntergruppeRepository;

public class HMVUntergruppeZelt extends StandardZelt {


	private HMVUntergruppe entity;

	private HMVUntergruppeRepository repo;

	public HMVUntergruppeZelt(HMVUntergruppeRepository repo) {
		super();
		this.repo = repo;
	}


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


	public HMVUntergruppe getEntity() {
		return entity;
	}

    public java.lang.Long getHMVUntergruppeId() {
			return entity.getHMVUntergruppeId();    
    }

         


     	    public Long getUntergruppe() {
     	         return entity.getUntergruppe(); 
     	    }
     	    public void setUntergruppeWithString(String value) {
     	        	entity.setUntergruppe(convertToLong( value));
     	        }
         

     	     public void setBezeichnungWithString(String value) {
     	         	entity.setBezeichnung(convertToString( value));
     	         } 

     	     public void setAnforderungenWithString(String value) {
     	         	entity.setAnforderungen(convertToString( value));
     	         } 

         

         




     	    public void connectHMVUntergruppe(HMVArtZelt x) {

     	        if (entity!=null) {
     	        	saveIfNeeded();
     	        	x.saveIfNeeded();

     	        	HMVArt target = x.getEntity();
     	        	entity.addHMVArt(target);
     	        	target.setHMVUntergruppe(entity);

     	        	saveIfNeeded();
     	        	x.saveIfNeeded();
     	        };

     	    }


     	    public void disconnectHMVUntergruppe(HMVArtZelt x) {
     	      if (entity!=null) {
     	        HMVArt target = x.getEntity();
     	        entity.removeHMVArt(target);
     	        target.setHMVUntergruppe(null);

     	        saveIfNeeded();
     	        x.saveIfNeeded();
     	      };
     	    }


}


