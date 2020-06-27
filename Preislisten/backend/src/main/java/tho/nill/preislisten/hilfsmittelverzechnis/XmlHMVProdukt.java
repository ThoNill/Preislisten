package tho.nill.preislisten.hilfsmittelverzechnis;
import java.time.LocalDate;

import entities.HMVProdukt;
import janus.reader.annotations.XmlPath;

@XmlPath(path = "hv:HMV_PRODUKT")
public class XmlHMVProdukt  {
	private HMVProdukt entity;

	
	public XmlHMVProdukt() {
		super();
		entity = new HMVProdukt();
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
	
	
	@XmlPath(path = "hv:PRODUKT")
	public void setProdukt(String value ) {
		entity.setProdukt(Long.parseLong(value));
	}
	
	@XmlPath(path = "hv:BEZEICHNUNG")
	public void setBezeichnung(String value ) {
		entity.setBezeichnung(value);;
	}
	
	@XmlPath(path = "hv:HERSTELLER")
	public void setHersteller(String value ) {
		entity.setHersteller(value);;
	}
	
	@XmlPath(path = "hv:MERKMALE")
	public void setMerkmale(String value ) {
		entity.setMerkmale(value);;
	}
	
	@XmlPath(path = "hv:AENDERUNGSDATUM")
	public void setÄnderung(String value ) {
		entity.setÄnderung(LocalDate.parse(value));
	}
	
	public HMVProdukt getEntity() {
		return entity;
	}

	@Override
	public String toString() {
		return "XmlHMVProdukt [gruppe=" + getGruppe() + ", ort=" + getOrt() + ", untergruppe=" + getUntergruppe() + ", art=" + getArt()
				+ "]";
	}


	public Long getProdukt() {
		return entity.getProdukt();
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
