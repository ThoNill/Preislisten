package tho.nill.preislisten.modelle;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.simpleAttributes.Abrechnungscode;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.Tarifbereich;
import tho.nill.preislisten.verknüpfungen.Verknüpfungen;

public class Kunde extends ObjectModell implements Entity, Aggregate {
	
	public IK ik;
	public Tarifbereich tarifbereich;
	public Abrechnungscode abrechnungscode;
	public String ansprechpartner;
	public String firma;
	public String plz;
	public String ort;
	public String straße;
	public String telefon;
	public String email;
		
	
	public Kunde() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
