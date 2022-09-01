package model;

/**
* Classe Pessoa simula o comportamento de uma pessoa.
* @author Mylena e Sabrina.
* @since 2022
* @version 1.0
**/

public class Pessoa {
	public String nome;
	public String nascimento;
	

	
	public Pessoa(String n, String nc) {
		nome=n;
		nascimento=nc;
		
		
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	

	//Talvez seja melhor na controle
	
	public void editarDados(String nome, String nascimento) {
		this.setNome(nome);
		this.setNascimento(nascimento);		
		
		
	}
}
