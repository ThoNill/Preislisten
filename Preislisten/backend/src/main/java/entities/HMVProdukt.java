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

    import java.lang.Long;
    import java.lang.Long;
    import java.lang.Long;
    import java.lang.Long;
    import java.lang.Long;
    import java.lang.String;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;
    import java.lang.String;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;
    import java.time.LocalDate;

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
     	    @Column(name = "PRODUKT")
     	    private Long produkt;


     	    public Long getProdukt() {
     	    	return produkt;
     	    }

     	    public void setProdukt(Long value) {
     	    	produkt = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "ART")
     	    private Long art;


     	    public Long getArt() {
     	    	return art;
     	    }

     	    public void setArt(Long value) {
     	    	art = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "GRUPPE")
     	    private Long gruppe;


     	    public Long getGruppe() {
     	    	return gruppe;
     	    }

     	    public void setGruppe(Long value) {
     	    	gruppe = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "UNTERGRUPPE")
     	    private Long untergruppe;


     	    public Long getUntergruppe() {
     	    	return untergruppe;
     	    }

     	    public void setUntergruppe(Long value) {
     	    	untergruppe = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "ORT")
     	    private Long ort;


     	    public Long getOrt() {
     	    	return ort;
     	    }

     	    public void setOrt(Long value) {
     	    	ort = value;
     	    }

         
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

         
        // Kind: (CharBLOB)

     		@Lob
     	    @Column(name = "BEZEICHNUNG")
     	    private String bezeichnung;
         
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

         
        // Kind: (CharBLOB)

     		@Lob
     	    @Column(name = "MERKMALE")
     	    private String merkmale;
         
        // Kind: (LocalDate)



     		    @Column(name = "ÄNDERUNG", columnDefinition = "DATE")
     		    private LocalDate änderung;


     		    public LocalDate getÄnderung() {
     		    	return änderung;
     		    }

     		    public void setÄnderung(LocalDate value) {
     		    	änderung = value;
     		    }

         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "HMVArt_Id")
     		private HMVArt HMVArt;


     	    public void setHMVArt(HMVArt value) {
     	 	   HMVArt = (HMVArt) value;
     	    }


}

