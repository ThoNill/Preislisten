package tho.nill.preislisten;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import entities.Kasse;
import repositories.KasseRepository;
import repositories.VersandZielRepository;
import tho.nill.preislisten.simpleAttributes.IK;


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
		List<Kasse> kl = kasseRepository.findByIk(new IK(661430046));
		assertEquals(1,kl.size());
		Kasse k = kl.get(0);
	/*	
		UNH+00342+KOTR:02:001:KV'
		IDK+661430046+99+DAVASO (vorm. Syntela)'
		VDT+20050101'
		FKT+01'
		NAM+01+DAVASO GmbH (vorm. Syntela)'
		ANS+1+04356+Leipzig+Am Alten Flughafen 1'
		ANS+3+04311+Leipzig'
		ASP+01+0341/25920-0+0341/25920-20++Zentrale'
		UEM+1+00+I8'
		DFU+01+070+++++da302@syntela.de'
		DFU+02+016+++++ftam.syntela.de?:9000'
*/
		assertEquals("DAVASO (vorm. Syntela)",k.getFirma());
		assertEquals("DAVASO GmbH (vorm. Syntela)",k.getName());
		assertEquals("04356",k.getPlz());
		assertEquals("Leipzig",k.getOrt());
		assertEquals("Am Alten Flughafen 1",k.getStraße());
		assertEquals("0341/25920-0",k.getTelefon());
		assertEquals("0341/25920-20",k.getFax());
		assertEquals("Zentrale",k.getArbeitsgebiet());
		assertEquals("da302@syntela.de",k.getKommunikationskanal());
		
	}

	@Test
	public void doppeltEinlesen() throws IOException {
		kostenträgerImportService.performService("src/test/resources/BK05Q220.ke0");
		long anzKassen = kasseRepository.count();
		long anzVersandZiele = versandZielRepository.count();
		kostenträgerImportService.performService("src/test/resources/BK05Q220.ke0");
		List<Kasse> kl = kasseRepository.findByIk(new IK(661430046));
		assertEquals(1,kl.size());
		assertEquals(anzKassen,kasseRepository.count());
		assertEquals(anzVersandZiele,versandZielRepository.count());

	
	}
}
