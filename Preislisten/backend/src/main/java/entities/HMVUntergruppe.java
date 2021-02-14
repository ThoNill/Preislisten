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
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;
    import org.nill.vorlagen.compiler.markerClasses.CharBLOB;

    import entities.HMVGruppe;

    import entities.HMVUntergruppe;
    import entities.HMVOrt;

    import entities.HMVUntergruppe;
    import entities.HMVUntergruppe;

    import entities.HMVArt;


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
     	    @Column(name = "BEZEICHNUNG")
     	    private String bezeichnung;
         
        // Kind: (CharBLOB)

     		@Lob
     	    @Column(name = "ANFORDERUNGEN")
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

