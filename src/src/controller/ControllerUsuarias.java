package controller;



import java.util.Date;

import model.Ciclo;
import model.Dados;
import model.Pessoa;

/**
 * Equipara se os dados fornecidos estão nos dados cadastrados de usuário
 * @author Maria Abritta e Thyago Moura 
 * @version 1.0 (Abril 2022)
 */



public class ControllerUsuarias {
	/**
	 * Verifica o cadastro inteiro de usuário, se está de acordo com as verificações específicas, não manda mensagem de erro
	 * @param nome, emial, rg, cpf, tel e senha.
	 * @return mensagem de erro se não passar nas verificações.
	 */
	public String verificaCadastro(String nome, String email, String senha) {
		String msgErro = "";
		if (nome.length() == 0 || email.length() == 0 || 			
				 senha.length() == 0) {
			return null;
		}
		if (!validarNome(nome)) {
			msgErro += "Nome invalido\n";
		}
		if (!validarEmail(email)) {
			msgErro += "Email invalido\n";
		}
		
		
		if (!validarSenha(senha)) {
			msgErro += "Senha invalida\n";
		}
		return msgErro;
	}
	
	
	/**
	 * Verifica a respota do nome do usuário. Faz as verificações:
	 * (1) Se a resposta contém apenas letras.
	 * @param nomeInput
	 * @return booleano verdadeiro ou falso.
	 */
	public boolean validarNome(String nomeInput) {
		boolean verificar = true;
		if (!nomeInput.substring(0).matches("[A-Z]*")) {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Verifica a respota do e-mail do usuário. Faz as verificações:
	 * (1) Se a resposta contém o @ do e-mail.
	 * @param emailValid
	 * @return booleano verdadeiro ou falso.
	 */
	public boolean validarEmail(String emailValid) {
		boolean verificar = true;

		if (!emailValid.substring(0).matches("(.*)@(.*)")) {
			verificar = false;
		}
		return verificar;
	}



	/**
	 * Verifica a respota da senha do usuário. Faz as verificações:
	 * (1) Se a resposta contém necessariamente 7 caracteres.
	 * (2) Se a resposta contém 3 letras maiúsculas e 4 números.
	 * @param senhaValid
	 * @return booleano verdadeiro ou falso.
	 */
	public boolean validarSenha(String senhaValid) {
		boolean verificar = true;
		if (senhaValid.length() != 7) {
			verificar = false;
		}
		if (!senhaValid.substring(0, 3).matches("[A-Z]*")) {
			verificar = false;
		}
		if (!senhaValid.substring(3).matches("[0-9]*")) {
			verificar = false;
		}
		return verificar;
	}

	

	/**
	 * Deleta todas as informações dos usuários.
	 * @param usr
	 */
	public void deletarUsuario(Pessoa usr) {
		Dados.getPessoas().remove(usr);
	}
}