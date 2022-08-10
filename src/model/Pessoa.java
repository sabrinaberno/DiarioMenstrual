package model;


public class Pessoa {

//	private String nome_completo;
//	private Date dt_nascimento;
	private String login;
	private String senha;
	
	
	public Pessoa() {
		
	}
	
	public Pessoa(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
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
