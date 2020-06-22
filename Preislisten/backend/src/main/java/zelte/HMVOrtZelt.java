package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.HMVOrt;
import entities.HMVUntergruppe;
import repositories.HMVOrtRepository;

public class HMVOrtZelt extends StandardZelt {


	private HMVOrt entity;

	@Autowired
	private HMVOrtRepository repo;

	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getHMVOrtId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new HMVOrt();
	}


	HMVOrt getEntity() {
		return entity;
	}

    public java.lang.Long getHMVOrtId() {
			return entity.getHMVOrtId();    
    }

         


     	    public String getOrt() {
     	         return entity.getOrt(); 
     	    }
     	    public void setOrtWithString(String value) {
     	        	entity.setOrt(convertToString( value));
     	        }
         


     	    public String getBezeichnung() {
     	         return entity.getBezeichnung(); 
     	    }
     	    public void setBezeichnungWithString(String value) {
     	        	entity.setBezeichnung(convertToString( value));
     	        }
         




     	    public void connectHMVOrt(HMVUntergruppeZelt x) {
     	        HMVUntergruppe target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addHMVUntergruppe(target);
     	        target.setHMVOrt(entity);
     	    }


     	    public void disconnectHMVOrt(HMVUntergruppeZelt x) {
     	        HMVUntergruppe target = x.getEntity();
     	        entity.removeHMVUntergruppe(target);
     	        target.setHMVOrt(null);
     	    }


}


