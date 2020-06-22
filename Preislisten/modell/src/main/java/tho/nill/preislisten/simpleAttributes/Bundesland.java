package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Bundesland */
public enum Bundesland  {

	/* Schleswig-Holstein */
	 Schleswig_Holstein_01("01"), 
	/* Hamburg */
	 Hamburg_02("02"), 
	/* Niedersachsen */
	 Niedersachsen_03("03"), 
	/* Bremen */
	 Bremen_04("04"), 
	/* Nordrhein-Westfalen */
	 Nordrhein_Westfalen_05("05"), 
	/* Hessen */
	 Hessen_06("06"), 
	/* Rheinland-Pfalz */
	 Rheinland_Pfalz_07("07"), 
	/* Baden-Württemberg */
	 Baden_Württemberg_08("08"), 
	/* Bayern */
	 Bayern_09("09"), 
	/* Saarland */
	 Saarland_10("10"), 
	/* Berlin */
	 Berlin_11("11"), 
	/* Brandenburg */
	 Brandenburg_12("12"), 
	/* Mecklenburg-Vorpommern */
	 Mecklenburg_Vorpommern_13("13"), 
	/* Sachsen */
	 Sachsen_14("14"), 
	/* Sachsen-Anhalt */
	 Sachsen_Anhalt_15("15"), 
	/* Thüringen */
	 Thüringen_16("16"), 
	/* Alle Bundesländer (bei Datenlieferungen)
					 */
	 Alle_99("99");

	private String code;

	private Bundesland(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static Bundesland search(String code) {
		for ( Bundesland o  : Bundesland.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
