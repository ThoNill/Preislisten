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
	

	@XmlPath(path = "hv:GRUPPE")
	public void setGruppe(String value ) {
		entity.setGruppe(Long.parseLong(value));
	}
	
	@XmlPath(path = "hv:ORT")
	public void setOrt(String value ) {
		entity.setOrt(Long.parseLong(value));
	}
	
	@XmlPath(path = "hv:UNTERGRUPPE")
	public void setUntrgruppe(String value ) {
		entity.setUntergruppe(Long.parseLong(value));
	}
	
	
	@XmlPath(path = "hv:ART")
	public void setArt(String value ) {
		entity.setArt(Long.parseLong(value));
	}
	
	
	@XmlPath(path = "hv:BEZEICHNUNG")
	public void setBezeichnung(String value ) {
		entity.setBezeichnung(value);
	}
	
	@XmlPath(path = "hv:BESCHREIBUNG")
	public void setBeschreibung(String value ) {
		entity.setBeschreibung(value);
	}

	@XmlPath(path = "hv:INDIKATION")
	public void setIndikation(String value ) {
		entity.setIndikation(value);
	}

	public HMVArt getEntity() {
		return entity;
	}

	@Override
	public String toString() {
		return "XmlHMVArt [gruppe=" + getGruppe() + ", ort=" + getOrt() + ", untergruppe=" + getUntergruppe() + "]";
	}


	public Long getArt() {
		return entity.getArt();
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
