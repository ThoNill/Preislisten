package interfaces;

public interface IHMVArt {

    Long getHMVArtId();

         
        // Kind: value

     	    String getArt();
     	    void setArt(String value); 
        // Kind: value

     	    String getBezeichnung();
     	    void setBezeichnung(String value); 
        // Kind: value

     	    String getDefinition();
     	    void setDefinition(String value); 
        // Kind: value

     	    String getIndikation();
     	    void setIndikation(String value); 
        // Kind: toone2many

     	      void setHMVUntergruppe(IHMVUntergruppe value); 
        // Kind: fromone2many

     	     void addHMVProdukt(IHMVProdukt x);
     	     void removeHMVProdukt(IHMVProdukt x);

}

