package interfaces;

public interface IHMVProdukt {

    Long getHMVProduktId();

         
        // Kind: value

     	    String getHilfsmittelnr();
     	    void setHilfsmittelnr(String value); 
        // Kind: value

     	    String getProdukt();
     	    void setProdukt(String value); 
        // Kind: value

     	    String getBezeichnung();
     	    void setBezeichnung(String value); 
        // Kind: value

     	    String getHersteller();
     	    void setHersteller(String value); 
        // Kind: value

     	    String getMerkmal();
     	    void setMerkmal(String value); 
        // Kind: toone2many

     	      void setHMVArt(IHMVArt value);
}

