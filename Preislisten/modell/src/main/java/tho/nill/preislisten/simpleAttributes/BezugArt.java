package tho.nill.preislisten.simpleAttributes;

public enum BezugArt {
	Kassenart, Abrechnungscode, Tarifbereich, KundenID, KassenID;
	
	public static BezugArt search(String code) {
		return valueOf(code);
	}
}
