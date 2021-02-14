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


    import entities.HMVArt;
    import repositories.HMVArtRepository;
    import java.lang.Long;


    import entities.HMVArt;
    import repositories.HMVArtRepository;
    import java.lang.Long;


    import entities.HMVArt;
    import repositories.HMVArtRepository;
    import java.lang.Long;


    import entities.HMVArt;
    import repositories.HMVArtRepository;
    import java.lang.String;


    import entities.HMVArt;
    import repositories.HMVArtRepository;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;


    import entities.HMVArt;
    import repositories.HMVArtRepository;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;


    import entities.HMVArt;
    import repositories.HMVArtRepository;

    import entities.HMVUntergruppe;
    import repositories.HMVUntergruppeRepository;

    import entities.HMVArt;
    import zelte.HMVArtZelt;
    import entities.HMVArt;
    import repositories.HMVArtRepository;

    import entities.HMVProdukt;
    import zelte.HMVProduktZelt;


import zelte.StandardZelt;

public class HMVArtZelt extends StandardZelt {


	private HMVArt entity;

	private HMVArtRepository repo;

	public HMVArtZelt(HMVArtRepository repo) {
		super();
		this.repo = repo;
	}


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

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new HMVArt();
	}


	public HMVArt getEntity() {
		return entity;
	}

	public void setEntity(HMVArt entity) {
         this.entity = entity;
	}	


    public java.lang.Long getHMVArtId() {
			return entity.getHMVArtId();    
    }

         


     	    public Long getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToLong( value));
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
         


     	    public String getBezeichnung() {
     	         return entity.getBezeichnung(); 
     	    }
     	    public void setBezeichnungWithString(String value) {
     	        	entity.setBezeichnung(convertToString( value));
     	        }
         

     	     public void setBeschreibungWithString(String value) {
     	         	entity.setBeschreibung(convertToString( value));
     	         } 

     	     public void setIndikationWithString(String value) {
     	         	entity.setIndikation(convertToString( value));
     	         } 

         




     	    public void connectHMVArt(HMVProduktZelt x) {

     	        if (entity!=null) {
     	        	saveIfNeeded();
     	        	x.saveIfNeeded();

     	        	HMVProdukt target = x.getEntity();
     	        	entity.addHMVProdukt(target);
     	        	target.setHMVArt(entity);

     	        	saveIfNeeded();
     	        	x.saveIfNeeded();
     	        };

     	    }


     	    public void disconnectHMVArt(HMVProduktZelt x) {
     	      if (entity!=null) {
     	        HMVProdukt target = x.getEntity();
     	        entity.removeHMVProdukt(target);
     	        target.setHMVArt(null);

     	        saveIfNeeded();
     	        x.saveIfNeeded();
     	      };
     	    }


}


