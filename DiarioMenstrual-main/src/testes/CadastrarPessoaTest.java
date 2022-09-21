package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.CadastrarPessoaControl;

class CadastrarPessoaTest {
	CadastrarPessoaControl coUser = new CadastrarPessoaControl();

	@Test
	void testGetNome() {
		assertTrue(coUser.validarNome("JUNIA"));
		assertFalse(coUser.validarNome("Sabrina"));
		assertFalse(coUser.validarNome("Myl3ena"));
		assertFalse(coUser.validarNome("jupiter"));
		assertFalse(coUser.validarNome("prima_vera"));
	}

	@Test
	void testGetEmail() {
		assertFalse(coUser.validarEmail("SABRINA"));
		assertTrue(coUser.validarEmail("MYLENA@"));
		assertTrue(coUser.validarEmail("sabrina@"));
		assertFalse(coUser.validarEmail("junia"));
	}

	@Test
	void testGetSenha() {
		assertFalse(coUser.validarSenha("JUN1234"));
		assertFalse(coUser.validarSenha("1234567"));
		assertFalse(coUser.validarSenha("jun1234"));
		assertFalse(coUser.validarSenha("1234JU"));
		assertTrue(coUser.validarSenha("JUNA12"));
	}

}
