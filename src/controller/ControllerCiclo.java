package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Ciclo;
import model.Dados;
import view.CadastrarFisico;
import view.TelaCiclo;

 /**
 * 	Classe auxiliar que contém métodos úteis para a classe Ciclo
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 */


public class ControllerCiclo {

	private TelaCiclo view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de CadastrarEstudio
	 */
	public ControllerCiclo(TelaCiclo view) {
		this.view = view;
	}

	/**
	 * Resgata as informações da tela, valida essas informações e retorna um objeto
	 * Estudio (null caso a validação falhe).
	 * 
	 * @return Estudio ou null
	 */
	public Ciclo obterModelo() {
		String numero = view.getNumero().getText();
		String modeloInicio  = view.getDataInicioMenstruacao().getText();
		String modeloFinal = view.getDataFinalMenstruacao().getText();
		String modeloDuracao = view.getDuracao().getText();
		
		Date dtInicio;
		Date dtFinal;
		int duracao;

		if (numero.isEmpty()) {
			view.getNumero().setText("");
			return null;
		}


		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		try {
			dtInicio = formatador.parse(modeloInicio);
		} catch (ParseException ee) {
			view.getDataInicioMenstruacao().setText("");
			return null;
		}
		
		try {
			dtFinal = formatador.parse(modeloFinal);
		} catch (ParseException ee) {
			view.getDataFinalMenstruacao().setText("");
			return null;
		}
		
		try {
			duracao = Integer.parseInt(modeloDuracao);
		} catch (NumberFormatException e) {
			view.getDuracao().setText("");
			return null;
		}

		

		return new Ciclo(dtInicio, dtFinal, duracao,numero);

	}

	/**
	 * Recebe um Estudio e o cadastra em Dados.
	 * 
	 * @param modelo Estudio para cadastrar
	 */
	public void setarModelo(Ciclo modelo) {
		Dados.getCiclos().add(modelo);
	}

	/**
	 * Retorna todos as entradas para o padrão.
	 */
	public void limpaCampo() {
		view.getDataInicioMenstruacao().setText("");
		view.getDataFinalMenstruacao().setText("");
		view.getDuracao().setText("");
		view.getNumero().setText("");
	}
	
	

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso botão cancelar: limpe as entradas e volte ao menu.
	 * 
	 * Caso botao confirmar: crie um modelo de Estudio (null caso contenha
	 * informações erradas), cadastra o estúdio em Dados, limpa as entradas e mostra
	 * o menu.
	 * 
	 * @param botaoSelecionado Um botao da tela
	 */
	public void executarBotao(Object botaoSelecionado) {
		if (botaoSelecionado == view.getButtonCancelar()) {
			limpaCampo();
			
		} else {
			Ciclo modelo = obterModelo();

			if (modelo != null) {
				setarModelo(modelo);
				limpaCampo();
				
			}
		}
	}
}

	