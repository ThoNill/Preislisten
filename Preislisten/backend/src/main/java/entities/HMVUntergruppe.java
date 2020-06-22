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

    import interfaces.IHMVGruppe;

    import interfaces.IHMVUntergruppe;
    import interfaces.IHMVOrt;

    import interfaces.IHMVUntergruppe;
    import interfaces.IHMVUntergruppe;

    import interfaces.IHMVArt;


import interfaces.IHMVUntergruppe;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "HMVUNTERGRUPPE")
@SequenceGenerator(name = "HMVUNTERGRUPPE_SEQ", sequenceName = "HMVUNTERGRUPPE_SEQ")
public class HMVUntergruppe implements IHMVUntergruppe {

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

     	    @Override
     	    public void setHMVGruppe(IHMVGruppe value) {
     	 	   HMVGruppe = (HMVGruppe) value;
     	    }


         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "HMVOrt_Id")
     		private HMVOrt HMVOrt;

     	    @Override
     	    public void setHMVOrt(IHMVOrt value) {
     	 	   HMVOrt = (HMVOrt) value;
     	    }


         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "HMVUntergruppe", 
     	               orphanRemoval = true
     	               )
     	    private Set<HMVArt> HMVArt = new HashSet<>();


     	    @Override
     	    public void addHMVArt(IHMVArt x) {
     	        this.HMVArt.add((HMVArt)x);
     	        x.setHMVUntergruppe(this);
     	    }

     	    @Override
     	    public void removeHMVArt(IHMVArt x) {
     	        this.HMVArt.remove((HMVArt)x);
     	        x.setHMVUntergruppe(null);
     	    }


}

