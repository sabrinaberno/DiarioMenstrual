package model;

import java.util.ArrayList;
import java.util.List;

/**
* Classe que armazena as arrays das classes cadastradas.
* @author Mylena e Sabrina.
* @since 2022
* @version 1.0
**/

public abstract class Dados {
	private static final ArrayList<Pessoa> pessoas = new ArrayList<>();
	private static final ArrayList<Ciclo> ciclos = new ArrayList<>();
	private static final ArrayList<SintomaMental> mentais = new ArrayList<>();
	private static final ArrayList<SintomaFisico> fisicos = new ArrayList<>();
	
	private Dados() {
	}

	public static List<Pessoa> getPessoas() {
		return pessoas;
	}
	public static List<Ciclo> getCiclos() {
		return ciclos;
	}
	public static List<SintomaMental> getMentais() {
		return mentais;
	}
	public static List<SintomaFisico> getFisicos() {
		return fisicos;
	}

}