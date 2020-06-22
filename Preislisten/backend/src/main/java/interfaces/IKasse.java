package interfaces;



import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KasseArt;
import tho.nill.preislisten.simpleAttributes.KassenFunktion;


public interface IKasse {

    Long getKasseId();

         
        // Kind: value

     	    IK getIk();
     	    void setIk(IK value); 
        // Kind: enumeration


     	        KasseArt getArt();
     	        void setArt(KasseArt value); 
        // Kind: enumeration


     	        KassenFunktion getFunktion();
     	        void setFunktion(KassenFunktion value); 
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
        // Kind: fromone2many

     	     void addVersandZiel(IVersandZiel x);
     	     void removeVersandZiel(IVersandZiel x);

}

