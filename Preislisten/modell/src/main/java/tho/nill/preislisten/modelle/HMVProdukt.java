package tho.nill.preislisten.modelle;

import java.time.LocalDate;

import org.nill.vorlagen.compiler.markerClasses.CharBLOB;
import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.verknüpfungen.Verknüpfungen;


public class HMVProdukt extends ObjectModell implements Entity, Aggregate {

	public Long produkt;
	public Long art;
	public Long gruppe;
	public Long untergruppe;
	public Long ort;
	
	public String hilfsmittelnr;
	public CharBLOB bezeichnung;
	public String hersteller;
	public CharBLOB merkmale;
	public LocalDate änderung;	
	
	public HMVProdukt() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
