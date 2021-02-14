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


    import entities.HMVUntergruppe;
    import repositories.HMVUntergruppeRepository;
    import java.lang.Long;


    import entities.HMVUntergruppe;
    import repositories.HMVUntergruppeRepository;
    import java.lang.Long;


    import entities.HMVUntergruppe;
    import repositories.HMVUntergruppeRepository;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;


    import entities.HMVUntergruppe;
    import repositories.HMVUntergruppeRepository;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;


    import entities.HMVUntergruppe;
    import repositories.HMVUntergruppeRepository;

    import entities.HMVGruppe;
    import repositories.HMVGruppeRepository;

    import entities.HMVUntergruppe;
    import zelte.HMVUntergruppeZelt;
    import entities.HMVOrt;
    import repositories.HMVOrtRepository;

    import entities.HMVUntergruppe;
    import zelte.HMVUntergruppeZelt;
    import entities.HMVUntergruppe;
    import repositories.HMVUntergruppeRepository;

    import entities.HMVArt;
    import zelte.HMVArtZelt;


import zelte.StandardZelt;

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

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new HMVUntergruppe();
	}


	public HMVUntergruppe getEntity() {
		return entity;
	}

	public void setEntity(HMVUntergruppe entity) {
         this.entity = entity;
	}	


    public java.lang.Long getHMVUntergruppeId() {
			return entity.getHMVUntergruppeId();    
    }

         


     	    public Long getGruppe() {
     	         return entity.getGruppe(); 
     	    }
     	    public void setGruppeWithString(String value) {
     	        	entity.setGruppe(convertToLong( value));
     	        }
         


     	    public Long getUntergruppe() {
     	         return entity.getUntergruppe(); 
     	    }
     	    public void setUntergruppeWithString(String value) {
     	        	entity.setUntergruppe(convertToLong( value));
     	        }
         


     	    public Long getOrt() {
     	         return entity.getOrt(); 
     	    }
     	    public void setOrtWithString(String value) {
     	        	entity.setOrt(convertToLong( value));
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


