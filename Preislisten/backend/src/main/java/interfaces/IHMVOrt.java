package interfaces;

public interface IHMVOrt {

    Long getHMVOrtId();

         
        // Kind: value

     	    String getOrt();
     	    void setOrt(String value); 
        // Kind: value

     	    String getBezeichnung();
     	    void setBezeichnung(String value); 
        // Kind: fromone2many

     	     void addHMVUntergruppe(IHMVUntergruppe x);
     	     void removeHMVUntergruppe(IHMVUntergruppe x);

}

