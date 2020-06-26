package tho.nill.preislisten.hilfsmittelverzechnis;
import entities.HMVGruppe;
import janus.reader.annotations.XmlPath;

@XmlPath(path = "hv:HMV_GRUPPE")
public class XmlHMVGruppe {
	private HMVGruppe entity;
	
	public XmlHMVGruppe() {
		super();
		entity = new HMVGruppe();
	}
	
	@XmlPath(path = "hv:GRUPPE")
	public void setGruppe(String value ) {
		entity.setGruppe(Long.parseLong(value));
	}
	
	@XmlPath(path = "hv:BEZEICHNUNG")
	public void setBezeichnung(String value ) {
		entity.setBezeichnung(value);
	}
	
	public HMVGruppe getEntity() {
		return entity;
	}
}
