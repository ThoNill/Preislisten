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

    import tho.nill.preislisten.simpleAttributes.PreislisteArt;


    import interfaces.IPreislisteKopf;
    import entities.PreislisteKopf;
    import repositories.PreislisteKopfRepository;
    import java.lang.String;


    import interfaces.IPreislisteKopf;
    import entities.PreislisteKopf;
    import repositories.PreislisteKopfRepository;
    import java.time.LocalDate;


    import interfaces.IPreislisteKopf;
    import entities.PreislisteKopf;
    import repositories.PreislisteKopfRepository;
    import tho.nill.preislisten.simpleAttributes.DatumArt;


    import interfaces.IPreislisteKopf;
    import entities.PreislisteKopf;
    import repositories.PreislisteKopfRepository;

    import interfaces.IPreislisteKopf;
    import repositories.PreislisteKopfRepository;

    import interfaces.IPreislisteBezug;
    import zelte.PreislisteBezugZelt;
    import interfaces.IPreislisteKopf;
    import repositories.PreislisteKopfRepository;

    import interfaces.IPreislistePosition;
    import zelte.PreislistePositionZelt;


import zelte.StandardZelt;

public class PreislisteKopfZelt extends StandardZelt {


	private PreislisteKopf entity;

	@Autowired
	private PreislisteKopfRepository repo;

	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getPreislisteKopfId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new PreislisteKopf();
	}


	PreislisteKopf getEntity() {
		return entity;
	}

    public java.lang.Long getPreislisteKopfId() {
			return entity.getPreislisteKopfId();    
    }

         


     	    public PreislisteArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToPreislisteArt( value));
     	        }

     	   public PreislisteArt convertToPreislisteArt(String value) {
     					return PreislisteArt.valueOf(value);
     				}   


     	    public String getTarifkennzeichen() {
     	         return entity.getTarifkennzeichen(); 
     	    }
     	    public void setTarifkennzeichenWithString(String value) {
     	        	entity.setTarifkennzeichen(convertToString( value));
     	        }
         


     		    public LocalDate getGültigAb() {
     		         return entity.getGültigAb(); 
     		    }
     		    public void setGültigAbWithString(String value) {
     		        	entity.setGültigAb(convertToLocalDate( value));
     		        }
         


     	    public DatumArt getDart() {
     	         return entity.getDart(); 
     	    }
     	    public void setDartWithString(String value) {
     	        	entity.setDart(convertToDatumArt( value));
     	        }

     	   public DatumArt convertToDatumArt(String value) {
     					return DatumArt.valueOf(value);
     				}   




     	    public void connectPreislisteKopf(PreislisteBezugZelt x) {
     	        PreislisteBezug target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addPreislisteBezug(target);
     	        target.setPreislisteKopf(entity);
     	    }


     	    public void disconnectPreislisteKopf(PreislisteBezugZelt x) {
     	        PreislisteBezug target = x.getEntity();
     	        entity.removePreislisteBezug(target);
     	        target.setPreislisteKopf(null);
     	    }

         




     	    public void connectPreislisteKopf(PreislistePositionZelt x) {
     	        PreislistePosition target = x.getEntity();

     	        saveIfNeeded();
     	        x.saveIfNeeded();

     	        entity.addPreislistePosition(target);
     	        target.setPreislisteKopf(entity);
     	    }


     	    public void disconnectPreislisteKopf(PreislistePositionZelt x) {
     	        PreislistePosition target = x.getEntity();
     	        entity.removePreislistePosition(target);
     	        target.setPreislisteKopf(null);
     	    }


}


