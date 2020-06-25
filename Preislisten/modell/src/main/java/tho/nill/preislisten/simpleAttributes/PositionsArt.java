package tho.nill.preislisten.simpleAttributes;

public enum PositionsArt {
	Hilfsmittel7,Hilfsmittel10, Heilmittel, Medikament;
	

	public static PositionsArt search(String code) {
		return valueOf(code);
	}

}
