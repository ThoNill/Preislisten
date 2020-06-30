package tho.nill.preislisten.simpleAttributes;



/* Schlüssel DatenlieferungsArt */
public enum DatenlieferungsArt {
	/*
	 * Rechnungs- und Abrechnungsdaten SLGA und SLLA digi- 07 alle Daten (01 – 06)
	 * 08 – 20 frei
	 */
	RechnungDaten_07("07"),
	// Gruppenschlüssel (Einzelschlüssel 21, 26, 27)
	Gruppenschlüssel_28("28"),
	// Gruppenschlüssel (Einzelschlüssel 24, 26, 27)
	Gruppenschlüssel_29("29"),

	// 01 Rechnung digitalisiert RECP und SERA (Sammel-/Einzelrechnungen Archiv,
	// PDF-Rechnungen)
	RechnungDaten300_01("01", RechnungDaten_07),

	// 02 Abrechnungsdaten Verordnungsdaten
	Verordnungsdaten300_02("02", RechnungDaten_07),
	// 03 Statistik-/Budgetdaten Übergangsregelung
	Statistik300_03("03", RechnungDaten_07),
	// 04 Leistungspflichtprüfung
	Leistungspflichtprüfung300_04("04", RechnungDaten_07),
	// 05 RSA-Daten
	RSADaten300_05("05", RechnungDaten_07),
	// 06 Image-Daten nur TP3
	Images_06("06", RechnungDaten_07),
	/* Rechnung (Papier) */
	RechnungPapier_21("21", Gruppenschlüssel_28),
	// 22 AU-Bescheinigung
	AU_Bescheinigung_22("22"),
	// 23 Vordrucke (Papier) Arzneiverordnungsblätter (Muster16)
	Vordrucke_23("23"),
	/* maschinenlesbarer Beleg */
	MachinenlesbarerBeleg_24("24", Gruppenschlüssel_29),
	/* Verordnung (Papier) */
	Verordnung_26("26", Gruppenschlüssel_28, Gruppenschlüssel_29),
	/* Kostenvoranschlag (Papier) */
	Kostenvoranschlag_27("27", Gruppenschlüssel_28, Gruppenschlüssel_29);

	private String code;
	private DatenlieferungsArt[] suche;

	private DatenlieferungsArt(String code) {
		this.code = code;
		this.suche = null;
	}

	private DatenlieferungsArt(String code, DatenlieferungsArt... suche) {
		this.code = code;
		this.suche = suche;
	}

	public String getCode() {
		return this.code;
	}

	public static DatenlieferungsArt search(String code) {
		for (DatenlieferungsArt o : DatenlieferungsArt.values()) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

	public String getSuche() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		builder.append(ordinal());
		if (suche != null) {
			for (DatenlieferungsArt a : suche) {
				builder.append(",");
				builder.append(a.ordinal());
			}
		}
		builder.append(")");
		return builder.toString();
	}

}
