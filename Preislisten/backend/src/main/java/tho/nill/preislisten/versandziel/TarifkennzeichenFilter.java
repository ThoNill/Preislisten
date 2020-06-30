package tho.nill.preislisten.versandziel;

import entities.VersandZiel;
import tho.nill.preislisten.simpleAttributes.Tarifkennzeichen;

public class TarifkennzeichenFilter implements VersandZielFilter {
	private Tarifkennzeichen tz;

	public TarifkennzeichenFilter(Tarifkennzeichen tz) {
		super();
		this.tz = tz;
	}

	@Override
	public int bewertung(VersandZiel ziel) {
		Tarifkennzeichen z = ziel.getTarifkennzeichen();
		if (z != null) {
			if (tz.equals(z)) {
				return 2;
			}
			if (tz.getTarifbereich().equals(z.getTarifbereich())) {
				return 1;
			}
		}

		return 0;
	}

	@Override
	public void append(StringBuilder builder) {
		builder.append(" and (z.tarifkennzeichen = '" + tz.toString()+ "' ");
		if (tz.getTarifbereich() != null) {
			builder.append(" or z.tarifkennzeichen = '" + tz.getTarifbereich().getCode() + "' ");
		}
		builder.append(" or z.tarifkennzeichen = '')  ");

	}

}
