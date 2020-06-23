package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.HMVGruppe;
import entities.HMVUntergruppe;
import repositories.HMVGruppeRepository;

public class HMVGruppeZelt extends StandardZelt {


	private HMVGruppe entity;

	@Autowired
	private HMVGruppeRepository repo;

	@Override
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




	@Override
	public void create() {
		save();
		entity = new HMVGruppe();
	}


	HMVGruppe getEntity() {
		return entity;
	}

    public java.lang.Long getHMVGruppeId() {
			return entity.getHMVGruppeId();    
    }

         


     	    public Long getNummer() {
     	         return entity.getNummer(); 
     	    }
     	    public void setNummerWithString(String value) {
     	        	entity.setNummer(convertToLong( value));
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
         


     	    public String getQuerverweise() {
     	         return entity.getQuerverweise(); 
     	    }
     	    public void setQuerverweiseWithString(String value) {
     	        	entity.setQuerverweise(convertToString( value));
     	        }
         




     	    public void connectHMVGruppe(HMVUntergruppeZelt x) {
     	        HMVUntergruppe target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addHMVUntergruppe(target);
     	        target.setHMVGruppe(entity);
     	    }


     	    public void disconnectHMVGruppe(HMVUntergruppeZelt x) {
     	        HMVUntergruppe target = x.getEntity();
     	        entity.removeHMVUntergruppe(target);
     	        target.setHMVGruppe(null);
     	    }


}


