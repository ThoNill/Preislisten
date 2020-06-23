package zelte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import tho.nill.grundgestein.zelt.DefaultZelt;
import org.springframework.beans.factory.annotation.Autowired;
import entities.*;

    import java.lang.Long;


    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;
    import java.lang.String;


    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;
    import java.lang.String;


    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;
    import java.lang.String;


    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;
    import java.lang.String;


    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;

    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;

    import entities.HMVUntergruppe;
    import zelte.HMVUntergruppeZelt;


import zelte.StandardZelt;

public class HMVGruppeZelt extends StandardZelt {


	private HMVGruppe entity;

	@Autowired
	private HMVGruppeRepository repo;

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


