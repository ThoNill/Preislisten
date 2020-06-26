package tho.nill.preislisten.hilfsmittelverzechnis;
import entities.HMVProdukt;
import janus.reader.annotations.XmlPath;

@XmlPath(path = "hv:HMV_PRODUKT")
public class XmlHMVProdukt  {
	private HMVProdukt entity;
	
	public XmlHMVProdukt() {
		super();
		entity = new HMVProdukt();
	}
	
	@XmlPath(path = "hv:PRODUKT")
	public void setProdukt(String value ) {
		entity.setProdukt(Long.parseLong(value));
	}
	
	@XmlPath(path = "hv:BEZEICHNUNG")
	public void setBezeichnung(String value ) {
		entity.setBezeichnung(value);;
	}
	
	public HMVProdukt getEntity() {
		return entity;
	}
}
