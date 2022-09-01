package model;

/**
* Classe SintomaFisico simula o comportamento de um sintoma físico e herda de Sintoma.
* @author Mylena e Sabrina.
* @since 2022
* @version 2.0
**/

public class SintomaFisico extends Sintoma {
	
	public String nomeFisico;
	public String local;
	
	/**
	 * Gera um sintoma físico.
	 * 
	 * @param nomeFisico      nome do tipo de sintoma
	 * @param local           local que sentiu o sintoma
	 * @param intensidade     intensidade que foi sentido o sintoma
	 * @param cadastro        data em que foi cadastrado
	 
	 */	
	
	public SintomaFisico(String n, String l, int i, String cadastro,int nu) {
		this.nomeFisico = n;
		this.local= l;
		this.intensidade=i;
		this.cadastro= cadastro;
		this.numSintomas=nu;
		
				
	}
	@Override
		public String toString() {
		return "Nome do sintoma físico: " + nomeFisico + ",local:" + local;
	}


	public  String getNomeFisico() {
		return nomeFisico;
	}
	public  void setNomeFisico(String nomeFisico) {
		this.nomeFisico = nomeFisico;
	}
	public  String getLocal() {
		return local;
	}
	public  void setLocal(String local) {
		this.local = local;
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



