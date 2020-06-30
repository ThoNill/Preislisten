package tho.nill.preislisten.versandziel;

import java.util.function.Function;

import entities.VersandZiel;

public class EnumFilter implements VersandZielFilter {
	private Enum e;
	private String name;
	private Function<VersandZiel,Enum> field;

	public EnumFilter(Enum e, String name,Function<VersandZiel,Enum> field) {
		super();
		this.e = e;
		this.name = name;
		this.field = field;
	}

	@Override
	public int bewertung(VersandZiel ziel) {
		if (e.equals(field.apply(ziel))) {
			return 1;
		}
		return 0;
	}

	@Override
	public void append(StringBuilder builder) {
		builder.append(" and (z." + name + " = " + e.ordinal() + " or z." + name + " is null)  ");

	}

}
