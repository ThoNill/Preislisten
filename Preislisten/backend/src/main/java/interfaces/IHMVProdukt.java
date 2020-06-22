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

    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;


public interface IHMVProdukt {

    Long getHMVProduktId();

         
        // Kind: value

     	    String getHilfsmittelnr();
     	    void setHilfsmittelnr(String value); 
        // Kind: value

     	    String getProdukt();
     	    void setProdukt(String value); 
        // Kind: value

     	    String getBezeichnung();
     	    void setBezeichnung(String value); 
        // Kind: value

     	    String getHersteller();
     	    void setHersteller(String value); 
        // Kind: value

     	    String getMerkmal();
     	    void setMerkmal(String value); 
        // Kind: toone2many

     	      void setHMVArt(IHMVArt value);
}

