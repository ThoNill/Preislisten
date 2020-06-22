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

import interfaces.IHMVGruppe;
import interfaces.IHMVUntergruppe;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "HMVGRUPPE")
@SequenceGenerator(name = "HMVGRUPPE_SEQ", sequenceName = "HMVGRUPPE_SEQ")
public class HMVGruppe implements IHMVGruppe {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "HMVGRUPPEID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HMVGRUPPE_SEQ")
    private java.lang.Long HMVGruppeId;

         
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
     	    @Column(name = "DEFINITION")
     	    private String definition;


     	    public String getDefinition() {
     	    	return definition;
     	    }

     	    public void setDefinition(String value) {
     	    	definition = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "INDIKATION")
     	    private String indikation;


     	    public String getIndikation() {
     	    	return indikation;
     	    }

     	    public void setIndikation(String value) {
     	    	indikation = value;
     	    }

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "QUERVERWEISE")
     	    private String querverweise;


     	    public String getQuerverweise() {
     	    	return querverweise;
     	    }

     	    public void setQuerverweise(String value) {
     	    	querverweise = value;
     	    }

         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "HMVGruppe", 
     	               orphanRemoval = true
     	               )
     	    private Set<HMVUntergruppe> HMVUntergruppe = new HashSet<>();


     	    @Override
     	    public void addHMVUntergruppe(IHMVUntergruppe x) {
     	        this.HMVUntergruppe.add((HMVUntergruppe)x);
     	        x.setHMVGruppe(this);
     	    }

     	    @Override
     	    public void removeHMVUntergruppe(IHMVUntergruppe x) {
     	        this.HMVUntergruppe.remove((HMVUntergruppe)x);
     	        x.setHMVGruppe(null);
     	    }


}

