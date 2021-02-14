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

    import tho.nill.preislisten.simpleAttributes.GruppeArt;


    import entities.Gruppe;
    import repositories.GruppeRepository;
    import java.lang.Long;


    import entities.Gruppe;
    import repositories.GruppeRepository;
    import java.lang.String;


    import entities.Gruppe;
    import repositories.GruppeRepository;
    import java.lang.String;


    import entities.Gruppe;
    import repositories.GruppeRepository;


import zelte.StandardZelt;

public class GruppeZelt extends StandardZelt {


	private Gruppe entity;

	private GruppeRepository repo;

	public GruppeZelt(GruppeRepository repo) {
		super();
		this.repo = repo;
	}


	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getGruppeId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new Gruppe();
	}


	public Gruppe getEntity() {
		return entity;
	}

	public void setEntity(Gruppe entity) {
         this.entity = entity;
	}	


    public java.lang.Long getGruppeId() {
			return entity.getGruppeId();    
    }

         


     	    public GruppeArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToGruppeArt( value));
     	        }

     	   public GruppeArt convertToGruppeArt(String value) {
     					return GruppeArt.search(value);
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
         


     	    public String getWert() {
     	         return entity.getWert(); 
     	    }
     	    public void setWertWithString(String value) {
     	        	entity.setWert(convertToString( value));
     	        }

}


