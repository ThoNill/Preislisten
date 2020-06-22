package tho.nill.preislisten.simpleAttributes;

import org.nill.vorlagen.compiler.ConverterVerzeichnis;

public class Converters extends  ConverterVerzeichnis{

	public Converters() {
		put(MonatJahr.class, MonatJahrAdapter.class);
		put(IK.class, IKAdapter.class);
		put(Tarifkennzeichen.class, TarifkennzeichenAdapter.class);
	}
}
