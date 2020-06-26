package tho.nill.preislisten.modelle;

import org.nill.vorlagen.compiler.markerClasses.CharBLOB;
import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.verknüpfungen.Verknüpfungen;


public class HMVGruppe extends ObjectModell implements Entity, Aggregate {
	
	public Long   gruppe;
	public CharBLOB bezeichnung;
	public CharBLOB definition;
	public CharBLOB indikation;
	public CharBLOB querverweise;
	
	/*
	 <hv:GRUPPE>1</hv:GRUPPE>
     <hv:ORT>24</hv:ORT>
     <hv:UNTERGRUPPE>1</hv:UNTERGRUPPE>
     <hv:ART>0</hv:ART>
	 */
		
	
	public HMVGruppe() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
