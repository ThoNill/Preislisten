package tho.nill.preislisten.modelle;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.simpleAttributes.Mwst;
import tho.nill.preislisten.verknüpfungen.Verknüpfungen;

public class PreislistePosition extends ObjectModell implements Entity, Aggregate {
	
	double preis;
	Mwst  mwst;
		
	
	public PreislistePosition() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
