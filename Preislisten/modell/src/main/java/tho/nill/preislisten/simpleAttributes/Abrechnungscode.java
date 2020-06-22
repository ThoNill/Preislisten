package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Abrechnungscode */
public enum Abrechnungscode  {

	/* Sammelschlüssel für alle Leistungsarten */
	 Sammelschlüssel_00("00"), 
	/* Sonderschlüssel, gilt für alle in der
						Kostenträgerdatei
						nicht
					 */
	 Sonderschlüssel_99("99"), 
	/* Gruppenschlüssel Hilfsmittellieferant (Schlüssel
						11-19)
					 */
	 Gruppenschlüssel_10("10"), 
	/* Apotheke (mit gesonderter Zulassung nach § 126 SGB V)
					 */
	 Apotheke_11("11"), 
	/* Augenoptiker */
	 Augenoptiker_12("12"), 
	/* Augenarzt */
	 Augenarzt_13("13"), 
	/* Hörgeräteakustiker */
	 Hörgeräteakustiker_14("14"), 
	/* Orthopädiemechaniker, Bandagist, Sanitätshaus
					 */
	 Orthopädiemechaniker_15("15"), 
	/* Orthopädieschuhmacher */
	 Orthopädieschuhmacher_16("16"), 
	/* Orthopäde */
	 Orthopäde_17("17"), 
	/* Sanitätshaus (Bei neuen Verträgen bzw
						Vertragsanpassungen
					 */
	 Sanitätshaus_18("18"), 
	/* Sonstiger Hilfsmittellieferant */
	 Sonstiger_19("19"), 
	/* Gruppenschlüssel Heilmittelerbringer (Schlüssel 21-29)
					 */
	 Gruppenschlüssel_20("20"), 
	/* Masseur / Medizinischer Badebetrieb */
	 Masseur_21("21"), 
	/* Krankengymnast/Physiotherapeut */
	 Krankengymnast_Physiotherapeut_22("22"), 
	/* Logopäde/Atem-, Sprech- und Stimmlehrer / stattl
						Anerkann-
					 */
	 Logopäde_23("23"), 
	/* Sprachheilpädagoge / Dipl. Pädagoge */
	 Sprachheilpädagoge_24("24"), 
	/* Sonstiger Sprachtherapeut */
	 Sonstiger_25("25"), 
	/* Ergotherapeut */
	 Ergotherapeut_26("26"), 
	/* Krankenhaus */
	 Krankenhaus_27("27"), 
	/* Kurbetrieb */
	 Kurbetrieb_28("28"), 
	/* Sonstige therapeutische Heilperson */
	 Sonstige_29("29"), 
	/* Gruppenschlüssel Häusliche Krankenpflege (Schlüssel
						31-34)
					 */
	 Gruppenschlüssel_30("30"), 
	/* freigemeinnützige Anbieter (Sozialstatio)n
					 */
	 freigemeinnützige_31("31"), 
	/* privatgewerbliche Anbieter */
	 privatgewerbliche_32("32"), 
	/* öffentliche Anbieter */
	 öffentliche_33("33"), 
	/* sonstige Pflegedienste */
	 sonstige_34("34"), 
	/* Gruppenschlüssel Krankentransportleistungen (Schlüssel
						41-
					 */
	 Gruppenschlüssel_40("40"), 
	/* Öffentlicher Träger (z.B. Feuerwehr) */
	 Öffentlicher_41("41"), 
	/* Deutsches Rotes Kreuz (DRK) */
	 Deutsches_42("42"), 
	/* Arbeiter-Samariter-Bund (ASB) */
	 Arbeiter_Samariter_Bund_43("43"), 
	/* Johanniter-Unfall-Hilfe (JUH) */
	 Johanniter_Unfall_Hilfe_44("44"), 
	/* Malteser-Hilfsdienst (MHD) */
	 Malteser_Hilfsdienst_45("45"), 
	/* Sonstiger Leistungserbringer von bodengebundenen
						Trans-
					 */
	 Sonstiger_46("46"), 
	/* Leistungserbringer von Flugrettungs- und
						Transportleistungen
					 */
	 Leistungserbringer_47("47"), 
	/* Sonstiger Leistungserbringer von
						Krankentransportleistungen (
					 */
	 Sonstiger_49("49"), 
	/* Hebamme / Entbindungspfleger */
	 Hebamme_50("50"), 
	/* Sonstiger Leistungserbringer von nichtärztlichen
						Dialysesach-
					 */
	 Sonstiger_55("55"), 
	/* Kuratorium für Heimdialyse (KfH) */
	 Kuratorium_56("56"), 
	/* Patienten-Heimversorgung (PHV) */
	 Patienten_Heimversorgung_57("57"), 
	/* Betriebshilfe */
	 Betriebshilfe_60("60"), 
	/* Leistungserbringer von Rehabilitationssport
					 */
	 Leistungserbringer_61("61"), 
	/* Leistungserbringer von Funktionstraining
					 */
	 Leistungserbringer_62("62"), 
	/* Leistungserbringer für ergänzende
						Rehabilitationsmaßnahmen
					 */
	 Leistungserbringer_63("63"), 
	/* Sonstige Leistungserbringer */
	 Sonstige_65("65"), 
	/* Leistungserbringer von Präventions- und
						Gesundheitsförde-
					 */
	 Leistungserbringer_66("66"), 
	/* Ambulantes Rehazentrum */
	 Ambulantes_67("67"), 
	/* Sozialpädiatrische Zentren/Frühförderstellen
					 */
	 Sozialpädiatrische_68("68"), 
	/* Soziotherapeutische Leistungserbringer */
	 Soziotherapeutische_69("69"), 
	/* Podologen */
	 Podologen_71("71"), 
	/* Leistungserbringer von Ernährungstherapie für seltene
						ange-
					 */
	 Leistungserbringer_73("73"), 
	/* Leistungserbringer von Ernährungstherapie für
						Mukoviszidose
					 */
	 Leistungserbringer_74("74"), 
	/* Med. Fußpfleger (gemäß § 10 Abs. 4 bis 6 PodG)
					 */
	 Med_Fußpfleger_72("72"), 
	/* Spezialisierte ambulante Palliativversorgung (SAPV)
					 */
	 Spezialisierte_75("75"), 
	/* Leistungserbringer nach § 132g SGB V */
	 Leistungserbringer_76("76"), 
	/* Kurzzeitpflege, privat gewerblicher Anbieter
					 */
	 Kurzzeitpflege_91("91"), 
	/* Kurzzeitpflege, frei gemeinnütziger Anbieter
						(gemeinnützige
					 */
	 Kurzzeitpflege_92("92"), 
	/* Kurzzeitpflege, öffentlicher Anbieter */
	 Kurzzeitpflege_93("93"), 
	/* Kurzzeitpflege, sonstige Pflegeeinrichtung
					 */
	 Kurzzeitpflege_94("94");

	private String code;

	private Abrechnungscode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static Abrechnungscode search(String code) {
		for ( Abrechnungscode o  : Abrechnungscode.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
