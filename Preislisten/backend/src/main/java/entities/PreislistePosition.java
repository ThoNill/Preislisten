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
import tho.nill.preislisten.simpleAttributes.Mwst;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "PREISLISTEPOSITION")
@SequenceGenerator(name = "PREISLISTEPOSITION_SEQ", sequenceName = "PREISLISTEPOSITION_SEQ")
public class PreislistePosition  {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "PREISLISTEPOSITIONID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREISLISTEPOSITION_SEQ")
    private java.lang.Long PreislistePositionId;

         
        // Kind: (value)


     		@Basic
     	    @Column(name = "PREIS")
     	    private double preis;


     	    public double getPreis() {
     	    	return preis;
     	    }

     	    public void setPreis(double value) {
     	    	preis = value;
     	    }

         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "MWST")
     	    private Mwst mwst;


     	    public Mwst getMwst() {
     	    	return mwst;
     	    }

     	    public void setMwst(Mwst value) {
     	    	mwst = value;
     	    }
         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "PreislisteKopf_Id")
     		private PreislisteKopf PreislisteKopf;


     	    public void setPreislisteKopf(PreislisteKopf value) {
     	 	   PreislisteKopf = (PreislisteKopf) value;
     	    }


         
        // Kind: (toone2many)

     	  	@ManyToOne(fetch = FetchType.LAZY)
     	    @JoinColumn(name = "Position_Id")
     		private Position Position;


     	    public void setPosition(Position value) {
     	 	   Position = (Position) value;
     	    }


}

