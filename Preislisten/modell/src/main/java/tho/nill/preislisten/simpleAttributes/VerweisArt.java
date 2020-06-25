package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Kostenträger */
public enum VerweisArt  {

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

	private VerweisArt(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static VerweisArt search(String code) {
		for ( VerweisArt o  : VerweisArt.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
