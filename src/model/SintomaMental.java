package model;

/**
* Classe SintomaMental simula o comportamento de um sintoma mental e herda de Sintoma.
* @author Mylena e Sabrina.
* @since 2022
* @version 2.0
**/



public class SintomaMental extends Sintoma {
	
	public String nomeMental;
	
	
	
	/**
	 * Gera um sintoma mental.
	 * 
	 * @param nomeMental      nome do tipo de sintoma
	 * @param intensidade     intensidade que foi sentido o sintoma
	 * @param cadastro        data em que foi cadastrado
	 
	 */	
	
	public SintomaMental(String n, int i, String d, int nu) {
		this.nomeMental = n;
		this.intensidade=i;
		this.cadastro=d;
		this.numSintomas= nu;
		
				
	}
	
	@Override
		public String toString() {
		return "Nome do sintoma mental: " + nomeMental ;
	}


	public String getNomeMental() {
		return nomeMental;
	}
	public void setNomeMental(String nomeMental) {
		this.nomeMental = nomeMental;
	}
	
	@Override
	public int getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(int intensidade) {
		this.intensidade = intensidade;
	}

	public String getCadastro() {
		return cadastro;
	}
	public void setCadastro(String cadastro) {
		this.cadastro= cadastro;
	}

	


	
	}

