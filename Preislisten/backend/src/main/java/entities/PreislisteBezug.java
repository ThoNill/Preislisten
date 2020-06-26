package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import tho.nill.preislisten.simpleAttributes.BezugArt;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "PREISLISTEBEZUG")
@SequenceGenerator(name = "PREISLISTEBEZUG_SEQ", sequenceName = "PREISLISTEBEZUG_SEQ")
public class PreislisteBezug  {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "PREISLISTEBEZUGID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREISLISTEBEZUG_SEQ")
    private java.lang.Long PreislisteBezugId;

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "NUMMER")
     	    private long nummer;


     	    public long getNummer() {
     	    	return nummer;
     	    }

     	    public void setNummer(long value) {
     	    	nummer = value;
     	    }

         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "ART")
     	    private BezugArt art;


     	    public BezugArt getArt() {
     	    	return art;
     	    }

     	    public void setArt(BezugArt value) {
     	    	art = value;
     	    }
         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "PreislisteKopf_Id")
     		private PreislisteKopf PreislisteKopf;


     	    public void setPreislisteKopf(PreislisteKopf value) {
     	 	   PreislisteKopf = (PreislisteKopf) value;
     	    }


}

