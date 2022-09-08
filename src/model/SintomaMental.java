package model;

import java.util.Date;

/**
* Classe SintomaMental simula o comportamento de um sintoma mental e herda de Sintoma.
* @author Mylena e Sabrina.
* @since 2022
* @version 2.0
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
	
	public SintomaMental(char tipo,String n,String d, Date c, Ciclo ci) {
		this.nome = n;
		this.cadastro= c;
		this.tipo=tipo;
		this.descricao=d;
		this.ciclos=ci;
	
		
				
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

	public Date getCadastro() {
		return cadastro;
	}
	public void setCadastro(Date cadastro) {
		this.cadastro= cadastro;
	}

	


	
	}

