package control.helper;

import model.Dados;
import vision.Menu;

/**
 * Classe auxiliar que cont�m m�todos �teis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class MenuControlHelper {

	Menu view;

	/**
	 * Inicializa view.
	 * 
	 * @param view inst�ncia de Menu
	 */
	public MenuControlHelper(Menu view) {
		this.view = view;
	}

	/**
	 * Faz alguns testes e habilita os bot�es que poder�o ser utilizados
	 * 
	 * Testes: 1 - caso exista algum est�dio cadastrado: habilite o bot�o Adicionar
	 * filme.
	 * 
	 * 2 - caso exista algum ator cadastrado: habilite o restante dos bot�es.
	 */
	public void checarAtivar() {
		if (!Dados.getPessoas().isEmpty()) {
			view.getButtonAdicionarCiclo().setEnabled(true);
		}

		if (!Dados.getCiclos().isEmpty()) {
			view.getButtonMostrarRelatorio().setEnabled(true);
			view.getButtonAdicionarFisicos().setEnabled(true);
			
		}
	}

}
