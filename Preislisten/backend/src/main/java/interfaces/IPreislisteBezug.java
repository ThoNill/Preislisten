package interfaces;



import tho.nill.preislisten.simpleAttributes.BezugArt;


public interface IPreislisteBezug {

    Long getPreislisteBezugId();

         
        // Kind: value

     	    long getNummer();
     	    void setNummer(long value); 
        // Kind: enumeration


     	        BezugArt getArt();
     	        void setArt(BezugArt value); 
        // Kind: toone2many

     	      void setPreislisteKopf(IPreislisteKopf value);
}

