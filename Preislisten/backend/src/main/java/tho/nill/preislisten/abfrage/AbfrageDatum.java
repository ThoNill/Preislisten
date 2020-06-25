package tho.nill.preislisten.abfrage;

import java.time.LocalDate;

import lombok.Data;
import tho.nill.preislisten.simpleAttributes.DatumArt;

@Data
public class AbfrageDatum {
	private LocalDate datum;
	private DatumArt art;
	
	public AbfrageDatum(DatumArt art,LocalDate datum) {
		super();
		this.datum = datum;
		this.art = art;
	}

}
