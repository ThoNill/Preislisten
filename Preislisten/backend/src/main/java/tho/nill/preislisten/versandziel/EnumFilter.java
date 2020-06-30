package tho.nill.preislisten.versandziel;

import java.util.function.Function;

import entities.VersandZiel;

public class EnumFilter implements VersandZielFilter {
	private Enum e;
	private Enum standard;
	private String name;
	private Function<VersandZiel,Enum> field;

	
	public EnumFilter(Enum e,String name,Function<VersandZiel,Enum> field) {
		this(e,null,name,field);
	}

	
	public EnumFilter(Enum e, Enum standard,String name,Function<VersandZiel,Enum> field) {
		super();
		this.e = e;
		this.name = name;
		this.field = field;
		this.standard = standard;
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
		builder.append(" and (z." + name + " = " + e.ordinal() + standardDazu() + " or z." + name + " is null)  ");

	}

	private String standardDazu() {
		return (standard==null) ? "" : " or z." + name + " = " + standard.ordinal();
	}

}
