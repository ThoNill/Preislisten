package tho.nill.preislisten.simpleAttributes;

public class Tarifkennzeichen implements Comparable<Tarifkennzeichen> {
	private String code;

	public Tarifkennzeichen(String code) {
		super();
		this.code = code;
	}

	public Tarifbereich getTarifbereich() {
		if (code != null && code.length() >= 2) {
			return Tarifbereich.search(code.substring(0, 2));
		}
		return null;
	}

	@Override
	public int compareTo(Tarifkennzeichen o) {
		return code.compareTo(o.code);
	}

	@Override
	public String toString() {
		return code;
	}
}
