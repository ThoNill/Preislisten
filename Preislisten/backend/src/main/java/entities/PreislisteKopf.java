package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import tho.nill.preislisten.simpleAttributes.DatumArt;
import tho.nill.preislisten.simpleAttributes.PreislisteArt;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "PREISLISTEKOPF")
@SequenceGenerator(name = "PREISLISTEKOPF_SEQ", sequenceName = "PREISLISTEKOPF_SEQ")
public class PreislisteKopf  {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "PREISLISTEKOPFID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREISLISTEKOPF_SEQ")
    private java.lang.Long PreislisteKopfId;

         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "ART")
     	    private PreislisteArt art;


     	    public PreislisteArt getArt() {
     	    	return art;
     	    }

     	    public void setArt(PreislisteArt value) {
     	    	art = value;
     	    }
         
        // Kind: (value)


     		@Basic
     	    @Column(name = "TARIFKENNZEICHEN")
     	    private String tarifkennzeichen;


     	    public String getTarifkennzeichen() {
     	    	return tarifkennzeichen;
     	    }

     	    public void setTarifkennzeichen(String value) {
     	    	tarifkennzeichen = value;
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

         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "DART")
     	    private DatumArt dart;


     	    public DatumArt getDart() {
     	    	return dart;
     	    }

     	    public void setDart(DatumArt value) {
     	    	dart = value;
     	    }
         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "PreislisteKopf", 
     	               orphanRemoval = true
     	               )
     	    private Set<PreislisteBezug> PreislisteBezug = new HashSet<>();



     	    public void addPreislisteBezug(PreislisteBezug x) {
     	        this.PreislisteBezug.add(x);
     	        x.setPreislisteKopf(this);
     	    }


     	    public void removePreislisteBezug(PreislisteBezug x) {
     	        this.PreislisteBezug.remove(x);
     	        x.setPreislisteKopf(null);
     	    }


         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "PreislisteKopf", 
     	               orphanRemoval = true
     	               )
     	    private Set<PreislistePosition> PreislistePosition = new HashSet<>();



     	    public void addPreislistePosition(PreislistePosition x) {
     	        this.PreislistePosition.add(x);
     	        x.setPreislisteKopf(this);
     	    }


     	    public void removePreislistePosition(PreislistePosition x) {
     	        this.PreislistePosition.remove(x);
     	        x.setPreislisteKopf(null);
     	    }


}

