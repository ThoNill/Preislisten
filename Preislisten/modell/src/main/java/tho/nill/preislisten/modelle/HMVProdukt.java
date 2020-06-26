package tho.nill.preislisten.modelle;

import java.time.LocalDate;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.verknüpfungen.Verknüpfungen;


public class HMVProdukt extends ObjectModell implements Entity, Aggregate {

	public Long produkt;
	public String hilfsmittelnr;
	public String bezeichnung;
	public String hersteller;
	public String merkmale;
	public LocalDate änderung;	
	
	public HMVProdukt() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
