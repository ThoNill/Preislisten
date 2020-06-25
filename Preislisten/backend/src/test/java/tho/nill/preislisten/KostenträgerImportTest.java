package tho.nill.preislisten;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import entities.Kasse;
import entities.VersandZiel;
import repositories.KasseRepository;
import repositories.VersandZielRepository;


@SpringBootTest
public class KostenträgerImportTest {
	
	@Autowired
	KostenträgerImportService kostenträgerImportService;

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
		kostenträgerImportService.performService("src/test/resources/BK05Q220.ke0");
		for(Kasse k : kasseRepository.findAll()) {
			System.out.println(k.getIk().toString() + " " + k.getFirma() + " " + k.getOrt());
		}
		for(VersandZiel z : versandZielRepository.findAll()) {
			System.out.println(z.getVon_ik() + " " +z.getNach_ik());
		}
	}

}
