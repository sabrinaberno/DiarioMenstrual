package controller;

import model.*;

/**
 * Classe que contém toda a lógica por trás da classe CadastrarCiclo.
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 * @see CadastrarCiclo
 
 */



public class ControleCiclo{
	private Ciclo[] c;
	private int qtdCiclos;
	
	public ControleCiclo(ControleDados d) {
		c = d.getCiclos();
		qtdCiclos = d.getQtdCiclos();
		
	}
	
	public String[] getNumero() {
		String[] s = new String[qtdCiclos];
		for(int i = 1; i < qtdCiclos; i++) {
			s[i] = c[i].getNumero();
		}
		
		return s;  ///depois ve como faz para retornar Ciclo + numer0
	}


	public int getQtdCiclos() {
		return qtdCiclos;
	}

	public void setQtdCiclos(int qtdCiclos) {
		this.qtdCiclos = qtdCiclos;
	}
	
	public Pessoa getPessoa(int i) {		
		return c[i].getPessoa();
	}
	
	public SintomaFisico getSintomaFisico(int i) {
		return c[i].getSintomaFisico();
	}
	public SintomaMental getSintomaMental(int i) {
		return c[i].getSintomaMental();
	}
	
	public String getDataInicioMenstruacao(int i) {
		
			return c[i].getDataInicioMenstruacao();
		}
	public String getDataFinalMenstruacao(int i) {
	
		return c[i].getDataFinalMenstruacao();
	}
	public int getDuracaoCiclo(int i) {
		return c[i].getDuracaoCiclo();
	}
	public String getNumero(int i) {
		return c[i].getNumero();
	}
		

}

