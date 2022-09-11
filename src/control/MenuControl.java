package control;

import appmain.MainFrameControl;
import control.helper.MenuControlHelper;
import vision.Menu;

/**
 * Classe auxiliar que cont�m a l�gica por tr�s da classe Menu.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see Menu
 * @see MenuControlHelper
 */
public class MenuControl {

	private Menu view;
	private MenuControlHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public MenuControl(Menu view) {
		this.view = view;
		helper = new MenuControlHelper(view);
	}

	/**
	 * Executa uma a��o de acordo com o bot�o selecionado na view
	 * 
	 * Casos: Mostra respectiva tela
	 * 
	 * @param botaoFonte Um botao da tela
	 */
	public void executarBotao(Object botaoFonte) {
		if (botaoFonte == view.getButtonRegistrarPessoa()) {
			MainFrameControl.mostrarCadastrarPessoa();
		} else if (botaoFonte == view.getButtonAdicionarCiclo()) {
			MainFrameControl.mostrarCadastrarCiclo();
		} else if (botaoFonte == view.getButtonAdicionarFisicos()) {
			MainFrameControl.mostrarCadastrarFisicos();
		} else if (botaoFonte == view.getButtonMostrarRelatorio()) {
			MainFrameControl.mostrarRelatorio();
		}
		
		
	}

	/**
	 * Ativa os bot�es que podem ser usados no menu.
	 * 
	 * @see MenuControlHelper
	 */
	public void ativarbotao() {
		helper.checarAtivar();
	}
}