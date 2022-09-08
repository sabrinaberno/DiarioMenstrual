package model;

import java.util.ArrayList;
/**
 * Recebe os dados gerais do usuário, além de editar esses dados.
 * @author Maria Abritta e Thyago Moura 
 * @version 1.0 (Abril 2022)
 */
public class Pessoa {
	private String nome;
	private String senha;
	private String email;
	private static ArrayList<Ciclo> ciclos = new ArrayList<>();

	public Pessoa(String n, String s, String e) {
		nome = n;
		senha = s;
		email=e;
		
	}

	public String getNome() {
		return nome;
	}

	public String setNome(String nome) {
		return this.nome = nome;
	}

	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static ArrayList<Ciclo> getCiclos() {
		return ciclos;
	}



	/**
	 * Atualiza os dados existentes para os dados editados.
	 * @param nome, email, rg, cpf, senha, telefone
	 */
	public void editarDados(String n,  String s, String e) {
		this.setNome(n);	
		this.setSenha(s);
		this.setEmail(e);
	
	}

}