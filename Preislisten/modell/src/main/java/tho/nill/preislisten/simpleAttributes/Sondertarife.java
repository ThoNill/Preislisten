package tho.nill.preislisten.simpleAttributes;



/* Schlüssel Sondertarife */
public enum Sondertarife  {

	/*  */
	_000("000"), 
	/* - */
	_091("091"), 
	/* Leistung ohne preisliche Regelung und daher Abrechnung
						nach
					 */
	 LeistungOhnePreisregelung_099("099"), 
	/*  */
	_100("100");

	private String code;

	private Sondertarife(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static Sondertarife search(String code) {
		for ( Sondertarife o  : Sondertarife.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
