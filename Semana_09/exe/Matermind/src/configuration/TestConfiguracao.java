package configuration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestConfiguracao {

	@Test
	void testSteAlfabeto() {
		Configuracao configuracao = new Configuracao();
		String senha = "ABCDEFGHI";
		try {
			configuracao.setAlfabeto(senha);
		}catch(IllegalArgumentException e) {
			fail("Gerou uma exceção invalida");
			e.printStackTrace();
		}
		assertEquals(configuracao.getAlfabeto(), senha);
		
		senha = null;
		
		try {
			configuracao.setAlfabeto(senha);
		}catch(Exception e) {
			assertEquals("Alfabeto não pode ser nulo", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto()==null);
	}

}
