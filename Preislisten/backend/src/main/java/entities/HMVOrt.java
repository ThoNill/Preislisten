package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

