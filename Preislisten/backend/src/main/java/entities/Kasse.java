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
    import tho.nill.preislisten.simpleAttributes.KasseArt;
    import tho.nill.preislisten.simpleAttributes.KassenFunktion;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;

    import entities.Kasse;

    import entities.VersandZiel;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "KASSE")
@SequenceGenerator(name = "KASSE_SEQ", sequenceName = "KASSE_SEQ")
public class Kasse  {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "KASSEID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KASSE_SEQ")
    private java.lang.Long KasseId;

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "IK")
     	     @Convert(converter = tho.nill.preislisten.simpleAttributes.IKAdapter.class)
     	    private IK ik;


     	    public IK getIk() {
     	    	return ik;
     	    }

     	    public void setIk(IK value) {
     	    	ik = value;
     	    }

         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "ART")
     	    private KasseArt art;


     	    public KasseArt getArt() {
     	    	return art;
     	    }

     	    public void setArt(KasseArt value) {
     	    	art = value;
     	    }
         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "FUNKTION")
     	    private KassenFunktion funktion;


     	    public KassenFunktion getFunktion() {
     	    	return funktion;
     	    }

     	    public void setFunktion(KassenFunktion value) {
     	    	funktion = value;
     	    }
         
        // Kind: (value)


     		@Basic
     	    @Column(name = "ANSPRECHPARTNER")
     	    private String ansprechpartner;


     	    public String getAnsprechpartner() {
     	    	return ansprechpartner;
     	    }

     	    public void setAnsprechpartner(String value) {
     	    	ansprechpartner = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "FIRMA")
     	    private String firma;


     	    public String getFirma() {
     	    	return firma;
     	    }

     	    public void setFirma(String value) {
     	    	firma = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "PLZ")
     	    private String plz;


     	    public String getPlz() {
     	    	return plz;
     	    }

     	    public void setPlz(String value) {
     	    	plz = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "ORT")
     	    private String ort;


     	    public String getOrt() {
     	    	return ort;
     	    }

     	    public void setOrt(String value) {
     	    	ort = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "STRASSE")
     	    private String straße;


     	    public String getStraße() {
     	    	return straße;
     	    }

     	    public void setStraße(String value) {
     	    	straße = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "TELEFON")
     	    private String telefon;


     	    public String getTelefon() {
     	    	return telefon;
     	    }

     	    public void setTelefon(String value) {
     	    	telefon = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "EMAIL")
     	    private String email;


     	    public String getEmail() {
     	    	return email;
     	    }

     	    public void setEmail(String value) {
     	    	email = value;
     	    }

         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "Kasse", 
     	               orphanRemoval = true
     	               )
     	    private Set<VersandZiel> VersandZiel = new HashSet<>();



     	    public void addVersandZiel(VersandZiel x) {
     	        this.VersandZiel.add((VersandZiel)x);
     	        x.setKasse(this);
     	    }


     	    public void removeVersandZiel(VersandZiel x) {
     	        this.VersandZiel.remove((VersandZiel)x);
     	        x.setKasse(null);
     	    }


}

