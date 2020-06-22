package interfaces;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

    import tho.nill.preislisten.simpleAttributes.PreislisteArt;
    import java.lang.String;
    import java.time.LocalDate;
    import tho.nill.preislisten.simpleAttributes.DatumArt;


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

