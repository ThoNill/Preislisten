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
    import java.lang.String;

    import entities.HMVOrt;

    import entities.HMVUntergruppe;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "HMVORT")
@SequenceGenerator(name = "HMVORT_SEQ", sequenceName = "HMVORT_SEQ")
public class HMVOrt  {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "HMVORTID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HMVORT_SEQ")
    private java.lang.Long HMVOrtId;

         
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

         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "HMVOrt", 
     	               orphanRemoval = true
     	               )
     	    private Set<HMVUntergruppe> HMVUntergruppe = new HashSet<>();



     	    public void addHMVUntergruppe(HMVUntergruppe x) {
     	        this.HMVUntergruppe.add((HMVUntergruppe)x);
     	        x.setHMVOrt(this);
     	    }


     	    public void removeHMVUntergruppe(HMVUntergruppe x) {
     	        this.HMVUntergruppe.remove((HMVUntergruppe)x);
     	        x.setHMVOrt(null);
     	    }


}

