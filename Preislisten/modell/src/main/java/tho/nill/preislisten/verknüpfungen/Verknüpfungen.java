package tho.nill.preislisten.verknüpfungen;

import org.nill.vorlagen.compiler.model.ObjectModell;
import org.nill.vorlagen.compiler.util.Connection;

import tho.nill.preislisten.modelle.HMVArt;
import tho.nill.preislisten.modelle.HMVGruppe;
import tho.nill.preislisten.modelle.HMVOrt;
import tho.nill.preislisten.modelle.HMVProdukt;
import tho.nill.preislisten.modelle.HMVUntergruppe;
import tho.nill.preislisten.modelle.Kasse;
import tho.nill.preislisten.modelle.Position;
import tho.nill.preislisten.modelle.PreislisteBezug;
import tho.nill.preislisten.modelle.PreislisteKopf;
import tho.nill.preislisten.modelle.PreislistePosition;
import tho.nill.preislisten.modelle.VersandZiel;

public class Verknüpfungen extends ObjectModell {

	public Connection _hmv_untergruppe = new Connection("one2many",HMVGruppe.class,HMVUntergruppe.class);
	public Connection _hmv_ort = new Connection("one2many",HMVOrt.class,HMVUntergruppe.class);
	public Connection _hmv_art = new Connection("one2many",HMVUntergruppe.class,HMVArt.class);
	public Connection _hmv_produkt = new Connection("one2many",HMVArt.class,HMVProdukt.class);

	
	
	public Connection _bezug = new Connection("one2many",PreislisteKopf.class,PreislisteBezug.class);
	public Connection _preisliste = new Connection("one2many",PreislisteKopf.class,PreislistePosition.class);

	public Connection _position = new Connection("one2many",Position.class,PreislistePosition.class);
	public Connection _ziel = new Connection("one2many",Kasse.class,VersandZiel.class);

	public Verknüpfungen() {
		super();
	}
	
}
