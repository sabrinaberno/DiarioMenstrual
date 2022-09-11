package control.helper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import model.Dados;
import model.SintomaFisico;
import model.SintomaMental;
import vision.CadastrarFisicos;
import vision.CadastrarNovoSintomaFisico;

/**
 * Classe auxiliar que cont�m m�todos �teis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class NovoSintomaFisicoHelper {

	private CadastrarNovoSintomaFisico view;

	/**
	 * Inicializa view.
	 * 
	 * @param view inst�ncia de NovoAtor
	 */
	public NovoSintomaFisicoHelper(CadastrarNovoSintomaFisico view) {
		this.view = view;
	}

	/**
	 * Retorna todos as entradas para o padr�o.
	 */
	public void limpaCampo() {
		view.getFieldLData().setText("");
		view.getFieldLocal().setText("");
		view.getFieldNome().setText("");
		view.getFieldIntensidade().setText("");

	}

	/**
	 * Resgata as informa��es da tela, valida essas informa��es e retorna um objeto
	 * Ator (null caso a valida��o falhe).
	 * 
	 * @return Ator ou null
	 */
	public SintomaFisico obterModelo() {
		String nome = view.getFieldNome().getText();
		String modeloIntensidade = view.getFieldIntensidade().getText();
		String local = view.getFieldIntensidade().getText();
		String modeloData=view.getFieldLData().getText();
		
		
		int intensidade;
		Date data;
	
		if (nome.isEmpty()) {
			view.getFieldNome().setText("");
			return null;
		}
		if (local.isEmpty()) {
			view.getFieldLocal().setText("");
			return null;
		}
		
		try {
			intensidade = Integer.parseInt(modeloIntensidade);
		} catch (NumberFormatException e) {
			view.getFieldIntensidade().setText("");
			return null;
		}
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		try {
			data = formatador.parse(modeloData);
		} catch (ParseException ee) {
			view.getFieldLData().setText("");
			return null;
		}

	
		return new SintomaFisico (nome,local, intensidade, data);
	}

	/**
	 * Recebe um Ator e o cadastra em Dados.
	 * 
	 * @param modelo Filme para cadastrar
	 */
	public void setarModelo(SintomaFisico  modelo) {
		Dados.getFisicos().add(modelo);
	}
}
