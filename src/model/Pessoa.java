package model;

import java.util.Date;

public class Pessoa {

//	private String nome_completo;
//	private Date dt_nascimento;
	private String login;
	private String senha;
	
	public Pessoa(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Pessoa() {
		super();
		this.login = null;
		this.senha = null;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Pessoa [login=" + login + ", senha=" + senha + "]";
	}
}
