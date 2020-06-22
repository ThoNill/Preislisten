package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Kostenträger */
public enum Kostenträger  {

	/* Verweis vom IK der Versichertenkarte zum Kostenträger
					 */
	 VerweisKostenträger_01("01"), 
	/* Verweis auf eine Datenannahmestelle (ohne
						Entschlüsselungsbe-
					 */
	 VerweisDatenannahme_02("02"), 
	/* Verweis auf eine Datenannahmestelle (mit
						Entschlüsselungsbefug-
					 */
	 VerweisPrüfstelle_03("03"), 
	/* Verweis auf eine Papierannahmestelle */
	 VerweisPapierannahme_09("09");

	private String code;

	private Kostenträger(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static Kostenträger search(String code) {
		for ( Kostenträger o  : Kostenträger.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
