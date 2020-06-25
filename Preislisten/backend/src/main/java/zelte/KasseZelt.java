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

    import tho.nill.preislisten.simpleAttributes.IK;


    import entities.Kasse;
    import repositories.KasseRepository;
    import tho.nill.preislisten.simpleAttributes.KasseArt;


    import entities.Kasse;
    import repositories.KasseRepository;
    import tho.nill.preislisten.simpleAttributes.KassenFunktion;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;

    import entities.Kasse;
    import repositories.KasseRepository;

    import entities.VersandZiel;
    import zelte.VersandZielZelt;


import zelte.StandardZelt;

public class KasseZelt extends StandardZelt {


	private Kasse entity;

	private KasseRepository repo;

	public KasseZelt(KasseRepository repo) {
		super();
		this.repo = repo;
	}


	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getKasseId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new Kasse();
	}


	public Kasse getEntity() {
		return entity;
	}

    public java.lang.Long getKasseId() {
			return entity.getKasseId();    
    }

         


     	    public IK getIk() {
     	         return entity.getIk(); 
     	    }
     	    public void setIkWithString(String value) {
     	        	entity.setIk(convertToIK( value));
     	        }
         


     	    public KasseArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToKasseArt( value));
     	        }

     	   public KasseArt convertToKasseArt(String value) {
     					return KasseArt.search(value);
     				}   


     	    public KassenFunktion getFunktion() {
     	         return entity.getFunktion(); 
     	    }
     	    public void setFunktionWithString(String value) {
     	        	entity.setFunktion(convertToKassenFunktion( value));
     	        }

     	   public KassenFunktion convertToKassenFunktion(String value) {
     					return KassenFunktion.search(value);
     				}   


     	    public String getAnsprechpartner() {
     	         return entity.getAnsprechpartner(); 
     	    }
     	    public void setAnsprechpartnerWithString(String value) {
     	        	entity.setAnsprechpartner(convertToString( value));
     	        }
         


     	    public String getFirma() {
     	         return entity.getFirma(); 
     	    }
     	    public void setFirmaWithString(String value) {
     	        	entity.setFirma(convertToString( value));
     	        }
         


     	    public String getPlz() {
     	         return entity.getPlz(); 
     	    }
     	    public void setPlzWithString(String value) {
     	        	entity.setPlz(convertToString( value));
     	        }
         


     	    public String getOrt() {
     	         return entity.getOrt(); 
     	    }
     	    public void setOrtWithString(String value) {
     	        	entity.setOrt(convertToString( value));
     	        }
         


     	    public String getStraße() {
     	         return entity.getStraße(); 
     	    }
     	    public void setStraßeWithString(String value) {
     	        	entity.setStraße(convertToString( value));
     	        }
         


     	    public String getTelefon() {
     	         return entity.getTelefon(); 
     	    }
     	    public void setTelefonWithString(String value) {
     	        	entity.setTelefon(convertToString( value));
     	        }
         


     	    public String getName() {
     	         return entity.getName(); 
     	    }
     	    public void setNameWithString(String value) {
     	        	entity.setName(convertToString( value));
     	        }
         


     	    public String getEmail() {
     	         return entity.getEmail(); 
     	    }
     	    public void setEmailWithString(String value) {
     	        	entity.setEmail(convertToString( value));
     	        }
         




     	    public void connectKasse(VersandZielZelt x) {

     	        if (entity!=null) {
     	        	saveIfNeeded();
     	        	x.saveIfNeeded();

     	        	VersandZiel target = x.getEntity();
     	        	entity.addVersandZiel(target);
     	        	target.setKasse(entity);

     	        	saveIfNeeded();
     	        	x.saveIfNeeded();
     	        };

     	    }


     	    public void disconnectKasse(VersandZielZelt x) {
     	      if (entity!=null) {
     	        VersandZiel target = x.getEntity();
     	        entity.removeVersandZiel(target);
     	        target.setKasse(null);

     	        saveIfNeeded();
     	        x.saveIfNeeded();
     	      };
     	    }


}


