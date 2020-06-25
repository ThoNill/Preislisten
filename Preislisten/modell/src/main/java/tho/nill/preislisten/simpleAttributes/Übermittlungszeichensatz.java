package tho.nill.preislisten.simpleAttributes;

/* Schlüssel Übermittlungszeichensatz */
public enum Übermittlungszeichensatz {
	NN("");

	private String code;

	private Übermittlungszeichensatz(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public static Übermittlungszeichensatz search(String code) {
		for (Übermittlungszeichensatz o : Übermittlungszeichensatz.values()) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}
