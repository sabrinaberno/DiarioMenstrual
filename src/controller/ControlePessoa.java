package controller;

import model.*;

/**
 * Classe que contém toda a lógica por trás da classe CadastrarPessoa.
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 * @see CadastrarPessoa.
 
 */


public class ControlePessoa{
	private Pessoa[] p;
	
	
	public ControlePessoa(ControleDados d) {
		p = d.getPessoas();
		
		
	}
		
	public String getNome(int i) {		
		return p[i].getNome();
	}
	
	public String getNascimento(int i) {
		return p[i].getNascimento();
	}
	
	
	
	
}

