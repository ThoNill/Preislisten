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

    import tho.nill.preislisten.simpleAttributes.IK;


    import interfaces.IVersandZiel;
    import entities.VersandZiel;
    import repositories.VersandZielRepository;
    import tho.nill.preislisten.simpleAttributes.IK;


    import interfaces.IVersandZiel;
    import entities.VersandZiel;
    import repositories.VersandZielRepository;
    import tho.nill.preislisten.simpleAttributes.IK;


    import interfaces.IVersandZiel;
    import entities.VersandZiel;
    import repositories.VersandZielRepository;
    import tho.nill.preislisten.simpleAttributes.DatenlieferungsArt;


    import interfaces.IVersandZiel;
    import entities.VersandZiel;
    import repositories.VersandZielRepository;
    import tho.nill.preislisten.simpleAttributes.Kostenträger;


    import interfaces.IVersandZiel;
    import entities.VersandZiel;
    import repositories.VersandZielRepository;
    import tho.nill.preislisten.simpleAttributes.DFÜMedium;


    import interfaces.IVersandZiel;
    import entities.VersandZiel;
    import repositories.VersandZielRepository;
    import tho.nill.preislisten.simpleAttributes.Bundesland;


    import interfaces.IVersandZiel;
    import entities.VersandZiel;
    import repositories.VersandZielRepository;
    import tho.nill.preislisten.simpleAttributes.KVBezirk;


    import interfaces.IVersandZiel;
    import entities.VersandZiel;
    import repositories.VersandZielRepository;
    import tho.nill.preislisten.simpleAttributes.Abrechnungscode;


    import interfaces.IVersandZiel;
    import entities.VersandZiel;
    import repositories.VersandZielRepository;
    import tho.nill.preislisten.simpleAttributes.Tarifkennzeichen;


    import interfaces.IVersandZiel;
    import entities.VersandZiel;
    import repositories.VersandZielRepository;

    import interfaces.IKasse;
    import repositories.KasseRepository;

    import interfaces.IVersandZiel;
    import zelte.VersandZielZelt;


import zelte.StandardZelt;

public class VersandZielZelt extends StandardZelt {


	private VersandZiel entity;

	@Autowired
	private VersandZielRepository repo;

	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getVersandZielId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}




	public void create() {
		save();
		entity = new VersandZiel();
	}


	VersandZiel getEntity() {
		return entity;
	}

    public java.lang.Long getVersandZielId() {
			return entity.getVersandZielId();    
    }

         


     	    public IK getVon_ik() {
     	         return entity.getVon_ik(); 
     	    }
     	    public void setVon_ikWithString(String value) {
     	        	entity.setVon_ik(convertToIK( value));
     	        }
         


     	    public IK getNach_ik() {
     	         return entity.getNach_ik(); 
     	    }
     	    public void setNach_ikWithString(String value) {
     	        	entity.setNach_ik(convertToIK( value));
     	        }
         


     	    public IK getAbrechnungsstelle() {
     	         return entity.getAbrechnungsstelle(); 
     	    }
     	    public void setAbrechnungsstelleWithString(String value) {
     	        	entity.setAbrechnungsstelle(convertToIK( value));
     	        }
         


     	    public DatenlieferungsArt getArt() {
     	         return entity.getArt(); 
     	    }
     	    public void setArtWithString(String value) {
     	        	entity.setArt(convertToDatenlieferungsArt( value));
     	        }

     	   public DatenlieferungsArt convertToDatenlieferungsArt(String value) {
     					return DatenlieferungsArt.valueOf(value);
     				}   


     	    public Kostenträger getVerweis() {
     	         return entity.getVerweis(); 
     	    }
     	    public void setVerweisWithString(String value) {
     	        	entity.setVerweis(convertToKostenträger( value));
     	        }

     	   public Kostenträger convertToKostenträger(String value) {
     					return Kostenträger.valueOf(value);
     				}   


     	    public DFÜMedium getMedium() {
     	         return entity.getMedium(); 
     	    }
     	    public void setMediumWithString(String value) {
     	        	entity.setMedium(convertToDFÜMedium( value));
     	        }

     	   public DFÜMedium convertToDFÜMedium(String value) {
     					return DFÜMedium.valueOf(value);
     				}   


     	    public Bundesland getLand() {
     	         return entity.getLand(); 
     	    }
     	    public void setLandWithString(String value) {
     	        	entity.setLand(convertToBundesland( value));
     	        }

     	   public Bundesland convertToBundesland(String value) {
     					return Bundesland.valueOf(value);
     				}   


     	    public KVBezirk getBezirk() {
     	         return entity.getBezirk(); 
     	    }
     	    public void setBezirkWithString(String value) {
     	        	entity.setBezirk(convertToKVBezirk( value));
     	        }

     	   public KVBezirk convertToKVBezirk(String value) {
     					return KVBezirk.valueOf(value);
     				}   


     	    public Abrechnungscode getAbrechnungscode() {
     	         return entity.getAbrechnungscode(); 
     	    }
     	    public void setAbrechnungscodeWithString(String value) {
     	        	entity.setAbrechnungscode(convertToAbrechnungscode( value));
     	        }

     	   public Abrechnungscode convertToAbrechnungscode(String value) {
     					return Abrechnungscode.valueOf(value);
     				}   


     	    public Tarifkennzeichen getTarifkennzeichen() {
     	         return entity.getTarifkennzeichen(); 
     	    }
     	    public void setTarifkennzeichenWithString(String value) {
     	        	entity.setTarifkennzeichen(convertToTarifkennzeichen( value));
     	        }
         


}


