package tho.nill.preislisten.hilfsmittelverzechnis;
import entities.HMVUntergruppe;
import janus.reader.annotations.XmlPath;

@XmlPath(path = "hv:HMV_UNTERGRUPPE")
public class XmlHMVUntergruppe {
	private HMVUntergruppe entity;
	
	public XmlHMVUntergruppe() {
		super();
		entity = new HMVUntergruppe();
	}

	
	@XmlPath(path = "hv:GRUPPE")
	public void setGruppe(String value ) {
		entity.setGruppe(Long.parseLong(value));
	}
	
	@XmlPath(path = "hv:ORT")
	public void setOrt(String value ) {
		entity.setOrt(Long.parseLong(value));
	}
	
	
	@XmlPath(path = "hv:UNTERGRUPPE")
	public void setUntergruppe(String value ) {
		entity.setUntergruppe(Long.parseLong(value));
	}
	
	
	@XmlPath(path = "hv:BEZEICHNUNG")
	public void setBezeichnung(String value ) {
		entity.setBezeichnung(value);
	}
	
	@XmlPath(path = "hv:ANFORDERUNGEN")
	public void setAnforderungen(String value ) {
		entity.setAnforderungen(value);
	}
	
	public HMVUntergruppe getEntity() {
		return entity;
	}

	@Override
	public String toString() {
		return "XmlHMVUntergruppe [gruppe=" + getGruppe() + ", ort=" + getOrt() + "]";
	}


	public Long getGruppe() {
		return entity.getGruppe();
	}


	public Long getUntergruppe() {
		return entity.getUntergruppe();
	}


	public Long getOrt() {
		return entity.getOrt();
	}
}
