package model;

/**
* Classe Sintoma simula o comportamento de um sintoma e é a classe pai.
* @author Mylena e Sabrina.
* @since 2022
* @version 2.0
**/

public abstract class Sintoma {
	protected String cadastro;
	protected int intensidade;
	protected int numSintomas = 0;
	
	
	public Sintoma() {
		super();
	}
	
	

	public  String getCadastro() {
		return cadastro;
	}



	public void setCadastro(String cadastro) {
		this.cadastro = cadastro;
	}



	public int getIntensidade() {
		return intensidade;
	}



	public void setIntensidade(int intensidade) {
		this.intensidade = intensidade;
	}



	public int getNumSintomas() {
		return numSintomas;
	}



	public void setNumSintomas(int numSintomas) {
		this.numSintomas = numSintomas;
	}



}
