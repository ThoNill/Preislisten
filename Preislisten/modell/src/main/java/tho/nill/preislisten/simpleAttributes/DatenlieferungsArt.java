package tho.nill.preislisten.simpleAttributes;



/* Schlüssel DatenlieferungsArt */
public enum DatenlieferungsArt  {

	
	// 01 Rechnung digitalisiert RECP und SERA (Sammel-/Einzelrechnungen Archiv, PDF-Rechnungen) 
	RechnungDaten300_01("01"),
	
	// 02 Abrechnungsdaten Verordnungsdaten 
	Verordnungsdaten300_02("02"),
	// 03 Statistik-/Budgetdaten Übergangsregelung 
	Statistik300_03("03"),
	// 04 Leistungspflichtprüfung  
	Leistungspflichtprüfung300_04("04"),
	// 05 RSA-Daten  
	RSADaten300_05("05"),
	// 06 Image-Daten nur TP3
	Images_06("06"),
	/* Rechnungs- und Abrechnungsdaten SLGA und SLLA digi-
	07 alle Daten (01 – 06)  08 – 20 frei  */
	 RechnungDaten302_07("07"), 
	/* Rechnung (Papier) */
	 RechnungPapier_21("21"), 
	 //22 AU-Bescheinigung
	 AU_Bescheinigung_22("22"),
	 // 23 Vordrucke (Papier) Arzneiverordnungsblätter (Muster16) 
	 Vordrucke_23("23"),
	/* maschinenlesbarer Beleg */
	 MachinenlesbarerBeleg_24("24"), 
	/* Verordnung (Papier) */
	 Verordnung_26("26"), 
	/* Kostenvoranschlag (Papier) */
	 Kostenvoranschlag_27("27"), 
	// Gruppenschlüssel  (Einzelschlüssel 21, 26, 27) 
	 Gruppenschlüssel_28("28"), 
	// Gruppenschlüssel  (Einzelschlüssel 24, 26, 27) 
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

   
