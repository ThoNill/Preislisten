package interfaces;

public interface IHMVGruppe {

    Long getHMVGruppeId();

         
        // Kind: value

     	    Long getNummer();
     	    void setNummer(Long value); 
        // Kind: value

     	    String getBezeichnung();
     	    void setBezeichnung(String value); 
        // Kind: value

     	    String getDefinition();
     	    void setDefinition(String value); 
        // Kind: value

     	    String getIndikation();
     	    void setIndikation(String value); 
        // Kind: value

     	    String getQuerverweise();
     	    void setQuerverweise(String value); 
        // Kind: fromone2many

     	     void addHMVUntergruppe(IHMVUntergruppe x);
     	     void removeHMVUntergruppe(IHMVUntergruppe x);

}

