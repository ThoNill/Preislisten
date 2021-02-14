package tho.nill.preislisten;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import repositories.HMVArtRepository;
import repositories.HMVGruppeRepository;
import repositories.HMVOrtRepository;
import repositories.HMVProduktRepository;
import repositories.HMVUntergruppeRepository;
import repositories.KasseRepository;
import repositories.VersandZielRepository;


@SpringBootTest
public class HilfsmittelVerzeichnisImportTest {
	
	@Autowired
	HilfsmittelVerzeichnisImport hilfsmittelVerzeichnisImport;
	@Autowired
	public KasseRepository kasseRepository;

	@Autowired
	public VersandZielRepository versandZielRepository;

	@Autowired
	public HMVProduktRepository hmvProduktRepository;

	@Autowired
	public HMVArtRepository hmvArtRepository;

	@Autowired
	public HMVOrtRepository hmvOrtRepository;

	@Autowired
	public HMVUntergruppeRepository hmvUntergruppeRepository;

	@Autowired
	public HMVGruppeRepository hmvGruppeRepository;
	
	
	public void init() {
		Check.clearDb(hmvProduktRepository,hmvArtRepository,hmvUntergruppeRepository,hmvGruppeRepository,hmvOrtRepository,versandZielRepository,kasseRepository);
	}


	@Test
	public void test() throws IOException {
		init();
		hilfsmittelVerzeichnisImport.performService("src/test/resources/hmv_test.xml");
	}

}
