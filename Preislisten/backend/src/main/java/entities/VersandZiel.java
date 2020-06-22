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

    import tho.nill.preislisten.simpleAttributes.IK;
    import tho.nill.preislisten.simpleAttributes.IK;
    import tho.nill.preislisten.simpleAttributes.IK;
    import tho.nill.preislisten.simpleAttributes.DatenlieferungsArt;
    import tho.nill.preislisten.simpleAttributes.Kostenträger;
    import tho.nill.preislisten.simpleAttributes.DFÜMedium;
    import tho.nill.preislisten.simpleAttributes.Bundesland;
    import tho.nill.preislisten.simpleAttributes.KVBezirk;
    import tho.nill.preislisten.simpleAttributes.Abrechnungscode;
    import tho.nill.preislisten.simpleAttributes.Tarifkennzeichen;

    import interfaces.IKasse;

    import interfaces.IVersandZiel;


import interfaces.IVersandZiel;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "VERSANDZIEL")
@SequenceGenerator(name = "VERSANDZIEL_SEQ", sequenceName = "VERSANDZIEL_SEQ")
public class VersandZiel implements IVersandZiel {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "VERSANDZIELID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VERSANDZIEL_SEQ")
    private java.lang.Long VersandZielId;

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "VON_IK")
     	     @Convert(converter = tho.nill.preislisten.simpleAttributes.IKAdapter.class)
     	    private IK von_ik;


     	    public IK getVon_ik() {
     	    	return von_ik;
     	    }

     	    public void setVon_ik(IK value) {
     	    	von_ik = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "NACH_IK")
     	     @Convert(converter = tho.nill.preislisten.simpleAttributes.IKAdapter.class)
     	    private IK nach_ik;


     	    public IK getNach_ik() {
     	    	return nach_ik;
     	    }

     	    public void setNach_ik(IK value) {
     	    	nach_ik = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "ABRECHNUNGSSTELLE")
     	     @Convert(converter = tho.nill.preislisten.simpleAttributes.IKAdapter.class)
     	    private IK abrechnungsstelle;


     	    public IK getAbrechnungsstelle() {
     	    	return abrechnungsstelle;
     	    }

     	    public void setAbrechnungsstelle(IK value) {
     	    	abrechnungsstelle = value;
     	    }

         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "ART")
     	    private DatenlieferungsArt art;


     	    public DatenlieferungsArt getArt() {
     	    	return art;
     	    }

     	    public void setArt(DatenlieferungsArt value) {
     	    	art = value;
     	    }
         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "VERWEIS")
     	    private Kostenträger verweis;


     	    public Kostenträger getVerweis() {
     	    	return verweis;
     	    }

     	    public void setVerweis(Kostenträger value) {
     	    	verweis = value;
     	    }
         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "MEDIUM")
     	    private DFÜMedium medium;


     	    public DFÜMedium getMedium() {
     	    	return medium;
     	    }

     	    public void setMedium(DFÜMedium value) {
     	    	medium = value;
     	    }
         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "LAND")
     	    private Bundesland land;


     	    public Bundesland getLand() {
     	    	return land;
     	    }

     	    public void setLand(Bundesland value) {
     	    	land = value;
     	    }
         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "BEZIRK")
     	    private KVBezirk bezirk;


     	    public KVBezirk getBezirk() {
     	    	return bezirk;
     	    }

     	    public void setBezirk(KVBezirk value) {
     	    	bezirk = value;
     	    }
         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "ABRECHNUNGSCODE")
     	    private Abrechnungscode abrechnungscode;


     	    public Abrechnungscode getAbrechnungscode() {
     	    	return abrechnungscode;
     	    }

     	    public void setAbrechnungscode(Abrechnungscode value) {
     	    	abrechnungscode = value;
     	    }
         
        // Kind: (value)


     		@Basic
     	    @Column(name = "TARIFKENNZEICHEN")
     	     @Convert(converter = tho.nill.preislisten.simpleAttributes.TarifkennzeichenAdapter.class)
     	    private Tarifkennzeichen tarifkennzeichen;


     	    public Tarifkennzeichen getTarifkennzeichen() {
     	    	return tarifkennzeichen;
     	    }

     	    public void setTarifkennzeichen(Tarifkennzeichen value) {
     	    	tarifkennzeichen = value;
     	    }

         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "Kasse_Id")
     		private Kasse Kasse;

     	    @Override
     	    public void setKasse(IKasse value) {
     	 	   Kasse = (Kasse) value;
     	    }


}

