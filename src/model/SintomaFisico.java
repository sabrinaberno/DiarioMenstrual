package model;

import java.util.Date;

/**
* Classe SintomaFisico simula o comportamento de um sintoma físico e herda de Sintoma.
* @author Mylena e Sabrina.
* @since 2022
* @version 2.0
**/

public class SintomaFisico extends Sintoma {
	
	public int intensidade;
	public String local;
	
	/**
	 * Gera um sintoma físico.
	 * 
	 * @param nomeFisico      nome do tipo de sintoma
	 * @param local           local que sentiu o sintoma
	 * @param intensidade     intensidade que foi sentido o sintoma
	 * @param cadastro        data em que foi cadastrado
	 
	 */	
	
	public SintomaFisico(String n, String l,int i, Date c) {
		this.nome = n;
		this.local= l;
		this.intensidade=i;
		this.cadastro= c;
		
		
		
				
	}
	@Override
		public String toString() {
		return "Nome do sintoma físico: " + nome + ",local:" + local;
	}


	
	public  String getLocal() {
		return local;
	}
	public  void setLocal(String local) {
		this.local = local;
	}
	public int getIntensidade() {
		return intensidade;
	}
	public void setIntensidade(int intensidade) {
		this.intensidade = intensidade;
	}

	
}



