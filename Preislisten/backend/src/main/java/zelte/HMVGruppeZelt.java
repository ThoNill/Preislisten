package zelte;

import entities.HMVGruppe;
import entities.HMVUntergruppe;
import repositories.HMVGruppeRepository;

public class HMVGruppeZelt extends StandardZelt {


	private HMVGruppe entity;

	private HMVGruppeRepository repo;

	public HMVGruppeZelt(HMVGruppeRepository repo) {
		super();
		this.repo = repo;
	}


	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getHMVGruppeId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new HMVGruppe();
	}


	public HMVGruppe getEntity() {
		return entity;
	}

	public void setEntity(HMVGruppe entity) {
         this.entity = entity;
	}	


    public java.lang.Long getHMVGruppeId() {
			return entity.getHMVGruppeId();    
    }

         


     	    public Long getGruppe() {
     	         return entity.getGruppe(); 
     	    }
     	    public void setGruppeWithString(String value) {
     	        	entity.setGruppe(convertToLong( value));
     	        }
         

     	     public void setBezeichnungWithString(String value) {
     	         	entity.setBezeichnung(convertToString( value));
     	         } 

     	     public void setDefinitionWithString(String value) {
     	         	entity.setDefinition(convertToString( value));
     	         } 

     	     public void setIndikationWithString(String value) {
     	         	entity.setIndikation(convertToString( value));
     	         } 

     	     public void setQuerverweiseWithString(String value) {
     	         	entity.setQuerverweise(convertToString( value));
     	         } 




     	    public void connectHMVGruppe(HMVUntergruppeZelt x) {

     	        if (entity!=null) {
     	        	saveIfNeeded();
     	        	x.saveIfNeeded();

     	        	HMVUntergruppe target = x.getEntity();
     	        	entity.addHMVUntergruppe(target);
     	        	target.setHMVGruppe(entity);

     	        	saveIfNeeded();
     	        	x.saveIfNeeded();
     	        };

     	    }


     	    public void disconnectHMVGruppe(HMVUntergruppeZelt x) {
     	      if (entity!=null) {
     	        HMVUntergruppe target = x.getEntity();
     	        entity.removeHMVUntergruppe(target);
     	        target.setHMVGruppe(null);

     	        saveIfNeeded();
     	        x.saveIfNeeded();
     	      };
     	    }


}


