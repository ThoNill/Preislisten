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


    import entities.Kunde;
    import repositories.KundeRepository;
    import tho.nill.preislisten.simpleAttributes.Tarifbereich;


    import entities.Kunde;
    import repositories.KundeRepository;
    import tho.nill.preislisten.simpleAttributes.Abrechnungscode;


    import entities.Kunde;
    import repositories.KundeRepository;
    import java.lang.String;


    import entities.Kunde;
    import repositories.KundeRepository;
    import java.lang.String;


    import entities.Kunde;
    import repositories.KundeRepository;
    import java.lang.String;


    import entities.Kunde;
    import repositories.KundeRepository;
    import java.lang.String;


    import entities.Kunde;
    import repositories.KundeRepository;
    import java.lang.String;


    import entities.Kunde;
    import repositories.KundeRepository;
    import java.lang.String;


    import entities.Kunde;
    import repositories.KundeRepository;
    import java.lang.String;


    import entities.Kunde;
    import repositories.KundeRepository;


import zelte.StandardZelt;

public class KundeZelt extends StandardZelt {


	private Kunde entity;

	private KundeRepository repo;

	public KundeZelt(KundeRepository repo) {
		super();
		this.repo = repo;
	}


	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getKundeId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new Kunde();
	}


	public Kunde getEntity() {
		return entity;
	}

	public void setEntity(Kunde entity) {
         this.entity = entity;
	}	


    public java.lang.Long getKundeId() {
			return entity.getKundeId();    
    }

         


     	    public IK getIk() {
     	         return entity.getIk(); 
     	    }
     	    public void setIkWithString(String value) {
     	        	entity.setIk(convertToIK( value));
     	        }
         


     	    public Tarifbereich getTarifbereich() {
     	         return entity.getTarifbereich(); 
     	    }
     	    public void setTarifbereichWithString(String value) {
     	        	entity.setTarifbereich(convertToTarifbereich( value));
     	        }

     	   public Tarifbereich convertToTarifbereich(String value) {
     					return Tarifbereich.search(value);
     				}   


     	    public Abrechnungscode getAbrechnungscode() {
     	         return entity.getAbrechnungscode(); 
     	    }
     	    public void setAbrechnungscodeWithString(String value) {
     	        	entity.setAbrechnungscode(convertToAbrechnungscode( value));
     	        }

     	   public Abrechnungscode convertToAbrechnungscode(String value) {
     					return Abrechnungscode.search(value);
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
         


     	    public String getEmail() {
     	         return entity.getEmail(); 
     	    }
     	    public void setEmailWithString(String value) {
     	        	entity.setEmail(convertToString( value));
     	        }

}


