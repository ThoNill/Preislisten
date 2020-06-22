package tho.nill.preislisten.simpleAttributes;



/* Schlüssel DFÜParameter */
public enum DFÜParameter  {

	/* kein Parameter (DFÜ-Parameter sind im Segment DFU
					 */
	 kein_00("00"), 
	/* Magnetband 6250 bpi */
	 Magnetband_02("02"), 
	/* Magnetbandkassette 3480 */
	 Magnetbandkassette_03("03"), 
	/* Magnetbandkassette 3490 - 18 Spur */
	 Magnetbandkassette_04("04"), 
	/* Magnetbandkassette 3490 - 36 Spur */
	 Magnetbandkassette_05("05"), 
	/* Diskette 3,5" - 720 KB - DOS-Format */
	 Diskette_08("08"), 
	/* Diskette 3,5" - 1,44 MB - DOS-Format */
	 Diskette_09("09"), 
	/* Diskette ," - , MB - DOS-Format */
	 Diskette_10("10"), 
	/* CD-ROM, cm, MB */
	 CD_ROM_14("14");

	private String code;

	private DFÜParameter(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}


	public static DFÜParameter search(String code) {
		for ( DFÜParameter o  : DFÜParameter.values() ) {
			if (code.equals(o.getCode())) {
				return o;
			}
		}
		return null;
	}

}

   
