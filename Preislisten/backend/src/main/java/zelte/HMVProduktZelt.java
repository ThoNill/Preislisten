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


    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.lang.Long;


    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.lang.Long;


    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.lang.Long;


    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.lang.Long;


    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.lang.String;


    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;


    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.lang.String;


    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;


    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.time.LocalDate;


    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;

    import entities.HMVArt;
    import repositories.HMVArtRepository;

    import entities.HMVProdukt;
    import zelte.HMVProduktZelt;


import zelte.StandardZelt;

public class HMVProduktZelt extends StandardZelt {


	private HMVProdukt entity;

	private HMVProduktRepository repo;

	public HMVProduktZelt(HMVProduktRepository repo) {
		super();
		this.repo = repo;
	}


	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getHMVProduktId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new HMVProdukt();
	}


	public HMVProdukt getEntity() {
		return entity;
	}

	public void setEntity(HMVProdukt entity) {
         this.entity = entity;
	}	


    public java.lang.Long getHMVProduktId() {
			return entity.getHMVProduktId();    
    }

         


     	    public Long getProdukt() {
     	         return entity.getProdukt(); 
     	    }
     	    public void setProduktWithString(String value) {
     	        	entity.setProdukt(convertToLong( value));
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
         


     	    public String getHilfsmittelnr() {
     	         return entity.getHilfsmittelnr(); 
     	    }
     	    public void setHilfsmittelnrWithString(String value) {
     	        	entity.setHilfsmittelnr(convertToString( value));
     	        }
         

     	     public void setBezeichnungWithString(String value) {
     	         	entity.setBezeichnung(convertToString( value));
     	         } 


     	    public String getHersteller() {
     	         return entity.getHersteller(); 
     	    }
     	    public void setHerstellerWithString(String value) {
     	        	entity.setHersteller(convertToString( value));
     	        }
         

     	     public void setMerkmaleWithString(String value) {
     	         	entity.setMerkmale(convertToString( value));
     	         } 


     		    public LocalDate getÄnderung() {
     		         return entity.getÄnderung(); 
     		    }
     		    public void setÄnderungWithString(String value) {
     		        	entity.setÄnderung(convertToLocalDate( value));
     		        }
         


}


