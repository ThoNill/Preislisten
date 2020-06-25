package tho.nill.preislisten.abfrage;

import java.util.HashMap;

import lombok.Data;
import tho.nill.preislisten.simpleAttributes.DatumArt;
import tho.nill.preislisten.simpleAttributes.PreislisteArt;

@Data
public class AbfrageDaten {
	private long kundenId;
	private long kassenId;
	private String posnummer;
	private HashMap<DatumArt,AbfrageDatum> abDatumAuswahl;
	private PreislisteArt artDerPreisliste = PreislisteArt.Erwachsene;
	
	public AbfrageDaten(long kundenId, long kassenId, String posnummer) {
		super();
		this.kundenId = kundenId;
		this.kassenId = kassenId;
		this.posnummer = posnummer;
		this.abDatumAuswahl = new HashMap<>();
	}
	
	
	public void add(AbfrageDatum datum) {
		abDatumAuswahl.put(datum.getArt(),datum);
	}

}