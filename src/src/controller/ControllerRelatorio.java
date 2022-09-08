package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Ciclo;
import model.Dados;
import model.SintomaFisico;
import model.SintomaMental;
import view.Menu;
import view.TelaRelatorio;


/**
 * Classe auxiliar que contém métodos úteis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class ControllerRelatorio {
	TelaRelatorio view;
	private Ciclo cicloEscolhido;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de CadastrarFilme
	 */
	public ControllerRelatorio(TelaRelatorio view) {
		this.view = view;
	}

	/**
	 * Pesquisa todos os estudios em Data e os armazena em uma array de String
	 * 
	 * @return Object[] a array com todos os estudios (sempre uma array de string)
	 */
	public Object[] criarArrayCiclos() {
		List<String> modelo = new ArrayList<>();

		modelo.add(null);

		for (Ciclo ciclo : Dados.getCiclos()) {
			modelo.add(ciclo.getNumero());
		}

		return modelo.toArray();
	}

	/**
	 * Gera um texto formatado contendo todos os filmes desse estúdio.
	 * 
	 * O método pesquisa nas arrays na classe Dados e simplesmente adiciona todos os
	 * nomes de filme em um modelo StringBuilder com o metodo append().
	 * 
	 * @return String o texto de relatorio completo
	 */
	public String gerarRelatorio() {
		boolean flag = false;
		StringBuilder modelo = new StringBuilder();

		modelo.append("Ciclos:\n");

		for (Ciclo cicloAtual : Dados.getCiclos()) {
			if (cicloAtual.getNumero().equals(view.getFieldCiclo().getSelectedItem())) {
				flag = true;
				for (SintomaMental mentalAtual : cicloAtual.getMentais()) {
					modelo.append("    -");
					modelo.append(mentalAtual.getNome());
					modelo.append("\n");
				}
				for (SintomaFisico fisicoAtual : cicloAtual.getFisico()) {
					modelo.append("    -");
					modelo.append(fisicoAtual.getNome());
					modelo.append("\n");
				}
			}
		}

		if (!flag) {
			return "Não há sintomas cadastrados nesse estúdio";
		}

		return modelo.toString();
	}
	public void executarBotao(Object botaoFonte) {
		if (botaoFonte == view.getButtonVoltar()) {
			Menu.dispose();
			
		} else {
			cicloEscolhido = resgatarCicloEscolhido(view.getFieldCiclo().getSelectedItem().toString());

			SintomaMental modeloM = obterModelo();
			SintomaFisico modeloF = obterModelo();

			if (modeloF != null) {
				setarModelo(modeloF);
				limpaCampo();
				
			}
			if (modeloM != null) {
				setarModelo(modeloM);
				limpaCampo();
				
			}
		}
	}

	private void limpaCampo() {
		// TODO Auto-generated method stub
		
	}

	private void setarModelo(SintomaFisico modeloF) {
		// TODO Auto-generated method stub
		
	}

	private SintomaMental obterModelo() {
		// TODO Auto-generated method stub
		return null;
	}

	private Ciclo resgatarCicloEscolhido(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Usado para preencher a caixa com os estúdios.
	 * 
	 * @return model para ComboBox
	 * 
	 * @see MainFrameControl
	 */
	public DefaultComboBoxModel<Object> atualizarModelo() {
		return new DefaultComboBoxModel<>(criarArrayCiclos());
	}

	public Ciclo getCicloEscolhido() {
		return cicloEscolhido;
	}
}