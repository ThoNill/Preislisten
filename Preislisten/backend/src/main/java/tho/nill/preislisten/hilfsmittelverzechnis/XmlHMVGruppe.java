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
		System.out.println("Bezeichnung= "+value);
		entity.setBezeichnung(value);
	}

	@XmlPath(path = "hv:DEFINITION")
	public void setDefinition(String value ) {
		entity.setDefinition(value);
	}

	@XmlPath(path = "hv:INDIKATION")
	public void setIndikation(String value ) {
		entity.setIndikation(value);
	}


	@XmlPath(path = "hv:QUERVERWEISE")
	public void setQuerverweise(String value ) {
		entity.setQuerverweise(value);
	}

	
	public HMVGruppe getEntity() {
		return entity;
	}
}
