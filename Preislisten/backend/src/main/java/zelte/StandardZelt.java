package zelte;

import tho.nill.grundgestein.zelt.EntityZelt;
import tho.nill.preislisten.simpleAttributes.IK;
import tho.nill.preislisten.simpleAttributes.Tarifkennzeichen;

public class StandardZelt implements EntityZelt {

	public StandardZelt() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	protected IK convertToIK(String value) {
		if ("".contentEquals(value.strip())) {
			return null;
		}
		return new IK(Integer.parseInt(value));
	}
	
	protected Tarifkennzeichen convertToTarifkennzeichen(String value) {
		return new Tarifkennzeichen(value);
	}
}
