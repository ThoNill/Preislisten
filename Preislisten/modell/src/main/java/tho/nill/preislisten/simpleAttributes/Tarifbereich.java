package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Tarifbereich */
public enum Tarifbereich  {

	/* Bundeseinheitlicher Tarif (gültig für Ost und West)
					 */
	 Bundeseinheitlich_00("00"), 
	/* Baden-Württemberg */
	 Baden_Württemberg_01("01"), 
	/* Bayern */
	 Bayern_02("02"), 
	/* Berlin Ost */
	 Berlin_03("03"), 
	/* Bremen */
	 Bremen_04("04"), 
	/* Hamburg */
	 Hamburg_05("05"), 
	/* Hessen */
	 Hessen_06("06"), 
	/* Niedersachsen */
	 Niedersachsen_07("07"), 
	/* Nordrhein-Westfalen */
	 Nordrhein_Westfalen_08("08"), 
	/* Rheinland-Pfalz */
	 Rheinland_Pfalz_09("09"), 
	/* Saarland */
	 Saarland_10("10"), 
	/* Schleswig-Holstein */
	 Schleswig_Holstein_11("11"), 
	/* Brandenburg */
	 Brandenburg_12("12"), 
	/* Sachsen */
	 Sachsen_13("13"), 
	/* Sachsen-Anhalt */
	 Sachsen_Anhalt_14("14"), 
	/* Mecklenburg-Vorpommern */
	 Mecklenburg_Vorpommern_15("15"), 
	/* Thüringen */
	 Thüringen_16("16"), 
	/* Stuttgart und Karlsruhe */
	 Stuttgart_17("17"), 
	/* Freiburg und Tübingen */
	 Freiburg_18("18"), 
	/* Berlin West */
	 Berlin_19("19"), 
	/* Nordrhein */
	 Nordrhein_20("20"), 
	/* Westfalen-Lippe */
	 Westfalen_Lippe_21("21"), 
	/* Lippe */
	 Lippe_22("22"), 
	/* Berlin (gesamt) */
	 Berlin_23("23"), 
	/* Bundeseinheitlicher Tarif (West) */
	 West_24("24"), 
	/* Bundeseinheitlicher Tarif (Ost) */
	 Ost_25("25"), 
	/* bis 49 noch zu vergeben */
	 NochVergebbar_26("26"), 
	/* Bundesvertrag */
	 Bundesvertrag_50("50"), 
	/* Baden-Württemberg */
	 Baden_Württemberg_51("51"), 
	/* Bayern */
	 Bayern_52("52"), 
	/* Berlin Ost */
	 Berlin_53("53"), 
	/* Bremen */
	 Bremen_54("54"), 
	/* Hamburg */
	 Hamburg_55("55"), 
	/* Hessen */
	 Hessen_56("56"), 
	/* Niedersachsen */
	 Niedersachsen_57("57"), 
	/* Nordrhein-Westfalen */
	 Nordrhein_Westfalen_58("58"), 
	/* Rheinland-Pfalz */
	 Rheinland_Pfalz_59("59"), 
	/* Saarland */
	 Saarland_60("60"), 
	/* Schleswig-Holstein */
	 Schleswig_Holstein_61("61"), 
	/* Brandenburg */
	 Brandenburg_62("62"), 
	/* Sachsen */
	 Sachsen_63("63"), 
	/* Sachsen-Anhalt */
	 Sachsen_Anhalt_64("64"), 
	/* Mecklenburg-Vorpommern */
	 Mecklenburg_Vorpommern_65("65"), 
	/* Thüringen */
	 Thüringen_66("66"), 
	/* Stuttgart und Karlsruhe */
	 Stuttgart_67("67"), 
	/* Freiburg und Tübingen */
	 Freiburg_68("68"), 
	/* Berlin West */
	 Berlin_69("69"), 
	/* Nordrhein */
	 Nordrhein_70("70"), 
	/* Westfalen-Lippe */
	 Westfalen_Lippe_71("71"), 
	/* Lippe */
	 Lippe_72("72"), 
	/* Berlin (gesamt) */
	 Berlin_73("73"), 
	/* Bundeseinheitlicher Tarif (West) */
	 Bundeseinheitlicher_74("74"), 
	/* Bundeseinheitlicher Tarif (Ost) */
	 Bundeseinheitlicher_75("75"), 
	/* bis 89 noch zu vergeben */
	 bis_76("76"), 
	/* sonstiger länderübergreifender Tarif */
	 sonstiger_90("90"), 
	/* Vertrag auf Kassenebene */
	 AufKassenebene_91("91");

	private String code;

	private Tarifbereich(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static Tarifbereich search(String code) {
		for ( Tarifbereich o  : Tarifbereich.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
