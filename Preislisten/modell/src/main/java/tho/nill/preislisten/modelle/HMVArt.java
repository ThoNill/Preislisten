package tho.nill.preislisten.modelle;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.verknüpfungen.Verknüpfungen;


public class HMVArt extends ObjectModell implements Entity, Aggregate {
	
	public String art;
	public String bezeichnung;
	public String definition;
	public String indikation;
			
	
	public HMVArt() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
