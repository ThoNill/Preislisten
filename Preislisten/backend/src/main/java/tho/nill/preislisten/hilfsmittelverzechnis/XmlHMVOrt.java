package tho.nill.preislisten.hilfsmittelverzechnis;
import entities.HMVOrt;
import janus.reader.annotations.XmlPath;

@XmlPath(path = "hv:HMV_ORT")
public class XmlHMVOrt {
	private HMVOrt entity;
	
	public XmlHMVOrt() {
		super();
		entity = new HMVOrt();
	}
	
	@XmlPath(path = "hv:ORT")
	public void setOrt(String value ) {
		entity.setOrt(Long.parseLong(value));
	}
	
	@XmlPath(path = "hv:BEZEICHNUNG")
	public void setBezeichnung(String value ) {
		entity.setBezeichnung(value);
	}
	
	public HMVOrt getEntity() {
		return entity;
	}
}
