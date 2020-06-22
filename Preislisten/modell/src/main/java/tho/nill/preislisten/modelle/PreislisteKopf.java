package tho.nill.preislisten.modelle;

import java.time.LocalDate;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.object.ddd.Aggregate;
import org.nill.vorlagen.object.ddd.Entity;

import tho.nill.preislisten.simpleAttributes.DatumArt;
import tho.nill.preislisten.simpleAttributes.PreislisteArt;
import tho.nill.preislisten.verknüpfungen.Verknüpfungen;


public class PreislisteKopf extends ObjectModell implements Entity, Aggregate {
	
	
	public PreislisteArt art;
	public String tarifkennzeichen;
	public LocalDate gültigAb;
	public DatumArt dart;
		
	
	public PreislisteKopf() throws Exception {
		super();
		addConnection(new Verknüpfungen());
	}

}
