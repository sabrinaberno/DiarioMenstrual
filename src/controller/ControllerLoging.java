package controller;

import model.Dados;
import model.Pessoa;

/**
 * Equipara se os dados fornecidos est�o nos dados cadastrados de loging
 * @author Maria Abritta e Thyago Moura 
 * @version 1.0 (Abril 2022)
 */



public class ControllerLoging {

	public void loging() {

	}
	
	/**
	 * Verifica se o nome e senha colocados no loging foram cadastrados
	 * @param nome e senha 
	 * @return nada, mas dentro o if ele "retorna" a libera��o do usuario para o Usuario
	 */
	public static Pessoa validarLogin(String login, String senha) {
		for (Pessoa usr : Dados.getPessoas()) {
			if (usr.getNome().equals(login) && usr.getSenha().equals(senha)) {
				return usr;
			}
		}
		return null;

	}
	
	/**
	 * Verifica se o nome colocado no loging foi cadastrado
	 * @param nome 
	 * @return retorna as informa��es do usu�rio encontrado caso ele for encontrado
	 */
	public static Pessoa validarBusca(String login) {
		
		for (Pessoa usr : Dados.getPessoas()) {
			if (usr.getNome().equals(login)) {
				return usr;
			}
		}
		return null;

	}
}
