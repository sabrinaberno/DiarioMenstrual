package controller;


import model.*;

public class ControleMentais{
	private SintomaMental[] m;
	private int qtdMentais;
	
	public ControleMentais(ControleDados d) {
		m = d.getMentais();
		qtdMentais = d.getQtdMentais();
		
	}
	
	
	public String[] getNomeMental() {
		String[] s = new String[qtdMentais];
		for(int i = 0; i < qtdMentais; i++) {
			//s[i] = m[i].getNomeMental();
		}
		return s;
	}
	
	public int getQtd() {
		return qtdMentais;
	}

	public void setQtd(int qtd) {
		this.qtdMentais = qtd;
	}
	
	public String getNomeMental(int i) {		
		return m[i].getNomeMental();
	}
		
	public String getCadastro(int i) {
		String cadastro = String.valueOf(m[i].getCadastro());
		return cadastro;
	}
	
	public int getIntensidade(int i) {
		return m[i].getIntensidade();
	}

	
	
	
		
	
	
	
}
