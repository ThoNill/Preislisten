package tho.nill.preislisten.modelle;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.verknüpfungen.Verknüpfungen;


public class HMVProdukt extends ObjectModell implements Entity, Aggregate {
	
	public String hilfsmittelnr;
	public String produkt;
	public String bezeichnung;
	public String hersteller;
	public String merkmal;
		
	
	public HMVProdukt() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
