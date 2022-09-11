package control;

import model.*;

public class SintomaFisicoControl{
	private SintomaFisico[] f;
	private int qtdFisicos;

	public SintomaFisicoControl(DadosControl d) {
		this.f = d.getSintomasFisicos();
		this.qtdFisicos = d.getQtdFisicos();
	}

	public String[] getNome() {
		String[] s = new String[qtdFisicos];
		for(int i = 0; i < qtdFisicos; i++) {
			s[i] = f[i].getNome();
		}

		return s;
	}
	public int getQtd() {
		return qtdFisicos;
	}

	public void setQtd(int qtd) {
		this.qtdFisicos = qtd;
	}

	public String getNome(int i) {		
		return f[i].getNome();
	}
	
	public String getLocal(int i) {		
		return f[i].getLocal();
	}

	public String getIntensidade(int i) {
		String intensidade = String.valueOf(f[i].getIntensidade());
		return intensidade;
	}

	public String getCadastro(int i) {
		return ("25/09/1998");
	}
	

	public void setQtdFisicos(int qtdFisicos) {
		this.qtdFisicos = qtdFisicos;
	}
	
	
}