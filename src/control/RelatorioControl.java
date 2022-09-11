package control;

import javax.swing.DefaultComboBoxModel;

import appmain.MainFrameControl;

import control.helper.RelatorioHelper;
import vision.Relatorio;


/**
 * Classe auxiliar que cont�m a l�gica por tr�s da classe RelatorioFilmes.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see RelatorioFilmes
 * @see RelatorioFilmesHelper
 */
public class RelatorioControl {

	private Relatorio view;
	private RelatorioHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public RelatorioControl(Relatorio view) {
		this.view = view;
		helper = new RelatorioHelper(view);
	}

	/**
	 * Executa uma a��o de acordo com o bot�o selecionado na view
	 * 
	 * Casos: Caso bot�o cancelar: limpe as entradas e volte ao menu. Caso bot�o
	 * ComboBox Estudio: mostre o relat�rio com esse estudio.
	 * 
	 * @param botaoFonte Um botao da tela
	 */
	public void executarBotao(Object botaoFonte) {
		if (botaoFonte == view.getButtonVoltar()) {
			view.getFieldRelatorio().setText("");
			MainFrameControl.mostrarMenu();
		} else {
			if (view.getFieldPessoa().getSelectedItem() != null) {
				view.getFieldRelatorio().setText(helper.gerarRelatorio());
			}
		}
	}

	/**
	 * Metodo chama o helper para criar a array de estudios e retorna um
	 * DefaultComboBoxModel com essa array.
	 * 
	 * @return DefaultComboBoxModel o model cadastrado para um comboBox
	 */
	public DefaultComboBoxModel<Object> atualizarModelo() {
		return new DefaultComboBoxModel<>(helper.criarArrayPessoas());
	}
}
