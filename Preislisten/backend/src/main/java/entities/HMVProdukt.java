package entities;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


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
     	    @Column(name = "MERKMALE")
     	    private String merkmale;


     	    public String getMerkmale() {
     	    	return merkmale;
     	    }

     	    public void setMerkmale(String value) {
     	    	merkmale = value;
     	    }

         
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

