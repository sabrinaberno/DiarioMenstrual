package control;

import appmain.MainFrameControl;
import control.helper.NovoSintomaFisicoHelper;
import model.SintomaFisico;
import model.SintomaMental;
import vision.CadastrarNovoSintomaFisico;

/**
 * Classe auxiliar que cont�m a l�gica por tr�s da classe NovoAtor.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see CadastrarNovoAtor
 * @see NovoAtorHelper
 */
public class NovoSintomaFisicoControl {

	private CadastrarNovoSintomaFisico view;
	private NovoSintomaFisicoHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public NovoSintomaFisicoControl(CadastrarNovoSintomaFisico view) {
		this.view = view;
		helper = new NovoSintomaFisicoHelper(view);
	}

	/**
	 * Executa uma a��o de acordo com o bot�o selecionado na view
	 * 
	 * Casos: Caso bot�o cancelar: limpe as entradas e volte ao menu.
	 * 
	 * Caso botao confirmar: crie um modelo de Ator (null caso contenha informa��es
	 * erradas), cadastra o ator em Dados, limpa as entradas e mostra o menu.
	 * 
	 * @param botaoSelecionado um botao da tela
	 */
	public void executarBotao(Object botaoSelecionado) {
		if (botaoSelecionado == view.getButtonCancelar()) {
			helper.limpaCampo();
			MainFrameControl.mostrarCadastrarFisicos();
		} else {
			SintomaFisico  modelo = helper.obterModelo();

			if (modelo != null) {
				helper.setarModelo(modelo);
				helper.limpaCampo();
				MainFrameControl.mostrarCadastrarFisicos();
			}
		}
	}
}
