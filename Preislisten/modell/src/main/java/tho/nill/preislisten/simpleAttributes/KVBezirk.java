package tho.nill.preislisten.simpleAttributes;



/* Schlüssel KVBezirk */
public enum KVBezirk  {

	/* Schleswig-Holstein */
	 Schleswig_Holstein_01("01"), 
	/* Hamburg */
	 Hamburg_02("02"), 
	/* Bremen */
	 Bremen_03("03"), 
	/* Niedersachsen */
	 Niedersachsen_17("17"), 
	/* Bezirksstelle Aurich */
	 Bezirksstelle_06("06"), 
	/* Bezirksstelle Braunschweig */
	 Bezirksstelle_07("07"), 
	/* Bezirksstelle Göttingen */
	 Bezirksstelle_08("08"), 
	/* Bezirksstelle Hannover */
	 Bezirksstelle_09("09"), 
	/* Bezirksstelle Hildesheim */
	 Bezirksstelle_10("10"), 
	/* Bezirksstelle Lüneburg */
	 Bezirksstelle_11("11"), 
	/* Bezirksstelle Oldenburg */
	 Bezirksstelle_12("12"), 
	/* Bezirksstelle Osnabrück */
	 Bezirksstelle_13("13"), 
	/* Bezirksstelle Stade */
	 Bezirksstelle_14("14"), 
	/* Bezirksstelle Verden */
	 Bezirksstelle_15("15"), 
	/* Bezirksstelle Wilhelmshaven */
	 Bezirksstelle_16("16"), 
	/* Westfalen-Lippe */
	 Westfalen_Lippe_20("20"), 
	/* Verwaltungsstelle Dortmund */
	 Verwaltungsstelle_18("18"), 
	/* Verwaltungsstelle M ünster */
	 Verwaltungsstelle_19("19"), 
	/* Nordrhein */
	 Nordrhein_38("38"), 
	/* Bezirksstelle Aachen */
	 Bezirksstelle_21("21"), 
	/* Bezirksstelle Düesseldorf */
	 Bezirksstelle_24("24"), 
	/* Bezirksstelle Duisburg */
	 Bezirksstelle_25("25"), 
	/* Bezirksstelle Köln */
	 Bezirksstelle_27("27"), 
	/* Bezirksstelle Linker Niederrhein */
	 Bezirksstelle_28("28"), 
	/* Bezirksstelle Ruhr */
	 Bezirksstelle_31("31"), 
	/* Bezirksstelle Bergisch-Land */
	 Bezirksstelle_37("37"), 
	/* Hessen */
	 Hessen_46("46"), 
	/* Bezirksstelle Darmstadt */
	 Bezirksstelle_39("39"), 
	/* Bezirksstelle Frankfurt */
	 Bezirksstelle_40("40"), 
	/* Bezirksstelle Giessen */
	 Bezirksstelle_41("41"), 
	/* Bezirksstelle Kassel */
	 Bezirksstelle_42("42"), 
	/* Bezirksstelle Limburg */
	 Bezirksstelle_43("43"), 
	/* Bezirksstelle Marburg */
	 Bezirksstelle_44("44"), 
	/* Bezirksstelle Wiesbaden */
	 Bezirksstelle_45("45"), 
	/* Koblenz */
	 Koblenz_47("47"), 
	/* Rheinhessen */
	 Rheinhessen_48("48"), 
	/* Pfalz */
	 Pfalz_49("49"), 
	/* Trier */
	 Trier_50("50"), 
	/* Nordbaden */
	 Nordbaden_55("55"), 
	/* Abrechnungsstelle Karlsruhe */
	 Abrechnungsstelle_52("52"), 
	/* Abrechnungsstelle Mannheim */
	 Abrechnungsstelle_53("53"), 
	/* Abrechnungsstelle Pfortzheim */
	 Abrechnungsstelle_54("54"), 
	/* Abrechnungsstelle Baden-Baden */
	 Abrechnungsstelle_56("56"), 
	/* Südbaden */
	 Südbaden_60("60"), 
	/* Abrechnungsstelle Freiburg */
	 Abrechnungsstelle_57("57"), 
	/* Abrechnungsstelle Konstanz */
	 Abrechnungsstelle_58("58"), 
	/* Abrechnungsstelle Offenburg */
	 Abrechnungsstelle_59("59"), 
	/* Nordwürttemberg */
	 Nordwürttemberg_61("61"), 
	/* Südwürttemberg */
	 Südwürttemberg_62("62"), 
	/* Bayerns */
	 Bayerns_71("71"), 
	/* Bezirksstelle München Stadt u. Land */
	 Bezirksstelle_63("63"), 
	/* Bezirksstelle Oberbayern */
	 Bezirksstelle_64("64"), 
	/* Bezirksstelle Oberfranken */
	 Bezirksstelle_65("65"), 
	/* Bezirksstelle Mittelfranken */
	 Bezirksstelle_66("66"), 
	/* Bezirksstelle Unterfranken */
	 Bezirksstelle_67("67"), 
	/* Bezirksstelle Oberpfalz */
	 Bezirksstelle_68("68"), 
	/* Bezirksstelle Niederbayern */
	 Bezirksstelle_69("69"), 
	/* Bezirksstelle Schwaben */
	 Bezirksstelle_70("70"), 
	/* Berlin */
	 Berlin_72("72"), 
	/* Saarland */
	 Saarland_73("73"), 
	/* Mecklenburg-Vorpommern */
	 Mecklenburg_Vorpommern_78("78"), 
	/* Brandenburg */
	 Brandenburg_83("83"), 
	/* Abrechnungsstelle Potsdam */
	 Abrechnungsstelle_79("79"), 
	/* Abrechnungsstelle Cottbus */
	 Abrechnungsstelle_80("80"), 
	/* Abrechnungsstelle Frankfurt/oder */
	 Abrechnungsstelle_81("81"), 
	/* Sachsen-Anhalt */
	 Sachsen_Anhalt_88("88"), 
	/* Abrechnungsstelle Magdeburg */
	 Abrechnungsstelle_85("85"), 
	/* Abrechnungsstelle Halle */
	 Abrechnungsstelle_86("86"), 
	/* Abrechnungsstelle Dessau */
	 Abrechnungsstelle_87("87"), 
	/* Thüringen */
	 Thüringen_93("93"), 
	/* Abrechnungsstelle Erfurt */
	 Abrechnungsstelle_89("89"), 
	/* Abrechnungsstelle Gera */
	 Abrechnungsstelle_90("90"), 
	/* Abrechnungsstelle Suhl */
	 Abrechnungsstelle_91("91"), 
	/* Sachsen */
	 Sachsen_98("98"), 
	/* Bezirksstelle Chemnitz */
	 Bezirksstelle_94("94"), 
	/* Bezirksstelle Dresden */
	 Bezirksstelle_95("95"), 
	/* Bezirksstelle Leipzig */
	 Bezirksstelle_96("96");

	private String code;

	private KVBezirk(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static KVBezirk search(String code) {
		for ( KVBezirk o  : KVBezirk.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
