package tho.nill.preislisten.simpleAttributes;



/* Schlüssel DFÜMedium */
public enum DFÜMedium  {

	/* DFÜ */
	 DFÜ_1("1"), 
	/* Magnetband */
	 Magnetband_2("2"), 
	/* Magnetbandkassette */
	 Magnetbandkassette_3("3"), 
	/* Diskette */
	 Diskette_4("4"), 
	/* Maschinenlesbarer Beleg */
	 Maschinenlesbarer_5("5"), 
	/* Nicht maschinenlesbarer Beleg */
	 Nicht_6("6"), 
	/* CD-ROM */
	 CD_ROM_7("7"), 
	/* Alle Datenträger (Schlüssel bis und ) */
	 Alle_9("9");

	private String code;

	private DFÜMedium(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static DFÜMedium search(String code) {
		for ( DFÜMedium o  : DFÜMedium.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
