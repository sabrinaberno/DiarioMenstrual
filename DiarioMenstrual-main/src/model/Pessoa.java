package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que contem os atributos de uma pessoa
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0
 */
public class Pessoa {
	private final ArrayList<Ciclo> ciclos;
	private String nome;
	private String nascimento;
	private String email;
	private String senha;
	

	/**
	 * Gera uma pessoa e ciclos recebe uma ArrayList em branco. ]
	 * 
	 * @param nome                   nome da pessoa
	 * @param nascimento             data de nascimento
	 * @param email                  email
	 * @param senha                  senha
	 */
	public Pessoa(String n,  String dn, String e, String s) {
		this.nome = n;
		this.nascimento = dn;
		this.email=e;
		this.senha=s;
		this.ciclos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	

	public List<Ciclo> getCiclos() {
		return ciclos;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Atualiza os dados existentes para os dados editados
	 * TALVEZ SEJA MELHOR COLOCAR NO CONTROLLER
	 * 
	 */
	public void editarDados(String n,  String s, String e, String dn) {
		this.setNome(n);	
		this.setSenha(s);
		this.setEmail(e);
		this.setNascimento(dn);
	
	}
}
