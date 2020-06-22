package interfaces;



import tho.nill.preislisten.simpleAttributes.Abrechnungscode;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.Tarifbereich;


public interface IKunde {

    Long getKundeId();

         
        // Kind: value

     	    IK getIk();
     	    void setIk(IK value); 
        // Kind: enumeration


     	        Tarifbereich getTarifbereich();
     	        void setTarifbereich(Tarifbereich value); 
        // Kind: enumeration


     	        Abrechnungscode getAbrechnungscode();
     	        void setAbrechnungscode(Abrechnungscode value); 
        // Kind: value

     	    String getAnsprechpartner();
     	    void setAnsprechpartner(String value); 
        // Kind: value

     	    String getFirma();
     	    void setFirma(String value); 
        // Kind: value

     	    String getPlz();
     	    void setPlz(String value); 
        // Kind: value

     	    String getOrt();
     	    void setOrt(String value); 
        // Kind: value

     	    String getStraße();
     	    void setStraße(String value); 
        // Kind: value

     	    String getTelefon();
     	    void setTelefon(String value); 
        // Kind: value

     	    String getEmail();
     	    void setEmail(String value);
}

