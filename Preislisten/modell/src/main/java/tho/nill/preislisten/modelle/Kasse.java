package tho.nill.preislisten.modelle;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KasseArt;
import tho.nill.preislisten.simpleAttributes.KassenFunktion;
import tho.nill.preislisten.verknüpfungen.Verknüpfungen;

public class Kasse extends ObjectModell implements Entity, Aggregate {
	
	public IK ik;
	public KasseArt art;
	public KassenFunktion funktion;
	public String ansprechpartner;
	public String firma;
	public String plz;
	public String ort;
	public String straße;
	public String telefon;
	public String name;
	public String email;
		
	
	public Kasse() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
