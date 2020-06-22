package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Hausanschrift */
public enum Hausanschrift  {

	/* Hausanschrift */
	 Hausanschrift_1("1"), 
	/* Postfachanschrift */
	 Postfachanschrift_2("2"), 
	/* Großkundenanschrift */
	 Großkundenanschrift_3("3");

	private String code;

	private Hausanschrift(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static Hausanschrift search(String code) {
		for ( Hausanschrift o  : Hausanschrift.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
