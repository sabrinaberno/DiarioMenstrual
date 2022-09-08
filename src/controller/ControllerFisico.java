package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Dados;
import model.SintomaFisico;
import view.TelaDetalheSintoma;


/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class ControllerFisico {

	private TelaDetalheSintoma view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de NovoAtor
	 */
	public ControllerFisico(TelaDetalheSintoma view) {
		this.view = view;
	}


	/**
	 * Resgata as informações da tela, valida essas informações e retorna um objeto
	 * Ator (null caso a validação falhe).
	 * 
	 * @return Ator ou null
	 */
	public SintomaFisico obterModelo() {
		String nome = view.getValorNome().getText();			
		String local = view.getValorLocal().getText();
		String modeloIntensidade = view.getValorIntensidade().getText();
		String modeloCadastro = view.getValorCadastro().getText();
		char tipo = view.getValorTipo().getSelectedItem().toString().charAt(0);
		Date cadastro;
		int intensidade;

		if (nome.isEmpty()) {
			view.getValorNome().setText("");
			return null;
		}
		if (local.isEmpty()) {
			view.getValorLocal().setText("");
			return null;
		}
		
		try {
			intensidade = Integer.parseInt(modeloIntensidade);
		} catch (NumberFormatException e) {
			view.getValorIntensidade().setText("");
			return null;
		}
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			cadastro = formatador.parse(modeloCadastro);
		} catch (ParseException ee) {
			view.getValorCadastro().setText("");
			return null;
		}
		

		return new SintomaFisico(tipo,nome, local, intensidade,cadastro);
	}

	/**
	 * Recebe um Ator e o cadastra em Dados.
	 * 
	 * @param modelo Filme para cadastrar
	 */
	public void setarModelo(SintomaFisico modelo) {
		Dados.getFisicos().add(modelo);
	}
}