package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import control.*;
/**
 * Classe para teste de validação de usuário
 * 
 * @author Mylena e Sabrina
 */

public class ValidarUsuario {
    CadastrarPessoaControl coUser = new CadastrarPessoaControl();
	

	/**
	 * Testa a validação do nome.
	 * 
	 * modica as variáveis de teste com base no que o usuário pode colocar como entrada.
	 */

	@Test
	void testValidarNome() {
		assertTrue(coUser.validarNome("JUNIA"));
		assertFalse(coUser.validarNome("Junia"));
		assertFalse(coUser.validarNome("Juni4"));
	}
	

	/**
	 * Testa a validação do email.
	 * 
	 * modica as variáveis de teste com base no que o usuário pode colocar como entrada.
	 */
	
	@Test
	void testValidarEmail() {
		assertFalse(coUser.validarEmail("JUNIA"));
		assertTrue(coUser.validarEmail("JUNIA@"));
		assertTrue(coUser.validarEmail("junia@"));
		assertFalse(coUser.validarEmail("junia"));
	}
		

	/**
	 * Testa a validação da senha.
	 * 
	 * modica as variáveis de teste com base no que o usuário pode colocar como entrada.
	 */


	@Test
	void testValidarSenha() {
		assertFalse(coUser.validarSenha("JUN1234"));
		assertFalse(coUser.validarSenha("1234567"));
		assertFalse(coUser.validarSenha("jun1234"));
		assertTrue(coUser.validarSenha("JUNA12"));
		
	}
}
