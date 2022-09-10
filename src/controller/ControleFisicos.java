package controller;

import model.*;

/**
 * Classe que contém toda a lógica por trás da classe  Detalhe Físco.
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 */


public class ControleFisicos{
	private SintomaFisico[] f;
	private int qtdFisicos;
	
	public ControleFisicos(ControleDados d) {
		f = d.getFisicos();
		qtdFisicos = d.getQtdFisicos();
		
	}
	
	public String[] getNomeFisico() {
		String[] s = new String[qtdFisicos];
		for(int i = 0; i < qtdFisicos; i++) {
			s[i] = f[i].getNomeFisico();
		}
		
		return s;
	}
	
	public int getQtd() {
		return qtdFisicos;
	}

	public void setQtd(int qtd) {
		this.qtdFisicos = qtd;
	}
	
	public String getNomeFisico(int i) {		
		return f[i].getNomeFisico();
	}
	
	
	public String getCadastro(int i) {
		String cadastro = String.valueOf(f[i].getCadastro());
		return cadastro;
	}
	
	public int getIntensidade(int i) {
		return f[i].getIntensidade();
	}

	public void setQtdFisicos(int qtdFisicos) {
		this.qtdFisicos = qtdFisicos;
	}
	
	
		
	
	
	
}
