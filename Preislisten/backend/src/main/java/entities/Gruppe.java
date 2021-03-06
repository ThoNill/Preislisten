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

    import tho.nill.preislisten.simpleAttributes.GruppeArt;
    import java.lang.Long;
    import java.lang.String;
    import java.lang.String;


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

