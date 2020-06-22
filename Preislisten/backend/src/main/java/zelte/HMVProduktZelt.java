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

    import java.lang.String;


    import interfaces.IHMVProdukt;
    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.lang.String;


    import interfaces.IHMVProdukt;
    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.lang.String;


    import interfaces.IHMVProdukt;
    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.lang.String;


    import interfaces.IHMVProdukt;
    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;
    import java.lang.String;


    import interfaces.IHMVProdukt;
    import entities.HMVProdukt;
    import repositories.HMVProduktRepository;

    import interfaces.IHMVArt;
    import repositories.HMVArtRepository;

    import interfaces.IHMVProdukt;
    import zelte.HMVProduktZelt;


import zelte.StandardZelt;

public class HMVProduktZelt extends StandardZelt {


	private HMVProdukt entity;

	@Autowired
	private HMVProduktRepository repo;

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




	public void create() {
		save();
		entity = new HMVProdukt();
	}


	HMVProdukt getEntity() {
		return entity;
	}

    public java.lang.Long getHMVProduktId() {
			return entity.getHMVProduktId();    
    }

         


     	    public String getHilfsmittelnr() {
     	         return entity.getHilfsmittelnr(); 
     	    }
     	    public void setHilfsmittelnrWithString(String value) {
     	        	entity.setHilfsmittelnr(convertToString( value));
     	        }
         


     	    public String getProdukt() {
     	         return entity.getProdukt(); 
     	    }
     	    public void setProduktWithString(String value) {
     	        	entity.setProdukt(convertToString( value));
     	        }
         


     	    public String getBezeichnung() {
     	         return entity.getBezeichnung(); 
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
         


     	    public String getMerkmal() {
     	         return entity.getMerkmal(); 
     	    }
     	    public void setMerkmalWithString(String value) {
     	        	entity.setMerkmal(convertToString( value));
     	        }
         


}


