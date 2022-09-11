package control.helper;

import javax.swing.DefaultListModel;

import model.Dados;
import model.SintomaFisico;
import model.SintomaMental;
import vision.CadastrarFisicos;

/**
 * Classe auxiliar que cont�m m�todos �teis para sua respectiva classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarSintomaFisicoHelper {
	CadastrarFisicos view;

	/**
	 * Inicializa view.
	 * 
	 * @param view inst�ncia de CadastrarAtor
	 */
	public CadastrarSintomaFisicoHelper(CadastrarFisicos view) {
		this.view = view;
	}

	/**
	 * Procura nos atores cadastrados e retorna o ator cujo nome seja igual ao
	 * escolhido (null caso n�o exista).
	 * 
	 * @param nome Nome do ator escolhido
	 * 
	 * @return ator escolhido
	 */
	public SintomaFisico  resgatarSintomaFisicoEscolhido(String nome) {
		for (SintomaFisico  sintomaFisicoAtual : Dados.getFisicos()) {
			if (nome.equals(sintomaFisicoAtual.getNome())) {
				return sintomaFisicoAtual;
			}
		}
		return null;
	}

	/**
	 * Gera um Model com o nome de todos os atores cadastrados.
	 * 
	 * @return DefaultListModel
	 */
	public DefaultListModel<String> resgatarSintomaFisicoCadastrados() {
		DefaultListModel<String> nomes = new DefaultListModel<>();

		for (SintomaFisico sintomaFisicoAtual : Dados.getFisicos()) {
			nomes.addElement(sintomaFisicoAtual.getNome());
		}

		return nomes;
	}
}
