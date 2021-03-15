package br.org.ecad.testepratico.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class ArquivoRepositoryTest {

	@Test
	public void testRegistros() {
		ArquivoRepository repository = new ArquivoRepository();
		Assertions.assertEquals(6, repository.find().size());
	}

	
}
