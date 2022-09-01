package model;



/**
* Classe que armazena as arrays das classes cadastradas.
* @author Mylena e Sabrina.
* @since 2022
* @version 2.0
**/

public class Dados {
	private static  Pessoa[] pessoas = new Pessoa[50];
	private int qtdPessoas = 1;
	private static Ciclo [] ciclos = new Ciclo[50];
	private int qtdCiclos = 0;
	private SintomaFisico[] fisicos = new SintomaFisico[50];
	private int qtdFisicos = 0;
	private SintomaMental[] mentais = new SintomaMental[50];
	private int qtdMentais = 0;
	
	
	
	public void fillWithSomeData() {
		
		for(int i = 0; i < 5; i++) {
			pessoas[i] = new Pessoa("Nome"+i,"27/09/1999");
			fisicos[i] = new SintomaFisico("Cólica","local",3+5,"25/09/2022",1);
			mentais[i] = new SintomaMental("Sintoma"+i, i, "21/09/2011", i);
			ciclos[i] = new Ciclo(pessoas[i],"31/10/2022","15/11/2022",i, mentais[i], fisicos[i]);
						
		}
		
		qtdFisicos = 5;
		qtdMentais = 4;
		qtdPessoas = 1;
		qtdCiclos = 1;
		
	}
	
	
	
	public final Pessoa[] getPessoas() {
		return pessoas;
	}



	public static final void setPessoas(Pessoa[] pessoas) {
		Dados.pessoas = pessoas;
	}



	public final int getQtdPessoas() {
		return qtdPessoas;
	}

	public final void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	
	public static Ciclo[] getCiclos() {
		return ciclos;
	}
	public void setCiclos(Ciclo[] ciclos) {
		Dados.ciclos = ciclos;
	}
	public void inserirEditarCiclo( Ciclo c, int pos) {
		Dados.ciclos[pos] = c;
		if(pos == qtdCiclos) qtdCiclos++;
	}
	
	public int getQtdCiclos() {
		return qtdCiclos;
	}
	public void setQtdCiclos(int qtdCiclos) {
		this.qtdCiclos = qtdCiclos;
	}
	
		
	public SintomaFisico[] getFisicos() {
		return fisicos;
	}
	
	public void setFisicos(SintomaFisico[] fisicos) {
		this.fisicos = fisicos;
	}
	public void inserirEditarFisico( SintomaFisico f, int pos) {
		this.fisicos[pos] = f;
		if(pos == qtdFisicos) qtdFisicos++;
	}
	
	
	public int getQtdFisicos() {
		return qtdFisicos;
	}
	public void setQtdFisicos(int qtdFisicos) {
		this.qtdFisicos = qtdFisicos;
	}


	public final SintomaMental[] getMentais() {
		return mentais;
	}

	public final void setMentais(SintomaMental[] mentais) {
		this.mentais = mentais;
	}

	public final int getQtdMentais() {
		return qtdMentais;
	}

	public final void setQtdMentais(int qtdMentais) {
		this.qtdMentais = qtdMentais;
	}
	
	public void inserirEditarMental( SintomaMental m, int pos) {
		this.mentais[pos] = m;
		if(pos == qtdMentais) qtdMentais++;
	}
	
	

}

