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

    import tho.nill.preislisten.simpleAttributes.IK;
    import tho.nill.preislisten.simpleAttributes.Tarifbereich;
    import tho.nill.preislisten.simpleAttributes.Abrechnungscode;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;


public interface IKunde {

    Long getKundeId();

         
        // Kind: value

     	    IK getIk();
     	    void setIk(IK value); 
        // Kind: enumeration


     	        Tarifbereich getTarifbereich();
     	        void setTarifbereich(Tarifbereich value); 
        // Kind: enumeration


     	        Abrechnungscode getAbrechnungscode();
     	        void setAbrechnungscode(Abrechnungscode value); 
        // Kind: value

     	    String getAnsprechpartner();
     	    void setAnsprechpartner(String value); 
        // Kind: value

     	    String getFirma();
     	    void setFirma(String value); 
        // Kind: value

     	    String getPlz();
     	    void setPlz(String value); 
        // Kind: value

     	    String getOrt();
     	    void setOrt(String value); 
        // Kind: value

     	    String getStraße();
     	    void setStraße(String value); 
        // Kind: value

     	    String getTelefon();
     	    void setTelefon(String value); 
        // Kind: value

     	    String getEmail();
     	    void setEmail(String value);
}

