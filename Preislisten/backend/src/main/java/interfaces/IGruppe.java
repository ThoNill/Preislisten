package interfaces;



import tho.nill.preislisten.simpleAttributes.GruppeArt;


public interface IGruppe {

    Long getGruppeId();

         
        // Kind: enumeration


     	        GruppeArt getArt();
     	        void setArt(GruppeArt value); 
        // Kind: value

     	    Long getNummer();
     	    void setNummer(Long value); 
        // Kind: value

     	    String getBezeichnung();
     	    void setBezeichnung(String value); 
        // Kind: value

     	    String getWert();
     	    void setWert(String value);
}

