package tho.nill.preislisten;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

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

	@BeforeTestMethod
	public void init() {
		Check.clearDb(versandZielRepository,kasseRepository);
	}


	@Test
	public void test() throws IOException {
		hilfsmittelVerzeichnisImport.performService("src/test/resources/hmv_test.xml");
	}

}
