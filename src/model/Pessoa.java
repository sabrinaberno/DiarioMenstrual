package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que contem os atributos de uma pessoa
 * 
 * @author Mylena e Sabrina.
 */
public class Pessoa {
	private final ArrayList<Ciclo> ciclos;
	private String nome;
	private Date nascimento;
	private String email;
	private String senha;
	

	/**
	 * Gera uma pessoa e ciclos recebe uma ArrayList em branco. ]
	 * 
	 * @param nome                   nome da pessoa
	 * @param nascimento             data de nascimento
	 * @param email                   email
	 * @param senha                  senha
	 */
	public Pessoa(String n,  Date dn, String e, String s) {
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

	

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
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
	public void editarDados(String n,  String s, String e, Date dn) {
		this.setNome(n);	
		this.setSenha(s);
		this.setEmail(e);
		this.setNascimento(dn);
	
	}
}
