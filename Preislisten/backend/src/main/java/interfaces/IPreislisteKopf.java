package interfaces;



import java.time.LocalDate;

import tho.nill.preislisten.simpleAttributes.DatumArt;
import tho.nill.preislisten.simpleAttributes.PreislisteArt;


public interface IPreislisteKopf {

    Long getPreislisteKopfId();

         
        // Kind: enumeration


     	        PreislisteArt getArt();
     	        void setArt(PreislisteArt value); 
        // Kind: value

     	    String getTarifkennzeichen();
     	    void setTarifkennzeichen(String value); 
        // Kind: LocalDate

     		     LocalDate getGültigAb();
     		     void setGültigAb(LocalDate value); 
        // Kind: enumeration


     	        DatumArt getDart();
     	        void setDart(DatumArt value); 
        // Kind: fromone2many

     	     void addPreislisteBezug(IPreislisteBezug x);
     	     void removePreislisteBezug(IPreislisteBezug x);
         
        // Kind: fromone2many

     	     void addPreislistePosition(IPreislistePosition x);
     	     void removePreislistePosition(IPreislistePosition x);

}

