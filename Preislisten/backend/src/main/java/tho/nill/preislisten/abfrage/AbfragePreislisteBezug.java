package tho.nill.preislisten.abfrage;

import lombok.Data;
import tho.nill.preislisten.simpleAttributes.BezugArt;

@Data
public class AbfragePreislisteBezug {
	private long nummer;
	private BezugArt art;

	public AbfragePreislisteBezug(BezugArt art,long nummer) {
		super();
		this.nummer = nummer;
		this.art = art;
	}


}
