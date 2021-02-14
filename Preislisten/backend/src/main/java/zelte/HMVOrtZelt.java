package zelte;

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

import org.springframework.beans.factory.annotation.Autowired;
import entities.*;

    import java.lang.Long;


    import entities.HMVOrt;
    import repositories.HMVOrtRepository;
    import java.lang.String;


    import entities.HMVOrt;
    import repositories.HMVOrtRepository;

    import entities.HMVOrt;
    import repositories.HMVOrtRepository;

    import entities.HMVUntergruppe;
    import zelte.HMVUntergruppeZelt;


import zelte.StandardZelt;

public class HMVOrtZelt extends StandardZelt {


	private HMVOrt entity;

	private HMVOrtRepository repo;

	public HMVOrtZelt(HMVOrtRepository repo) {
		super();
		this.repo = repo;
	}


	public void save() {
		if (entity != null ) {
			entity = repo.saveAndFlush(entity);
		}
	}


	public void saveIfNeeded() {
		if (entity != null && entity.getHMVOrtId() == null) {
			entity = repo.saveAndFlush(entity);
		}
	}

	public void load(Long id) {
         entity = repo.getOne(id);
	}	


	public void create() {
		entity = new HMVOrt();
	}


	public HMVOrt getEntity() {
		return entity;
	}

	public void setEntity(HMVOrt entity) {
         this.entity = entity;
	}	


    public java.lang.Long getHMVOrtId() {
			return entity.getHMVOrtId();    
    }

         


     	    public Long getOrt() {
     	         return entity.getOrt(); 
     	    }
     	    public void setOrtWithString(String value) {
     	        	entity.setOrt(convertToLong( value));
     	        }
         


     	    public String getBezeichnung() {
     	         return entity.getBezeichnung(); 
     	    }
     	    public void setBezeichnungWithString(String value) {
     	        	entity.setBezeichnung(convertToString( value));
     	        }
         




     	    public void connectHMVOrt(HMVUntergruppeZelt x) {

     	        if (entity!=null) {
     	        	saveIfNeeded();
     	        	x.saveIfNeeded();

     	        	HMVUntergruppe target = x.getEntity();
     	        	entity.addHMVUntergruppe(target);
     	        	target.setHMVOrt(entity);

     	        	saveIfNeeded();
     	        	x.saveIfNeeded();
     	        };

     	    }


     	    public void disconnectHMVOrt(HMVUntergruppeZelt x) {
     	      if (entity!=null) {
     	        HMVUntergruppe target = x.getEntity();
     	        entity.removeHMVUntergruppe(target);
     	        target.setHMVOrt(null);

     	        saveIfNeeded();
     	        x.saveIfNeeded();
     	      };
     	    }


}


