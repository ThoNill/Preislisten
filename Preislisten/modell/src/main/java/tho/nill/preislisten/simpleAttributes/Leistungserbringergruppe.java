package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Leistungserbringergruppe */
public enum Leistungserbringergruppe  {
	// Apotheken  
	Apotheken_3("3"),
	/* Sonstige Leistungserbringer */
	Sonstige_5("5");

	private String code;

	private Leistungserbringergruppe(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static Leistungserbringergruppe search(String code) {
		for ( Leistungserbringergruppe o  : Leistungserbringergruppe.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
