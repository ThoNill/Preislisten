package interfaces;



import tho.nill.preislisten.simpleAttributes.Mwst;


public interface IPreislistePosition {

    Long getPreislistePositionId();

         
        // Kind: value

     	    double getPreis();
     	    void setPreis(double value); 
        // Kind: enumeration


     	        Mwst getMwst();
     	        void setMwst(Mwst value); 
        // Kind: toone2many

     	      void setPreislisteKopf(IPreislisteKopf value); 
        // Kind: toone2many

     	      void setPosition(IPosition value);
}

