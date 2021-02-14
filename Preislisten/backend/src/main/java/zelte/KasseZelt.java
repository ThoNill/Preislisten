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
    import java.time.LocalDate;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.time.LocalDate;


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
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;
    import java.lang.String;


    import entities.Kasse;
    import repositories.KasseRepository;
    import tho.nill.preislisten.simpleAttributes.DFÜMedium;


    import entities.Kasse;
    import repositories.KasseRepository;
    import tho.nill.preislisten.simpleAttributes.DFÜParameter;


    import entities.Kasse;
    import repositories.KasseRepository;
    import tho.nill.preislisten.simpleAttributes.Übermittlungszeichensatz;


    import entities.Kasse;
    import repositories.KasseRepository;
    import tho.nill.preislisten.simpleAttributes.Komprimierungsart;


    import entities.Kasse;
    import repositories.KasseRepository;
    import tho.nill.preislisten.simpleAttributes.DFÜProtokoll;


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
    import tho.nill.preislisten.simpleAttributes.Übertragungstage;


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

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new Kasse();
	}


	public Kasse getEntity() {
		return entity;
	}

	public void setEntity(Kasse entity) {
         this.entity = entity;
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
         


     	    public String getEmail() {
     	         return entity.getEmail(); 
     	    }
     	    public void setEmailWithString(String value) {
     	        	entity.setEmail(convertToString( value));
     	        }
         


     		    public LocalDate getGültigAb() {
     		         return entity.getGültigAb(); 
     		    }
     		    public void setGültigAbWithString(String value) {
     		        	entity.setGültigAb(convertToLocalDate( value));
     		        }
         


     		    public LocalDate getGültigBis() {
     		         return entity.getGültigBis(); 
     		    }
     		    public void setGültigBisWithString(String value) {
     		        	entity.setGültigBis(convertToLocalDate( value));
     		        }
         


     	    public String getIban() {
     	         return entity.getIban(); 
     	    }
     	    public void setIbanWithString(String value) {
     	        	entity.setIban(convertToString( value));
     	        }
         


     	    public String getBic() {
     	         return entity.getBic(); 
     	    }
     	    public void setBicWithString(String value) {
     	        	entity.setBic(convertToString( value));
     	        }
         


     	    public String getKontoinhaber() {
     	         return entity.getKontoinhaber(); 
     	    }
     	    public void setKontoinhaberWithString(String value) {
     	        	entity.setKontoinhaber(convertToString( value));
     	        }
         


     	    public String getName() {
     	         return entity.getName(); 
     	    }
     	    public void setNameWithString(String value) {
     	        	entity.setName(convertToString( value));
     	        }
         


     	    public String getName2() {
     	         return entity.getName2(); 
     	    }
     	    public void setName2WithString(String value) {
     	        	entity.setName2(convertToString( value));
     	        }
         


     	    public String getName3() {
     	         return entity.getName3(); 
     	    }
     	    public void setName3WithString(String value) {
     	        	entity.setName3(convertToString( value));
     	        }
         


     	    public String getName4() {
     	         return entity.getName4(); 
     	    }
     	    public void setName4WithString(String value) {
     	        	entity.setName4(convertToString( value));
     	        }
         


     	    public String getAnsprechpartner() {
     	         return entity.getAnsprechpartner(); 
     	    }
     	    public void setAnsprechpartnerWithString(String value) {
     	        	entity.setAnsprechpartner(convertToString( value));
     	        }
         


     	    public String getTelefon() {
     	         return entity.getTelefon(); 
     	    }
     	    public void setTelefonWithString(String value) {
     	        	entity.setTelefon(convertToString( value));
     	        }
         


     	    public String getFax() {
     	         return entity.getFax(); 
     	    }
     	    public void setFaxWithString(String value) {
     	        	entity.setFax(convertToString( value));
     	        }
         


     	    public String getArbeitsgebiet() {
     	         return entity.getArbeitsgebiet(); 
     	    }
     	    public void setArbeitsgebietWithString(String value) {
     	        	entity.setArbeitsgebiet(convertToString( value));
     	        }
         


     	    public DFÜMedium getMedium() {
     	         return entity.getMedium(); 
     	    }
     	    public void setMediumWithString(String value) {
     	        	entity.setMedium(convertToDFÜMedium( value));
     	        }

     	   public DFÜMedium convertToDFÜMedium(String value) {
     					return DFÜMedium.search(value);
     				}   


     	    public DFÜParameter getParameter() {
     	         return entity.getParameter(); 
     	    }
     	    public void setParameterWithString(String value) {
     	        	entity.setParameter(convertToDFÜParameter( value));
     	        }

     	   public DFÜParameter convertToDFÜParameter(String value) {
     					return DFÜParameter.search(value);
     				}   


     	    public Übermittlungszeichensatz getZeichensatz() {
     	         return entity.getZeichensatz(); 
     	    }
     	    public void setZeichensatzWithString(String value) {
     	        	entity.setZeichensatz(convertToÜbermittlungszeichensatz( value));
     	        }

     	   public Übermittlungszeichensatz convertToÜbermittlungszeichensatz(String value) {
     					return Übermittlungszeichensatz.search(value);
     				}   


     	    public Komprimierungsart getKomprimierung() {
     	         return entity.getKomprimierung(); 
     	    }
     	    public void setKomprimierungWithString(String value) {
     	        	entity.setKomprimierung(convertToKomprimierungsart( value));
     	        }

     	   public Komprimierungsart convertToKomprimierungsart(String value) {
     					return Komprimierungsart.search(value);
     				}   


     	    public DFÜProtokoll getProtokoll() {
     	         return entity.getProtokoll(); 
     	    }
     	    public void setProtokollWithString(String value) {
     	        	entity.setProtokoll(convertToDFÜProtokoll( value));
     	        }

     	   public DFÜProtokoll convertToDFÜProtokoll(String value) {
     					return DFÜProtokoll.search(value);
     				}   


     	    public String getBenutzerkennung() {
     	         return entity.getBenutzerkennung(); 
     	    }
     	    public void setBenutzerkennungWithString(String value) {
     	        	entity.setBenutzerkennung(convertToString( value));
     	        }
         


     	    public String getÜbertragung_von() {
     	         return entity.getÜbertragung_von(); 
     	    }
     	    public void setÜbertragung_vonWithString(String value) {
     	        	entity.setÜbertragung_von(convertToString( value));
     	        }
         


     	    public String getÜbertragung_bis() {
     	         return entity.getÜbertragung_bis(); 
     	    }
     	    public void setÜbertragung_bisWithString(String value) {
     	        	entity.setÜbertragung_bis(convertToString( value));
     	        }
         


     	    public Übertragungstage getÜbertragungstage() {
     	         return entity.getÜbertragungstage(); 
     	    }
     	    public void setÜbertragungstageWithString(String value) {
     	        	entity.setÜbertragungstage(convertToÜbertragungstage( value));
     	        }

     	   public Übertragungstage convertToÜbertragungstage(String value) {
     					return Übertragungstage.search(value);
     				}   


     	    public String getKommunikationskanal() {
     	         return entity.getKommunikationskanal(); 
     	    }
     	    public void setKommunikationskanalWithString(String value) {
     	        	entity.setKommunikationskanal(convertToString( value));
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


