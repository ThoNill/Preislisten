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
import javax.persistence.Lob;
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
@Table(name = "HMVGRUPPE")
@SequenceGenerator(name = "HMVGRUPPE_SEQ", sequenceName = "HMVGRUPPE_SEQ")
public class HMVGruppe  {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "HMVGRUPPEID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HMVGRUPPE_SEQ")
    private java.lang.Long HMVGruppeId;

         
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

         
        // Kind: (CharBLOB)

     		@Lob
     	    @Column(name = "BEZEICHNUNG", columnDefinition="clob")
     	    private String bezeichnung;
         
        // Kind: (CharBLOB)

     		@Lob
     	    @Column(name = "DEFINITION", columnDefinition="clob")
     	    private String definition;
         
        // Kind: (CharBLOB)

     		@Lob
     	    @Column(name = "INDIKATION", columnDefinition="clob")
     	    private String indikation;
         
        // Kind: (CharBLOB)

     		@Lob
     	    @Column(name = "QUERVERWEISE", columnDefinition="clob")
     	    private String querverweise;
         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "HMVGruppe", 
     	               orphanRemoval = true
     	               )
     	    private Set<HMVUntergruppe> HMVUntergruppe = new HashSet<>();



     	    public void addHMVUntergruppe(HMVUntergruppe x) {
     	        this.HMVUntergruppe.add((HMVUntergruppe)x);
     	        x.setHMVGruppe(this);
     	    }


     	    public void removeHMVUntergruppe(HMVUntergruppe x) {
     	        this.HMVUntergruppe.remove((HMVUntergruppe)x);
     	        x.setHMVGruppe(null);
     	    }


}

