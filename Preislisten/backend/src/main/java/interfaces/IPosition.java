package interfaces;



import tho.nill.preislisten.simpleAttributes.PositionsArt;


public interface IPosition {

    Long getPositionId();

         
        // Kind: enumeration


     	        PositionsArt getArt();
     	        void setArt(PositionsArt value); 
        // Kind: value

     	    String getNummer();
     	    void setNummer(String value); 
        // Kind: fromone2many

     	     void addPreislistePosition(IPreislistePosition x);
     	     void removePreislistePosition(IPreislistePosition x);

}

