package interfaces;



import tho.nill.preislisten.simpleAttributes.Abrechnungscode;
import tho.nill.preislisten.simpleAttributes.Bundesland;
import tho.nill.preislisten.simpleAttributes.DFÜMedium;
import tho.nill.preislisten.simpleAttributes.DatenlieferungsArt;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KVBezirk;
import tho.nill.preislisten.simpleAttributes.Kostenträger;
import tho.nill.preislisten.simpleAttributes.Tarifkennzeichen;


public interface IVersandZiel {

    Long getVersandZielId();

         
        // Kind: value

     	    IK getVon_ik();
     	    void setVon_ik(IK value); 
        // Kind: value

     	    IK getNach_ik();
     	    void setNach_ik(IK value); 
        // Kind: value

     	    IK getAbrechnungsstelle();
     	    void setAbrechnungsstelle(IK value); 
        // Kind: enumeration


     	        DatenlieferungsArt getArt();
     	        void setArt(DatenlieferungsArt value); 
        // Kind: enumeration


     	        Kostenträger getVerweis();
     	        void setVerweis(Kostenträger value); 
        // Kind: enumeration


     	        DFÜMedium getMedium();
     	        void setMedium(DFÜMedium value); 
        // Kind: enumeration


     	        Bundesland getLand();
     	        void setLand(Bundesland value); 
        // Kind: enumeration


     	        KVBezirk getBezirk();
     	        void setBezirk(KVBezirk value); 
        // Kind: enumeration


     	        Abrechnungscode getAbrechnungscode();
     	        void setAbrechnungscode(Abrechnungscode value); 
        // Kind: value

     	    Tarifkennzeichen getTarifkennzeichen();
     	    void setTarifkennzeichen(Tarifkennzeichen value); 
        // Kind: toone2many

     	      void setKasse(IKasse value);
}

