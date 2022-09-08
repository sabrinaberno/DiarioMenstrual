package controller;

import java.util.List;

import model.*;

public class ControllerDados {

	
	
	public ControllerDados() {
		
	}
	
	

	public List<SintomaMental> getMentais() {
		return this.getMentais();
	}
	
	
	
	public List<SintomaMental> getFisicos() {
		return this.getFisicos();
	}
	
	
	

	/**
	 * Recebe um Ator e o cadastra em Dados.
	 * 
	 * @param modelo Filme para cadastrar
	 */
	public void setarModelo(SintomaMental modelo) {
		Dados.getMentais().add(modelo);
	}


	public boolean inserirEditarFisico(String[] dadosFisicos) {			
		if(!dadosFisicos[2].matches("[Fisico]*") || !dadosFisicos[4].matches("[1-31]/[1-12]/[1960-2050]*") || 
				!dadosFisicos[3].matches("[1-10]*") ) {
			return false;
		} else {
				SintomaFisico f = new SintomaFisico(dadosFisicos[1],dadosFisicos[2], 
						dadosFisicos[3],dadosFisicos[4]), dadosFisicos[5]);
				
				return true;
		}
	}
	// a posicao 0 do vetor dadosAlunos indica onde os dados devem ser inseridos
	public boolean inserirEditarAluno(String[] dadosAlunos) {
		if(!dadosAlunos[3].matches("[0-9]+") || !dadosAlunos[4].matches("[0-9]+") || 
				!dadosAlunos[5].matches("[0-9]+") || !dadosAlunos[6].matches("[0-9]+")) {
			return false;
		} else {
				Aluno a = new Aluno(dadosAlunos[1], dadosAlunos[2], Integer.parseInt(dadosAlunos[3]), 
						Integer.parseInt(dadosAlunos[4]), new Telefone(Integer.parseInt(dadosAlunos[5]),
								Integer.parseInt(dadosAlunos[6])));
				d.inserirEditarAluno(a, Integer.parseInt(dadosAlunos[0]));
				return true;
		}
	}
	
	public boolean removerAluno(int i) {
		int qtdMat = d.getQtdMatriculados();
		String alunoRemovido = d.getAlunos()[i].getNome();
		String aux;
		for (int j = 0; j < qtdMat; j++) { 
			aux = d.getMatr()[j].getAluno().getNome();
			if(alunoRemovido.compareTo(aux) == 0) 
				return false; //n�o � poss�vel remover aluno pois ele est� matriculado em um curso
		}
		
		if(i == (d.getQtdAlunos() - 1)) { // O aluno a ser removido est� no final do array
			d.setQtdAlunos(d.getQtdAlunos() - 1);
			d.getAlunos()[d.getQtdAlunos()] = null;
			return true;
		} else { // o aluno a ser removido est� no meio do array
			int cont = 0;
			while(d.getAlunos()[cont].getNome().compareTo(alunoRemovido) != 0) {
				cont++;
			}
			//Rotina swap
			for(int j = cont; j < d.getQtdAlunos() - 1; j++) {
				d.getAlunos()[j] = null;
				d.getAlunos()[j] = d.getAlunos()[j+1];
			}
			d.getAlunos()[d.getQtdAlunos()] = null;
			d.setQtdAlunos(d.getQtdAlunos() - 1);
			return true;
		}
	}
	
	public boolean removerProfessor(int i) {
		int qtdCursos = d.getQtdCursos();
		String profRemovido = d.getProfs()[i].getNome();
		String aux;
		for (int j = 0; j < qtdCursos; j++) {
			aux = d.getCursos()[j].getProf().getNome();
			if(profRemovido.compareTo(aux) == 0) 
				return false;
			//n�o � poss�vel remover professor pois ele � respons�vel por um curso
		}
		if(i == (d.getQtdProfs() - 1)) { // O prof a ser removido est� no final do array
			d.setQtdProfs(d.getQtdProfs() - 1);
			d.getProfs()[d.getQtdProfs()] = null;
			return true;
		} else { // o prof a ser removido est� no meio do array
			int cont = 0;
			while(d.getProfs()[cont].getNome().compareTo(profRemovido) != 0)
				cont++;
			//Rotina swap
			for(int j = cont; j < d.getQtdProfs() - 1; j++) {
				d.getProfs()[j] = null;
				d.getProfs()[j] = d.getProfs()[j+1];
			}
			d.getProfs()[d.getQtdProfs()] = null;
			d.setQtdProfs(d.getQtdProfs() - 1);
			return true;
		}
	}
}
