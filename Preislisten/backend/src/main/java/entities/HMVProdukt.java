package entities;

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
import javax.persistence.Lob;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;

    import entities.HMVArt;

    import entities.HMVProdukt;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "HMVPRODUKT")
@SequenceGenerator(name = "HMVPRODUKT_SEQ", sequenceName = "HMVPRODUKT_SEQ")
public class HMVProdukt  {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "HMVPRODUKTID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HMVPRODUKT_SEQ")
    private java.lang.Long HMVProduktId;

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "HILFSMITTELNR")
     	    private String hilfsmittelnr;


     	    public String getHilfsmittelnr() {
     	    	return hilfsmittelnr;
     	    }

     	    public void setHilfsmittelnr(String value) {
     	    	hilfsmittelnr = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "PRODUKT")
     	    private String produkt;


     	    public String getProdukt() {
     	    	return produkt;
     	    }

     	    public void setProdukt(String value) {
     	    	produkt = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "BEZEICHNUNG")
     	    private String bezeichnung;


     	    public String getBezeichnung() {
     	    	return bezeichnung;
     	    }

     	    public void setBezeichnung(String value) {
     	    	bezeichnung = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "HERSTELLER")
     	    private String hersteller;


     	    public String getHersteller() {
     	    	return hersteller;
     	    }

     	    public void setHersteller(String value) {
     	    	hersteller = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "MERKMAL")
     	    private String merkmal;


     	    public String getMerkmal() {
     	    	return merkmal;
     	    }

     	    public void setMerkmal(String value) {
     	    	merkmal = value;
     	    }

         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "HMVArt_Id")
     		private HMVArt HMVArt;


     	    public void setHMVArt(HMVArt value) {
     	 	   HMVArt = (HMVArt) value;
     	    }


}

