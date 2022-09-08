package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Dados;
import model.SintomaFisico;
import model.SintomaMental;
import view.TelaDetalheSintoma;


/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class ControllerMental {

	private TelaDetalheSintoma view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de NovoAtor
	 */
	public ControllerMental(TelaDetalheSintoma view) {
		this.view = view;
	}


	/**
	 * Resgata as informações da tela, valida essas informações e retorna um objeto
	 * Ator (null caso a validação falhe).
	 * 
	 * @return Ator ou null
	 */
	public SintomaMental obterModelo() {
		String nome = view.getValorNome().getText();			
		String descricao = view.getValorDescricao().getText();
		String modeloCadastro = view.getValorCadastro().getText();
		char tipo = view.getValorTipo().getSelectedItem().toString().charAt(0);
		Date cadastro;
		

		if (nome.isEmpty()) {
			view.getValorNome().setText("");
			return null;
		}
		if (descricao.isEmpty()) {
			view.getValorDescricao().setText("");
			return null;
		}	
		
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			cadastro = formatador.parse(modeloCadastro);
		} catch (ParseException ee) {
			view.getValorCadastro().setText("");
			return null;
		}
		

		return new SintomaMental(tipo,nome, descricao,cadastro);
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