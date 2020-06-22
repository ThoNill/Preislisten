package tho.nill.preislisten.modelle;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.simpleAttributes.BezugArt;
import tho.nill.preislisten.verknüpfungen.Verknüpfungen;

public class PreislisteBezug extends ObjectModell implements Entity, Aggregate {
	
	public long nummer;
	public BezugArt art;
    
		
	
	public PreislisteBezug() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
