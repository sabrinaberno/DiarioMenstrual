package control;

import model.*;

public class SintomaMentalControl {
	private SintomaMental[] m;
	private int qtdMentais;

	public SintomaMentalControl(DadosControl d) {
		this.m = d.getSintomaMentais();
		this.qtdMentais = d.getQtdMentais();
	}

	public String[] getNome() {
		String[] s = new String[qtdMentais];
		for(int i = 0; i < qtdMentais; i++) {
			s[i] = m[i].getNome();
		}

		return s;
	}
	public int getQtd() {
		return qtdMentais;
	}

	public void setQtd(int qtd) {
		this.qtdMentais = qtd;
	}

	public String getNome(int i) {		
		return m[i].getNome();
	}

	public String getDescricao(int i) {
		return m[i].getDescricao();
	}

	public String getCadastro(int i) {
		return ("25/09/1998");
	}

	

	public void setQtdMentais(int qtdMentais) {
		this.qtdMentais = qtdMentais;
	}
	

}
