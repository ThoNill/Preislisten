package zelte;

import entities.HMVOrt;
import entities.HMVUntergruppe;
import repositories.HMVOrtRepository;

public class HMVOrtZelt extends StandardZelt {


	private HMVOrt entity;

	private HMVOrtRepository repo;

	public HMVOrtZelt(HMVOrtRepository repo) {
		super();
		this.repo = repo;
	}


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

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new HMVOrt();
	}


	public HMVOrt getEntity() {
		return entity;
	}

	public void setEntity(HMVOrt entity) {
         this.entity = entity;
	}	


    public java.lang.Long getHMVOrtId() {
			return entity.getHMVOrtId();    
    }

         


     	    public Long getOrt() {
     	         return entity.getOrt(); 
     	    }
     	    public void setOrtWithString(String value) {
     	        	entity.setOrt(convertToLong( value));
     	        }
         


     	    public String getBezeichnung() {
     	         return entity.getBezeichnung(); 
     	    }
     	    public void setBezeichnungWithString(String value) {
     	        	entity.setBezeichnung(convertToString( value));
     	        }
         




     	    public void connectHMVOrt(HMVUntergruppeZelt x) {

     	        if (entity!=null) {
     	        	saveIfNeeded();
     	        	x.saveIfNeeded();

     	        	HMVUntergruppe target = x.getEntity();
     	        	entity.addHMVUntergruppe(target);
     	        	target.setHMVOrt(entity);

     	        	saveIfNeeded();
     	        	x.saveIfNeeded();
     	        };

     	    }


     	    public void disconnectHMVOrt(HMVUntergruppeZelt x) {
     	      if (entity!=null) {
     	        HMVUntergruppe target = x.getEntity();
     	        entity.removeHMVUntergruppe(target);
     	        target.setHMVOrt(null);

     	        saveIfNeeded();
     	        x.saveIfNeeded();
     	      };
     	    }


}


