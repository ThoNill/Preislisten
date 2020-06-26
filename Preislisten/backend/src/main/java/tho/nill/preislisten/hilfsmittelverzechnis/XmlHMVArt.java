package tho.nill.preislisten.hilfsmittelverzechnis;
import entities.HMVArt;
import janus.reader.annotations.XmlPath;

@XmlPath(path = "hv:HMV_ART")
public class XmlHMVArt {
	private HMVArt entity;
	
	public XmlHMVArt() {
		super();
		entity = new HMVArt();
	}
	
	@XmlPath(path = "hv:ART")
	public void setArt(String value ) {
		entity.setArt(value);
	}
	
	
	@XmlPath(path = "hv:BEZEICHNUNG")
	public void setBezeichnung(String value ) {
		entity.setBezeichnung(value);
	}
	
	@XmlPath(path = "hv:BESCHREIBUNG")
	public void setBeschreibung(String value ) {
		entity.setBeschreibung(value);
	}

	public HMVArt getEntity() {
		return entity;
	}
}
