package controller;

import java.util.List;

import model.*;


public class ControllerDados {

	
	
	public ControllerDados() {
		
	}
	
	

	public List<SintomaMental> getMentais() {
		return this.getMentais();
	}
	
	
	
	public List<SintomaMental> getFisicos() {
		return this.getFisicos();
	}
	
	
	

	/**
	 * Recebe um Ator e o cadastra em Dados.
	 * 
	 * @param modelo Filme para cadastrar
	 */
	public void setarModelo(SintomaMental modelo) {
		Dados.getMentais().add(modelo);
	}


	
}
