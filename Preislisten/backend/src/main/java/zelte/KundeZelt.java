package zelte;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Kunde;
import repositories.KundeRepository;
import tho.nill.preislisten.simpleAttributes.Abrechnungscode;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.Tarifbereich;

public class KundeZelt extends StandardZelt {


	private Kunde entity;

	@Autowired
	private KundeRepository repo;

	@Override
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




	@Override
	public void create() {
		save();
		entity = new Kunde();
	}


	Kunde getEntity() {
		return entity;
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
     					return Tarifbereich.valueOf(value);
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


