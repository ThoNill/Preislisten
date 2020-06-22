package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Neuanmeldung */
public enum Neuanmeldung  {

	/* Neuanmeldung */
	 Neuanmeldung_01("01"), 
	/* Änderung */
	 Änderung_02("02"), 
	/* Stornierung */
	 Stornierung_03("03"), 
	/* Unverändert */
	 Unverändert_04("04");

	private String code;

	private Neuanmeldung(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static Neuanmeldung search(String code) {
		for ( Neuanmeldung o  : Neuanmeldung.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
