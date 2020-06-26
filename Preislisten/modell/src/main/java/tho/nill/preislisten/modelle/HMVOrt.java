package tho.nill.preislisten.modelle;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.verknüpfungen.Verknüpfungen;

public class HMVOrt extends ObjectModell implements Entity, Aggregate {
	
	public Long ort;
	public String bezeichnung;
	
	public HMVOrt() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
