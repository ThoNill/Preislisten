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
    import java.time.LocalDate;
    import java.time.LocalDate;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import tho.nill.preislisten.simpleAttributes.DFÜMedium;
    import tho.nill.preislisten.simpleAttributes.DFÜParameter;
    import tho.nill.preislisten.simpleAttributes.Übermittlungszeichensatz;
    import tho.nill.preislisten.simpleAttributes.Komprimierungsart;
    import tho.nill.preislisten.simpleAttributes.DFÜProtokoll;
    import java.lang.String;
    import java.lang.String;
    import java.lang.String;
    import tho.nill.preislisten.simpleAttributes.Übertragungstage;
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
     	    @Column(name = "EMAIL")
     	    private String email;


     	    public String getEmail() {
     	    	return email;
     	    }

     	    public void setEmail(String value) {
     	    	email = value;
     	    }

         
        // Kind: (LocalDate)



     		    @Column(name = "GÜLTIGAB", columnDefinition = "DATE")
     		    private LocalDate gültigAb;


     		    public LocalDate getGültigAb() {
     		    	return gültigAb;
     		    }

     		    public void setGültigAb(LocalDate value) {
     		    	gültigAb = value;
     		    }

         
        // Kind: (LocalDate)



     		    @Column(name = "GÜLTIGBIS", columnDefinition = "DATE")
     		    private LocalDate gültigBis;


     		    public LocalDate getGültigBis() {
     		    	return gültigBis;
     		    }

     		    public void setGültigBis(LocalDate value) {
     		    	gültigBis = value;
     		    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "IBAN")
     	    private String iban;


     	    public String getIban() {
     	    	return iban;
     	    }

     	    public void setIban(String value) {
     	    	iban = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "BIC")
     	    private String bic;


     	    public String getBic() {
     	    	return bic;
     	    }

     	    public void setBic(String value) {
     	    	bic = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "KONTOINHABER")
     	    private String kontoinhaber;


     	    public String getKontoinhaber() {
     	    	return kontoinhaber;
     	    }

     	    public void setKontoinhaber(String value) {
     	    	kontoinhaber = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "NAME")
     	    private String name;


     	    public String getName() {
     	    	return name;
     	    }

     	    public void setName(String value) {
     	    	name = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "NAME2")
     	    private String name2;


     	    public String getName2() {
     	    	return name2;
     	    }

     	    public void setName2(String value) {
     	    	name2 = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "NAME3")
     	    private String name3;


     	    public String getName3() {
     	    	return name3;
     	    }

     	    public void setName3(String value) {
     	    	name3 = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "NAME4")
     	    private String name4;


     	    public String getName4() {
     	    	return name4;
     	    }

     	    public void setName4(String value) {
     	    	name4 = value;
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
     	    @Column(name = "FAX")
     	    private String fax;


     	    public String getFax() {
     	    	return fax;
     	    }

     	    public void setFax(String value) {
     	    	fax = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "ARBEITSGEBIET")
     	    private String arbeitsgebiet;


     	    public String getArbeitsgebiet() {
     	    	return arbeitsgebiet;
     	    }

     	    public void setArbeitsgebiet(String value) {
     	    	arbeitsgebiet = value;
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
     	    @Column(name = "PARAMETER")
     	    private DFÜParameter parameter;


     	    public DFÜParameter getParameter() {
     	    	return parameter;
     	    }

     	    public void setParameter(DFÜParameter value) {
     	    	parameter = value;
     	    }
         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "ZEICHENSATZ")
     	    private Übermittlungszeichensatz zeichensatz;


     	    public Übermittlungszeichensatz getZeichensatz() {
     	    	return zeichensatz;
     	    }

     	    public void setZeichensatz(Übermittlungszeichensatz value) {
     	    	zeichensatz = value;
     	    }
         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "KOMPRIMIERUNG")
     	    private Komprimierungsart komprimierung;


     	    public Komprimierungsart getKomprimierung() {
     	    	return komprimierung;
     	    }

     	    public void setKomprimierung(Komprimierungsart value) {
     	    	komprimierung = value;
     	    }
         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "PROTOKOLL")
     	    private DFÜProtokoll protokoll;


     	    public DFÜProtokoll getProtokoll() {
     	    	return protokoll;
     	    }

     	    public void setProtokoll(DFÜProtokoll value) {
     	    	protokoll = value;
     	    }
         
        // Kind: (value)


     		@Basic
     	    @Column(name = "BENUTZERKENNUNG")
     	    private String benutzerkennung;


     	    public String getBenutzerkennung() {
     	    	return benutzerkennung;
     	    }

     	    public void setBenutzerkennung(String value) {
     	    	benutzerkennung = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "ÜBERTRAGUNG_VON")
     	    private String übertragung_von;


     	    public String getÜbertragung_von() {
     	    	return übertragung_von;
     	    }

     	    public void setÜbertragung_von(String value) {
     	    	übertragung_von = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "ÜBERTRAGUNG_BIS")
     	    private String übertragung_bis;


     	    public String getÜbertragung_bis() {
     	    	return übertragung_bis;
     	    }

     	    public void setÜbertragung_bis(String value) {
     	    	übertragung_bis = value;
     	    }

         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "ÜBERTRAGUNGSTAGE")
     	    private Übertragungstage übertragungstage;


     	    public Übertragungstage getÜbertragungstage() {
     	    	return übertragungstage;
     	    }

     	    public void setÜbertragungstage(Übertragungstage value) {
     	    	übertragungstage = value;
     	    }
         
        // Kind: (value)


     		@Basic
     	    @Column(name = "KOMMUNIKATIONSKANAL")
     	    private String kommunikationskanal;


     	    public String getKommunikationskanal() {
     	    	return kommunikationskanal;
     	    }

     	    public void setKommunikationskanal(String value) {
     	    	kommunikationskanal = value;
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

