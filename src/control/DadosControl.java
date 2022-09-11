package control;

import model.*;

public class DadosControl {
	private Dados1 d = new Dados1();
	
	public DadosControl() {
		d.fillWithSomeData();
	}
	
	public Dados1 getDados() {
		return d;
	}
	public void setDados(Dados1 d) {
		this.d = d;
	}

	public SintomaMental[] getSintomaMentais() {
		return this.d.getSintomaMentais();
	}
	
	public int getQtdMentais() {
		return this.d.getQtdMentais();
	}
	
	public int getQtdFisicos() {
		return this.d.getQtdFisicos();
	}
	
	public SintomaFisico[] getSintomasFisicos() {
		return this.d.getSintomasFisicos();
	}
	


	public boolean inserirEditaSintomasFisicos(String[] dadosFisicos) {
		if(!dadosFisicos[2].matches("[0-9]+") ) {
			return false;
		} else {
				SintomaFisico f = new SintomaFisico(dadosFisicos[1], Integer.parseInt(dadosFisicos[2]), 
						dadosFisicos[3],dadosFisicos[4]);
				d.inserirEditaSintomasFisicos(f, Integer.parseInt(dadosFisicos[0]));
				return true;
		}
	}
	// a posicao 0 do vetor dadosAlunos indica onde os dados devem ser inseridos
	public boolean inserirEditarSintomasMentais(String[] dadosMentais) {		
				SintomaMental m = new SintomaMental(dadosMentais[1], dadosMentais[2], dadosMentais[3]);
				d.inserirEditarSintomasMentais(m, Integer.parseInt(dadosMentais[0]));
				return true;
		}	
	
	
	}

