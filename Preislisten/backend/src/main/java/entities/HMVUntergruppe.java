package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "HMVUNTERGRUPPE")
@SequenceGenerator(name = "HMVUNTERGRUPPE_SEQ", sequenceName = "HMVUNTERGRUPPE_SEQ")
public class HMVUntergruppe  {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "HMVUNTERGRUPPEID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HMVUNTERGRUPPE_SEQ")
    private java.lang.Long HMVUntergruppeId;

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "UNTERGRUPPE")
     	    private String untergruppe;


     	    public String getUntergruppe() {
     	    	return untergruppe;
     	    }

     	    public void setUntergruppe(String value) {
     	    	untergruppe = value;
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
     	    @Column(name = "ANFORDERUNGEN")
     	    private String anforderungen;


     	    public String getAnforderungen() {
     	    	return anforderungen;
     	    }

     	    public void setAnforderungen(String value) {
     	    	anforderungen = value;
     	    }

         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "HMVGruppe_Id")
     		private HMVGruppe HMVGruppe;


     	    public void setHMVGruppe(HMVGruppe value) {
     	 	   HMVGruppe = value;
     	    }


         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "HMVOrt_Id")
     		private HMVOrt HMVOrt;


     	    public void setHMVOrt(HMVOrt value) {
     	 	   HMVOrt = value;
     	    }


         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "HMVUntergruppe", 
     	               orphanRemoval = true
     	               )
     	    private Set<HMVArt> HMVArt = new HashSet<>();



     	    public void addHMVArt(HMVArt x) {
     	        this.HMVArt.add(x);
     	        x.setHMVUntergruppe(this);
     	    }


     	    public void removeHMVArt(HMVArt x) {
     	        this.HMVArt.remove(x);
     	        x.setHMVUntergruppe(null);
     	    }


}

