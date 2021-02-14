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

import org.springframework.beans.factory.annotation.Autowired;
import entities.*;

    import java.lang.Long;


    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;


    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;


    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;


    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;


    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;

    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;

    import entities.HMVUntergruppe;
    import zelte.HMVUntergruppeZelt;


import zelte.StandardZelt;

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


