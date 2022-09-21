package model;

import java.util.ArrayList;

import java.util.List;

/**
 * Classe que atua como um banco de dados, armazenando as ArraysList..
 * 
 * @author Mylena e Sabrina.
 */
public abstract class Dados {
	private static final ArrayList<Pessoa> pessoas = new ArrayList<>();
	private static final ArrayList<SintomaMental > mentais = new ArrayList<>();
	private static final ArrayList<SintomaFisico > fisicos = new ArrayList<>();
	private static final ArrayList<Ciclo > ciclos = new ArrayList<>();
	
	
	
	private Dados() {
	}

	public static List<Pessoa> getPessoas() {
		return pessoas;
	}

	public static List<SintomaMental > getMentais() {
		return mentais;
	}
	
	public static List<SintomaFisico > getFisicos() {
		return fisicos;
	}
	
	public static List<Ciclo > getCiclos() {
		return ciclos;
	}
	
	
	
}
