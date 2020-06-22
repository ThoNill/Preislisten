package interfaces;

public interface IHMVUntergruppe {

    Long getHMVUntergruppeId();

         
        // Kind: value

     	    String getUntergruppe();
     	    void setUntergruppe(String value); 
        // Kind: value

     	    String getBezeichnung();
     	    void setBezeichnung(String value); 
        // Kind: value

     	    String getAnforderungen();
     	    void setAnforderungen(String value); 
        // Kind: toone2many

     	      void setHMVGruppe(IHMVGruppe value); 
        // Kind: toone2many

     	      void setHMVOrt(IHMVOrt value); 
        // Kind: fromone2many

     	     void addHMVArt(IHMVArt x);
     	     void removeHMVArt(IHMVArt x);

}

