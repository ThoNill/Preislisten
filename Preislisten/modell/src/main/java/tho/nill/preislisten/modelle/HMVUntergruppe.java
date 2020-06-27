package tho.nill.preislisten.modelle;

import org.nill.vorlagen.compiler.markerClasses.CharBLOB;
import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.verknüpfungen.Verknüpfungen;

public class HMVUntergruppe extends ObjectModell implements Entity, Aggregate {
	
	public Long gruppe;
	public Long untergruppe;
	public Long ort;
	public CharBLOB bezeichnung;
	public CharBLOB anforderungen;

		
	
	public HMVUntergruppe() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
