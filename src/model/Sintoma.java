package model;

import java.util.Date;

/**
* Classe Sintoma simula o comportamento de um sintoma e é a classe pai.
* @author Mylena e Sabrina.
* @since 2022
* @version 2.0
**/

public abstract class Sintoma {
	protected Date cadastro;
	protected String nome;	
	
	
	public Sintoma() {
		super();
	}
	
	

	public  Date getCadastro() {
		return cadastro;
	}



	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	
	


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}
}
