package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import controller.*;


public class ValidarUsuario {
    ControlePessoa coUser = new ControlePessoa();
	
	@Test
	void testValidarNome() {
		assertTrue(coUser.validarNome("JUNIA"));
		assertFalse(coUser.validarNome("Junia"));
		assertFalse(coUser.validarNome("Juni4"));
	}
	
	@Test
	void testValidarEmail() {
		assertFalse(coUser.validarEmail("JUNIA"));
		assertTrue(coUser.validarEmail("JUNIA@"));
		assertTrue(coUser.validarEmail("junia@"));
		assertFalse(coUser.validarEmail("junia"));
	}
		
	@Test
	void testValidarSenha() {
		assertFalse(coUser.validarSenha("JUN123456"));
		assertFalse(coUser.validarSenha("1234567"));
		assertFalse(coUser.validarSenha("jun1234"));
		assertTrue(coUser.validarSenha("JUN1234"));
	}
}
