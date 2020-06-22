package tho.nill.preislisten.modelle;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.simpleAttributes.PositionsArt;
import tho.nill.preislisten.verknüpfungen.Verknüpfungen;

public class Position extends ObjectModell implements Entity, Aggregate {
	
	public PositionsArt art;
	public String nummer;
	
		
	
	public Position() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
