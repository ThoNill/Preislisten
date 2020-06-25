package tho.nill.preislisten.abfrage;

import java.util.Iterator;

public abstract class AddOrList<D> {

	public AddOrList() {
		super();
	}

	public void addPositionBezüge(StringBuilder builder, String alias, Iterable<D> bezüge) {
		Iterator<D> iter = bezüge.iterator();
		if (iter.hasNext()) {
			builder.append(" and ( ");
			schleife(builder, alias, iter);
			builder.append(" ) ");
		}
	}

	private int schleife(StringBuilder builder, String alias, Iterator<D> iter) {
		int count = 0;
		while (iter.hasNext()) {
			D bezug = iter.next();
			orDazu(builder, count);
			count++;
			addPosition(builder, alias, bezug);
		}
		return count;
	}

	private void orDazu(StringBuilder builder, int count) {
		builder.append(" ");
		if (count > 0) {
			builder.append(" or ");
		}
		builder.append(" ");
	}

	protected abstract void addPosition(StringBuilder builder, String alias, D bezug);

}
