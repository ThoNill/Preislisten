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

    import tho.nill.preislisten.simpleAttributes.BezugArt;


    import entities.PreislisteBezug;
    import repositories.PreislisteBezugRepository;

    import entities.PreislisteKopf;
    import repositories.PreislisteKopfRepository;

    import entities.PreislisteBezug;
    import zelte.PreislisteBezugZelt;


import zelte.StandardZelt;

public class PreislisteBezugZelt extends StandardZelt {


	private PreislisteBezug entity;

	private PreislisteBezugRepository repo;

	public PreislisteBezugZelt(PreislisteBezugRepository repo) {
		super();
		this.repo = repo;
	}


	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getPreislisteBezugId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new PreislisteBezug();
	}


	public PreislisteBezug getEntity() {
		return entity;
	}

	public void setEntity(PreislisteBezug entity) {
         this.entity = entity;
	}	


    public java.lang.Long getPreislisteBezugId() {
			return entity.getPreislisteBezugId();    
    }

         


     	    public long getNummer() {
     	         return entity.getNummer(); 
     	    }
     	    public void setNummerWithString(String value) {
     	        	entity.setNummer(convertToLong( value));
     	        }
         


     	    public BezugArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToBezugArt( value));
     	        }

     	   public BezugArt convertToBezugArt(String value) {
     					return BezugArt.search(value);
     				}   


}


