package model;



/**
* Classe Sintoma simula o comportamento de um sintoma e é a classe pai.
* @author Mylena e Sabrina.
* @since 2022
* @version 1.0
**/

public abstract class Sintoma {
	protected String cadastro;
	protected String nome;	
	
	
	public Sintoma() {
		super();
	}
	
	

	public  String getCadastro() {
		return cadastro;
	}



	public void setCadastro(String cadastro) {
		this.cadastro = cadastro;
	}

	
	


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}
}


