package tho.nill.preislisten.simpleAttributes;



/* Schlüssel DFÜProtokoll */
public enum DFÜProtokoll  {

	/* FTAM TCP/IP Internet */
	 FTAM_016("016"), 
	/* E-Mail/Internet */
	 EMail_Internet_070("070");

	private String code;

	private DFÜProtokoll(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static DFÜProtokoll search(String code) {
		for ( DFÜProtokoll o  : DFÜProtokoll.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
