package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import tho.nill.preislisten.simpleAttributes.GruppeArt;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "GRUPPE")
@SequenceGenerator(name = "GRUPPE_SEQ", sequenceName = "GRUPPE_SEQ")
public class Gruppe  {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "GRUPPEID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRUPPE_SEQ")
    private java.lang.Long GruppeId;

         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "ART")
     	    private GruppeArt art;


     	    public GruppeArt getArt() {
     	    	return art;
     	    }

     	    public void setArt(GruppeArt value) {
     	    	art = value;
     	    }
         
        // Kind: (value)


     		@Basic
     	    @Column(name = "NUMMER")
     	    private Long nummer;


     	    public Long getNummer() {
     	    	return nummer;
     	    }

     	    public void setNummer(Long value) {
     	    	nummer = value;
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
     	    @Column(name = "WERT")
     	    private String wert;


     	    public String getWert() {
     	    	return wert;
     	    }

     	    public void setWert(String value) {
     	    	wert = value;
     	    }

}

