package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Komprimierungsart */
public enum Komprimierungsart  {
    NN("");

	private String code;

	private Komprimierungsart(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static Komprimierungsart search(String code) {
		for ( Komprimierungsart o  : Komprimierungsart.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
