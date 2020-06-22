package tho.nill.preislisten.simpleAttributes;



/* Schlüssel DatenlieferungsArt */
public enum DatenlieferungsArt  {

	/* Rechnungs- und Abrechnungsdaten SLGA und SLLA digi-
					 */
	 RechnungDaten_07("07"), 
	/* Rechnung (Papier) */
	 RechnungPapier_21("21"), 
	/* maschinenlesbarer Beleg */
	 Beleg_24("24"), 
	/* Verordnung (Papier) */
	 Verordnung_26("26"), 
	/* Kostenvoranschlag (Papier) */
	 Kostenvoranschlag_27("27"), 
	/* Gruppenschlüssel (Einzelschlüssel , 26, 27)
					 */
	 Gruppenschlüssel_28("28"), 
	/* Gruppenschlüssel (Einzelschlüssel) */
	 Gruppenschlüssel_29("29");

	private String code;

	private DatenlieferungsArt(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static DatenlieferungsArt search(String code) {
		for ( DatenlieferungsArt o  : DatenlieferungsArt.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
