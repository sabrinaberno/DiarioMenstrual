package controller;

import model.*;

/**
 * Classe que contém toda a lógica por trás da classe  Dados.
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 * @see Dados
 */


public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.fillWithSomeData();
	}
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}

	public SintomaFisico[] getFisicos() {
		return this.d.getFisicos();
	}
	
	public int getQtdFisicos() {
		return this.d.getQtdFisicos();
	}
	
	public int getQtdMentais() {
		return this.d.getQtdMentais();
	}
	
	public SintomaMental[] getMentais() {
		return this.d.getMentais();
	}
	
	public Pessoa[] getPessoas() {
		return this.d.getPessoas();
	}

	public Ciclo[] getCiclos() {
		return Dados.getCiclos();
	}
	
	public int getQtdCiclos() {
		return this.d.getQtdCiclos();
	}


	public boolean inserirEditarMental(String[] dadosMentais) {
		if(!dadosMentais[3].matches("[0-9]+") || !dadosMentais[4].matches("[0-9]+") || 
				!dadosMentais[5].matches("[0-9]+") || !dadosMentais[6].matches("[0-9]+")) {
			return false;
		} else {
				SintomaMental m = new SintomaMental(dadosMentais[1], Integer.parseInt(dadosMentais[2]), 
						dadosMentais[3], Integer.parseInt(dadosMentais[4])); 
				d.inserirEditarMental(m,Integer.parseInt(dadosMentais[0]));
				return true;
		}
	}
	
	public boolean inserirEditarFisicos(String[] dadosFisicos) {
		if(!dadosFisicos[3].matches("[0-9]+") || !dadosFisicos[4].matches("[0-9]+") || 
				!dadosFisicos[5].matches("[0-9]+") || !dadosFisicos[6].matches("[0-9]+")) {
			return false;
		} else {
				SintomaFisico f = new SintomaFisico(dadosFisicos[1], dadosFisicos[2], Integer.parseInt(dadosFisicos[3]), 
						dadosFisicos[4], Integer.parseInt(dadosFisicos[5]));
				d.inserirEditarFisico(f, Integer.parseInt(dadosFisicos[0]));
				return true;
		}
	}
	public boolean inserirEditarCiclos(String[] dadosCiclos) {
		if(!dadosCiclos[3].matches("[0-9]+") || !dadosCiclos[4].matches("[0-9]+") || 
				!dadosCiclos[5].matches("[0-9]+") || !dadosCiclos[6].matches("[0-9]+")) {
			return false;
		} else {
			Ciclo c = new Ciclo(dadosCiclos[1], dadosCiclos[2], Integer.parseInt(dadosCiclos[3]), 
					dadosCiclos[4], Integer.parseInt(dadosCiclos[5]));
			d.inserirEditarCiclo(c, Integer.parseInt(dadosCiclos[0]));
			return true;
			}
	}
	
	public boolean removerMental(int i) {
		int qtdCiclos = d.getQtdCiclos();
		String mentalRemovido = d.getMentais()[i].getNomeMental();
		String aux;
		for (int j = 0; j < qtdCiclos; j++) { 
			aux = Dados.getCiclos()[j].getSintomaMental().getNomeMental();
			if(mentalRemovido.compareTo(aux) == 0) 
				return false; 
		}
		
		if(i == (d.getQtdMentais() - 1)) { 
			d.setQtdMentais(d.getQtdMentais() - 1);
			d.getMentais()[d.getQtdMentais()] = null;
			return true;
		} else { 
			int cont = 0;
			while(d.getMentais()[cont].getNomeMental().compareTo(mentalRemovido) != 0) {
				cont++;
			}
			
			for(int j = cont; j < d.getQtdMentais() - 1; j++) {
				d.getMentais()[j] = null;
				d.getMentais()[j] = d.getMentais()[j+1];
			}
			d.getMentais()[d.getQtdMentais()] = null;
			d.setQtdMentais(d.getQtdMentais() - 1);
			return true;
		}
	}
	
	public boolean removerFisico(int i) {
		int qtdCiclos = d.getQtdCiclos();
		String fisicoRemovido = d.getFisicos()[i].getNomeFisico();
		String aux;
		for (int j = 0; j < qtdCiclos; j++) {
			aux = Dados.getCiclos()[j].getSintomaFisico().getNomeFisico();
			if(fisicoRemovido.compareTo(aux) == 0) 
				return false;
			
		}
		if(i == (d.getQtdFisicos() - 1)) { 
			d.setQtdFisicos(d.getQtdFisicos() - 1);
			d.getFisicos()[d.getQtdFisicos()] = null;
			return true;
		} else { 
			int cont = 0;
			while(d.getFisicos()[cont].getNomeFisico().compareTo(fisicoRemovido) != 0)
				cont++;
			
			for(int j = cont; j < d.getQtdFisicos() - 1; j++) {
				d.getFisicos()[j] = null;
				d.getFisicos()[j] = d.getFisicos()[j+1];
			}
			d.getFisicos()[d.getQtdFisicos()] = null;
			d.setQtdFisicos(d.getQtdFisicos() - 1);
			return true;
		}
	}

	public boolean removerCiclo(int i) {
		int qtdCiclos = d.getQtdCiclos();
		String cicloRemovido = Dados.getCiclos()[i].getNumero();
		String aux;
		for (int j = 0; j < qtdCiclos; j++) {
			aux = Dados.getCiclos()[j].getNumero();
			if(cicloRemovido.compareTo(aux) == 0) 
				return false;
			
		}
		if(i == (d.getQtdCiclos() - 1)) { 
			d.setQtdCiclos(d.getQtdCiclos() - 1);
			Dados.getCiclos()[d.getQtdCiclos()] = null;
			return true;
		} else { 
			int cont = 0;
			while(Dados.getCiclos()[cont].getNumero().compareTo(cicloRemovido) != 0)
				cont++;
			
			for(int j = cont; j < d.getQtdCiclos() - 1; j++) {
				Dados.getCiclos()[j] = null;
				Dados.getCiclos()[j] = Dados.getCiclos()[j+1];
			}
			Dados.getCiclos()[d.getQtdCiclos()] = null;
			d.setQtdCiclos(d.getQtdCiclos() - 1);
			return true;
		}
	}
	
}
