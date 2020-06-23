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

    import tho.nill.preislisten.simpleAttributes.PositionsArt;
    import java.lang.String;

    import entities.Position;

    import entities.PreislistePosition;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "POSITION")
@SequenceGenerator(name = "POSITION_SEQ", sequenceName = "POSITION_SEQ")
public class Position  {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic
    @Column(name = "POSITIONID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSITION_SEQ")
    private java.lang.Long PositionId;

         
        // Kind: (enumeration)


     	    @Enumerated
     	    @Column(name = "ART")
     	    private PositionsArt art;


     	    public PositionsArt getArt() {
     	    	return art;
     	    }

     	    public void setArt(PositionsArt value) {
     	    	art = value;
     	    }
         
        // Kind: (value)


     		@Basic
     	    @Column(name = "NUMMER")
     	    private String nummer;


     	    public String getNummer() {
     	    	return nummer;
     	    }

     	    public void setNummer(String value) {
     	    	nummer = value;
     	    }

         
        // Kind: (fromone2many)


     	    @OneToMany(cascade = CascadeType.ALL, 
     	               mappedBy = "Position", 
     	               orphanRemoval = true
     	               )
     	    private Set<PreislistePosition> PreislistePosition = new HashSet<>();



     	    public void addPreislistePosition(PreislistePosition x) {
     	        this.PreislistePosition.add((PreislistePosition)x);
     	        x.setPosition(this);
     	    }


     	    public void removePreislistePosition(PreislistePosition x) {
     	        this.PreislistePosition.remove((PreislistePosition)x);
     	        x.setPosition(null);
     	    }


}

