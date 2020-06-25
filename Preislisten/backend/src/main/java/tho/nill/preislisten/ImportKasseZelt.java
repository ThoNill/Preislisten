package tho.nill.preislisten;

import java.time.LocalDate;

import repositories.KasseRepository;
import zelte.KasseZelt;

public class ImportKasseZelt extends KasseZelt {

	public ImportKasseZelt(KasseRepository repo) {
		super(repo);
	}

	public LocalDate convertToLocalDate(String value) {
		if (value.length() == 8) {
			return LocalDate.parse(value.substring(0, 4) + "-" + value.substring(4, 6) + "-" + value.substring(6, 8));
		} else {
			return null;
		}
	}
}
