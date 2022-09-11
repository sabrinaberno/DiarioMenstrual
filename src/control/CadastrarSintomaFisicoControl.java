package control;

import javax.swing.DefaultListModel;

import appmain.MainFrameControl;

import control.helper.CadastrarSintomaFisicoHelper;
import model.SintomaFisico;
import model.SintomaMental;

import vision.CadastrarFisicos;


/**
 * Classe auxiliar que cont�m toda a l�gica por tr�s da classe CadastraAtor.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see CadastrarAtores
 * @see CadastrarAtorHelper
 */
public class CadastrarSintomaFisicoControl {

	private CadastrarFisicos view;
	private CadastrarSintomaFisicoHelper helper;
	private SintomaFisico  sintomaFisicoEscolhido;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public CadastrarSintomaFisicoControl(CadastrarFisicos view) {
		this.view = view;
		helper = new CadastrarSintomaFisicoHelper(view);
	}

	/**
	 * Executa uma a��o de acordo com o bot�o selecionado na view
	 * 
	 * Casos: Caso bot�o finalizar: Retorna ao menu.
	 * 
	 * Caso botao selecionar: Escolhe o nome selecionado na lista, preenche o campo
	 * atorEscolhido e mostra segue para cadastrar um papel.
	 * 
	 * Caso botao novo ator: segue para cadastrar um novo ator
	 * 
	 * botaoSelecionado
	 * 
	 * @param botaoSelecionado Um botao de sua tela.
	 * 
	 * @see CadastrarPapel
	 * @see CadastrarNovoAtor
	 */
	public void executarBotao(Object botaoSelecionado) {
		if (botaoSelecionado == view.getButtonFinalizar()) {
			MainFrameControl.mostrarMenu();
		} else if (botaoSelecionado == view.getButtonSelecionar()) {
			String nomeEscolhido = view.getFieldSintomas().getSelectedValue();

			
		} else {
			MainFrameControl.mostrarCadastraNovoFisicos();
		}
	}

	/**
	 * Usado para preencher a lista de atores.
	 * 
	 * @return model para JList
	 * 
	 * @see MainFrameControl
	 */
	public DefaultListModel<String> atualizarModeloLista() {
		return helper.resgatarSintomaFisicoCadastrados();
	}

	public SintomaFisico  getSintomaFisicoEscolhido() {
		return sintomaFisicoEscolhido;
	}
}
