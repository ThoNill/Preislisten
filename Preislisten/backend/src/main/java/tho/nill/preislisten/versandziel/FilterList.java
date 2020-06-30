package tho.nill.preislisten.versandziel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entities.VersandZiel;

public class FilterList implements VersandZielFilter {
	private List<VersandZielFilter> filter = new ArrayList<>();

	public FilterList() {
		super();
	}

	public void add(VersandZielFilter filter) {
		this.filter.add(filter);
	}

	@Override
	public int bewertung(VersandZiel ziel) {
		int bewertung = 0;
		for (VersandZielFilter f : filter) {
			bewertung += f.bewertung(ziel);
		}
		return bewertung;
	}

	@Override
	public void append(StringBuilder builder) {
		for (VersandZielFilter f : filter) {
			f.append(builder);
		}
	}

	public Optional<VersandZiel> bestesZiel(Iterable<VersandZiel> ziele) {
		VersandZiel ziel = null;
		int bisherigeBewertung = -1;
		int bewertung;
		for (VersandZiel z : ziele) {
			bewertung = bewertung(z);
			if (bewertung > bisherigeBewertung) {
				ziel = z;
			}
		}
		return (ziel == null) ? Optional.empty() : Optional.of(ziel);
	}

}
