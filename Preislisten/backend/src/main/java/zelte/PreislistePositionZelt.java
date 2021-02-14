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

    import tho.nill.preislisten.simpleAttributes.Mwst;


    import entities.PreislistePosition;
    import repositories.PreislistePositionRepository;

    import entities.PreislisteKopf;
    import repositories.PreislisteKopfRepository;

    import entities.PreislistePosition;
    import zelte.PreislistePositionZelt;
    import entities.Position;
    import repositories.PositionRepository;

    import entities.PreislistePosition;
    import zelte.PreislistePositionZelt;


import zelte.StandardZelt;

public class PreislistePositionZelt extends StandardZelt {


	private PreislistePosition entity;

	private PreislistePositionRepository repo;

	public PreislistePositionZelt(PreislistePositionRepository repo) {
		super();
		this.repo = repo;
	}


	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getPreislistePositionId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new PreislistePosition();
	}


	public PreislistePosition getEntity() {
		return entity;
	}

	public void setEntity(PreislistePosition entity) {
         this.entity = entity;
	}	


    public java.lang.Long getPreislistePositionId() {
			return entity.getPreislistePositionId();    
    }

         


     	    public double getPreis() {
     	         return entity.getPreis(); 
     	    }
     	    public void setPreisWithString(String value) {
     	        	entity.setPreis(convertToDouble( value));
     	        }
         


     	    public Mwst getMwst() {
     	         return entity.getMwst(); 
     	    }
     	    public void setMwstWithString(String value) {
     	        	entity.setMwst(convertToMwst( value));
     	        }

     	   public Mwst convertToMwst(String value) {
     					return Mwst.search(value);
     				}   

         


}


