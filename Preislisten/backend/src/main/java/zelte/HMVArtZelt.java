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


    import entities.HMVArt;
    import repositories.HMVArtRepository;
    import java.lang.String;


    import entities.HMVArt;
    import repositories.HMVArtRepository;
    import java.lang.String;


    import entities.HMVArt;
    import repositories.HMVArtRepository;
    import java.lang.String;


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

	@Autowired
	private HMVArtRepository repo;

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




	public void create() {
		save();
		entity = new HMVArt();
	}


	HMVArt getEntity() {
		return entity;
	}

    public java.lang.Long getHMVArtId() {
			return entity.getHMVArtId();    
    }

         


     	    public String getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToString( value));
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
         

         




     	    public void connectHMVArt(HMVProduktZelt x) {
     	        HMVProdukt target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addHMVProdukt(target);
     	        target.setHMVArt(entity);
     	    }


     	    public void disconnectHMVArt(HMVProduktZelt x) {
     	        HMVProdukt target = x.getEntity();
     	        entity.removeHMVProdukt(target);
     	        target.setHMVArt(null);
     	    }


}


