package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import interfaces.IHMVArt;
import interfaces.IHMVProdukt;
import interfaces.IHMVUntergruppe;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "HMVART")
@SequenceGenerator(name = "HMVART_SEQ", sequenceName = "HMVART_SEQ")
public class HMVArt implements IHMVArt {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "HMVARTID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HMVART_SEQ")
    private java.lang.Long HMVArtId;

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "ART")
     	    private String art;


     	    public String getArt() {
     	    	return art;
     	    }

     	    public void setArt(String value) {
     	    	art = value;
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

         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "HMVUntergruppe_Id")
     		private HMVUntergruppe HMVUntergruppe;

     	    @Override
     	    public void setHMVUntergruppe(IHMVUntergruppe value) {
     	 	   HMVUntergruppe = (HMVUntergruppe) value;
     	    }


         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "HMVArt", 
     	               orphanRemoval = true
     	               )
     	    private Set<HMVProdukt> HMVProdukt = new HashSet<>();


     	    @Override
     	    public void addHMVProdukt(IHMVProdukt x) {
     	        this.HMVProdukt.add((HMVProdukt)x);
     	        x.setHMVArt(this);
     	    }

     	    @Override
     	    public void removeHMVProdukt(IHMVProdukt x) {
     	        this.HMVProdukt.remove((HMVProdukt)x);
     	        x.setHMVArt(null);
     	    }


}

