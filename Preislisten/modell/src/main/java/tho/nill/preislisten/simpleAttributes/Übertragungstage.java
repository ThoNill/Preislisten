package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Übertragungstage */
public enum Übertragungstage  {

	/* Übertragung an allen Tagen */
	 Alle_1("1"), 
	/* Übertragung nur an Werktagen */
	 Werktage_2("2"), 
	/* Übertragung nur an Arbeitstagen */
	 Arbeitstage_3("3");

	private String code;

	private Übertragungstage(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static Übertragungstage search(String code) {
		for ( Übertragungstage o  : Übertragungstage.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
