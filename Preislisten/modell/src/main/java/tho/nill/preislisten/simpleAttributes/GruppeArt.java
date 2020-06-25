package tho.nill.preislisten.simpleAttributes;

public enum GruppeArt {
 NN;
	
	public static GruppeArt search(String code) {
		return valueOf(code);
	}

}
