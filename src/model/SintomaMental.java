package model;



/**
* Classe SintomaMental simula o comportamento de um sintoma mental e herda de Sintoma.
* @author Mylena e Sabrina.
* @since 2022
* @version 1.0
**/



public class SintomaMental extends Sintoma {
	
	public String descricao;
	
	
	
	/**
	 * Gera um sintoma mental.
	 * 
	 * @param nomeMental      nome do tipo de sintoma
	 * @param intensidade     intensidade que foi sentido o sintoma
	 * @param cadastro        data em que foi cadastrado
	 
	 */	
	
	public SintomaMental(String n,String d, String c) {
		this.nome = n;
		this.cadastro= c;		
		this.descricao=d;
		
	
		
				
	}
	
	@Override
		public String toString() {
		return "Nome do sintoma mental: " + nome + ", descrição:"+ descricao;
	}


	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

	


	
	}

