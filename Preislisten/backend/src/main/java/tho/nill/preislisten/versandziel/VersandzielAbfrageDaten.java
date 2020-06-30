package tho.nill.preislisten.versandziel;

import lombok.Data;
import tho.nill.preislisten.simpleAttributes.Abrechnungscode;
import tho.nill.preislisten.simpleAttributes.Bundesland;
import tho.nill.preislisten.simpleAttributes.DatenlieferungsArt;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.KVBezirk;
import tho.nill.preislisten.simpleAttributes.Leistungserbringergruppe;
import tho.nill.preislisten.simpleAttributes.Tarifkennzeichen;

@Data
public class VersandzielAbfrageDaten {
	public IK ik;
	public DatenlieferungsArt art;
	public Bundesland land;
	public KVBezirk   bezirk;
	public Abrechnungscode abrechnungscode;
	public Tarifkennzeichen tarifkennzeichen;
	public Leistungserbringergruppe leistungserbringergruppe;

	
	public VersandzielAbfrageDaten(IK ik,DatenlieferungsArt art, Bundesland land, KVBezirk bezirk,
			Abrechnungscode abrechnungscode, Tarifkennzeichen tarifkennzeichen,
			Leistungserbringergruppe leistungserbringergruppe) {
		super();
		this.ik = ik;
		this.art = art;
		this.land = land;
		this.bezirk = bezirk;
		this.abrechnungscode = abrechnungscode;
		this.tarifkennzeichen = tarifkennzeichen;
		this.leistungserbringergruppe = leistungserbringergruppe;
	}
	

}