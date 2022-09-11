package control;

import javax.swing.DefaultComboBoxModel;

import appmain.MainFrameControl;
import control.helper.CadastraCicloHelper;
import model.Ciclo;
import model.Pessoa;
import vision.CadastrarCiclo;
import model.Dados;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * Classe que controla o cadastro de ciclo
 * 
 * @author Mylena e Sabrina
 * @version 2.0
 */
public class CadastrarCicloControl {
	private CadastrarCiclo view;
	private CadastraCicloHelper helper;
	private Pessoa pessoaEscolhida;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public CadastrarCicloControl(CadastrarCiclo view) {
		this.view = view;
		
	}
	/**
	 * Procura nas pessoas cadastradas e retorna qual foi escolhido.
	 * 
	 * @param nome Nome da pessoa
	 * @return pessoa escolhido
	 */
	public Pessoa resgatarPessoaEscolhida(String nome) {
		for (Pessoa pessoaAtual : Dados.getPessoas()) {
			if (pessoaAtual.getNome().equals(nome)) {
				return pessoaAtual;
			}
		}

		return null;
	}

	/**
	 * Gera uma array de Object com o nome das pessoas cadastradas
	 * @return Object[] nomes das pessoas
	 */
	public Object[] criarArrayPessoas() {
		List<String> modelo = new ArrayList<>();

		for (Pessoa pessoa : Dados.getPessoas()) {
			modelo.add(pessoa.getNome());
		}

		return modelo.toArray();
	}

	/**
	 * Busca as informações da tela e valida. 
	 * @return Ciclo ou null
	 */
	public Ciclo obterModelo() {
		String numero = view.getFieldNome().getText();
		String modeloduracao = view.getFieldDuracao().getText();
		String modeloinicio = view.getFieldDataInicio().getText();
		String modelofinal = view.getFieldDataFinal().getText();
		

		int duracao;
		Date dtinicio;
		Date dtfinal;
		

		if (numero.isEmpty()) {
			view.getFieldNome().setText("");
			return null;
		}

		try {
			duracao = Integer.parseInt(modeloduracao);
		} catch (NumberFormatException e) {
			view.getFieldDuracao().setText("");
			return null;
		}
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			dtinicio= formatador.parse(modeloinicio);
		} catch (ParseException ee) {
			view.getFieldDataInicio().setText("");
			return null;
		}
		
		try {
			dtfinal= formatador.parse(modelofinal);
		} catch (ParseException ee) {
			view.getFieldDataFinal().setText("");
			return null;
		}
		

		return new Ciclo(numero, duracao, dtinicio, dtfinal);

	}

	/**
	 * Recebe um ciclo e cadastra  na pessoa escolhida.
	 * 
	 * @param o  modelo de ciclo
	 */
	public void setarModelo(Ciclo modelo) {
		view.getController().getPessoaEscolhida().getCiclos().add(modelo);
	}

	/**
	 * Retorna todos as entradas para o padrão
	 */
	public void limpaCampo() {
		view.getFieldNome().setText("");
		view.getFieldDuracao().setText("");
		view.getFieldDataInicio().setText("");
		view.getFieldDataFinal().setText("");
		
	}

	
	public void executarBotao(Object botaoFonte) {
		if (botaoFonte == view.getButtonCancelar()) {
			limpaCampo();
			MainFrameControl.mostrarMenu();
		} else {
			pessoaEscolhida = helper.resgatarPessoaEscolhida(view.getFieldPessoa().getSelectedItem().toString());

			Ciclo modelo = helper.obterModelo();

			if (modelo != null) {
				setarModelo(modelo);
				limpaCampo();
				MainFrameControl.mostrarCadastrarPessoa();
			}
		}
	}


	public DefaultComboBoxModel<Object> atualizarModelo() {
		return new DefaultComboBoxModel<>(criarArrayPessoas());
	}

	public Pessoa getPessoaEscolhida() {
		return pessoaEscolhida;
	}
}
