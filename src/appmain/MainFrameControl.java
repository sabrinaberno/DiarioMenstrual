package appmain;

import java.awt.CardLayout;

import model.Pessoa;

import model.SintomaMental;
import vision.CadastrarCiclo;
import vision.CadastrarFisicos;
import vision.Menu;
import vision.Relatorio;



/**
 * Classe auxiliar que cont�m toda a l�gica por tr�s da classe MainFrame.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see MainFrame
 */
public class MainFrameControl {

	private MainFrame view;

	/**
	 * Construtor que inicializa o campo view.
	 * 
	 * @param view A tela
	 */
	public MainFrameControl(MainFrame view) {
		this.view = view;
	}

	/**
	 * M�todo que atualiza certas informa��es na tela que acabou de ser mostrada. O
	 * parametro tela � o JPanel que foi mostrado pelo m�todo show() (� necess�rio
	 * fazer um casting para a sua respectiva classe).
	 * 
	 * Casos poss�veis: Caso tela for Menu: reseta variavel de cadastro e faz
	 * validacao dos botoes. Caso tela for CadastrarFilme: atualiza o ComboBox de
	 * estudios. Caso tela for CadastrarAtores: atualiza a Jlist de atores e faz
	 * validacao do botao finalizar. Caso tela for CadastrarPapel: preenche o ator
	 * escolhido e o estudio escolhido. Caso tela for RelatorioAtoresDiretores:
	 * atualiza o relatorio. Caso tela for RelatorioFilmes: atualiza o ComboBox de
	 * estudios. Caso tela for RelatorioCache: atualiza o ComboBox de atores. Caso
	 * tela for RelatorioPersonagens: atualiza o ComboBox de atores.
	 * 
	 * @param tela tela recebida
	 */
	public void mudarTela(Object tela) {
		if (tela == view.getMenu()) {
			Menu telaAtual = (Menu) tela;
			telaAtual.getController().ativarbotao();
		} else if (tela == view.getCadastrarCiclo()) {
			CadastrarCiclo telaAtual = (CadastrarCiclo) tela;
			telaAtual.getFieldPessoa().setModel(telaAtual.getController().atualizarModelo());
		} else if (tela == view.getCadastrarFisicos()) {
			CadastrarFisicos telaAtual = (CadastrarFisicos) tela;
			telaAtual.getFieldSintomas().setModel(telaAtual.getController().atualizarModeloLista());
			
		} else if (tela == view.getRelatorio()) {
			Relatorio telaAtual = (Relatorio) tela;
			telaAtual.getFieldPessoa().setModel(telaAtual.getController().atualizarModelo());
		}
	}

	///////////////////////////////////////////////////////////////
	/**
	 * Muda a tela para Menu
	 */
	public static void mostrarMenu() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "menu");
	}

	/**
	 * Muda a tela para Registrar est�dio
	 */
	public static void mostrarCadastrarCiclo() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "cadastrarCiclo");
	}

	/**
	 * Muda a tela para Registrar filme
	 */
	public static void mostrarCadastrarFisicos() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "cadastrarFisicos");
	}

	/**
	 * Muda a tela para Registrar Ator
	 */
	public static void mostrarCadastraNovoFisicos() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "cadastrarNovoFisicos");
	}

	/**
	 * Muda a tela para Cadastrar Papel
	 */
	public static void mostrarRelatorio() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "relatorio");
	}

	/**
	 * Muda a tela para Novo Ator
	 */
	public static void mostrarCadastrarPessoa() {
		CardLayout cl = (CardLayout) MainFrame.getCont().getLayout();
		cl.show(MainFrame.getCont(), "cadastrarPessoa");
	}

	
}
