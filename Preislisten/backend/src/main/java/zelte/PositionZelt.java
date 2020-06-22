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

    import tho.nill.preislisten.simpleAttributes.PositionsArt;


    import interfaces.IPosition;
    import entities.Position;
    import repositories.PositionRepository;
    import java.lang.String;


    import interfaces.IPosition;
    import entities.Position;
    import repositories.PositionRepository;

    import interfaces.IPosition;
    import repositories.PositionRepository;

    import interfaces.IPreislistePosition;
    import zelte.PreislistePositionZelt;


import zelte.StandardZelt;

public class PositionZelt extends StandardZelt {


	private Position entity;

	@Autowired
	private PositionRepository repo;

	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getPositionId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new Position();
	}


	Position getEntity() {
		return entity;
	}

    public java.lang.Long getPositionId() {
			return entity.getPositionId();    
    }

         


     	    public PositionsArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToPositionsArt( value));
     	        }

     	   public PositionsArt convertToPositionsArt(String value) {
     					return PositionsArt.valueOf(value);
     				}   


     	    public String getNummer() {
     	         return entity.getNummer(); 
     	    }
     	    public void setNummerWithString(String value) {
     	        	entity.setNummer(convertToString( value));
     	        }
         




     	    public void connectPosition(PreislistePositionZelt x) {
     	        PreislistePosition target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addPreislistePosition(target);
     	        target.setPosition(entity);
     	    }


     	    public void disconnectPosition(PreislistePositionZelt x) {
     	        PreislistePosition target = x.getEntity();
     	        entity.removePreislistePosition(target);
     	        target.setPosition(null);
     	    }


}


