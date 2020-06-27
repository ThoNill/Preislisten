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
import javax.persistence.Lob;
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

         
        // Kind: (CharBLOB)

     		@Lob
     	    @Column(name = "BEZEICHNUNG", columnDefinition="clob")
     	    private String bezeichnung;
         
        // Kind: (CharBLOB)

     		@Lob
     	    @Column(name = "ANFORDERUNGEN", columnDefinition="clob")
     	    private String anforderungen;
         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "HMVGruppe_Id")
     		private HMVGruppe HMVGruppe;


     	    public void setHMVGruppe(HMVGruppe value) {
     	 	   HMVGruppe = (HMVGruppe) value;
     	    }


         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "HMVOrt_Id")
     		private HMVOrt HMVOrt;


     	    public void setHMVOrt(HMVOrt value) {
     	 	   HMVOrt = (HMVOrt) value;
     	    }


         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "HMVUntergruppe", 
     	               orphanRemoval = true
     	               )
     	    private Set<HMVArt> HMVArt = new HashSet<>();



     	    public void addHMVArt(HMVArt x) {
     	        this.HMVArt.add((HMVArt)x);
     	        x.setHMVUntergruppe(this);
     	    }


     	    public void removeHMVArt(HMVArt x) {
     	        this.HMVArt.remove((HMVArt)x);
     	        x.setHMVUntergruppe(null);
     	    }


}

