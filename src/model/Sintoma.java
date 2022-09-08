package model;

import java.util.Date;

public abstract class Sintoma {
	protected Date cadastro;
	protected String nome;

	
	/**
	 * Atributos de um sintoma
	 * 
	 * @param numSintomas     contagem do número de sintomas cadastrados
	 * @param nomeMental      nome do tipo de sintoma
	 * @param intensidade     intensidade que foi sentido o sintoma
	 * @param cadastro        data em que foi cadastrado osintoma
	 */	
	
	
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
