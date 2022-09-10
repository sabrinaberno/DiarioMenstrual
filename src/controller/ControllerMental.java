package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Ciclo;
import model.Dados;
import model.SintomaMental;
import view.CadastrarMental;


/**
 * @author Mylena e Sabrina
 * @since 2022
 * @version 1.0
 */

public class ControllerMental {
	private Ciclo cicloEscolhido;

	CadastrarMental view;

	/**
	 * Inicializa view.
	 * 
	 * @param view instância de CadastrarFilme
	 */
	public ControllerMental(CadastrarMental view) {
		this.view = view;
	}

	/**
	 * Procura nos estúdios cadastrados e retorna o estúdio cujo nome seja igual ao
	 * escolhido (null caso não exista).
	 * 
	 * @param nome Nome do estudio
	 * @return estudio escolhido
	 */
	public Ciclo resgatarCicloEscolhido(String numero) {
		for (Ciclo cicloAtual : Dados.getCiclos()) {
			if (cicloAtual.getNumero().equals(numero)) {
				return cicloAtual;
			}
		}

		return null;
	}

	/**
	 * Gera uma array de Object (sempre String) com o nome de todos os estúdios
	 * cadastrados.
	 * 
	 * @return Object[] nomes dos estúdios
	 */
	public Object[] criarArrayCiclos() {
		List<String> modelo = new ArrayList<>();

		for (Ciclo ciclo : Dados.getCiclos()) {
			modelo.add(ciclo.getNumero());
		}

		return modelo.toArray();
	}

	/**
	 * Resgata as informações da tela, valida essas informações e retorna um objeto
	 * Filme (null caso a validação falhe).
	 * 
	 * @return Filme ou null
	 */
	public SintomaMental obterModelo() {
		String nome = view.getFieldNome().getText();
		String descricao = view.getFieldDescricao().getText();
		String modeloCadastro = view.getFieldCadastro().getText();
		
		Date cadastro;
		

		if (nome.isEmpty()) {
			view.getFieldNome().setText("");
			return null;
		}
		
		if (descricao.isEmpty()) {
			view.getFieldDescricao().setText("");
			return null;
		}
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		try {
			cadastro = formatador.parse(modeloCadastro);
		} catch (ParseException ee) {
			view.getFieldCadastro().setText("");
			return null;
		}

		return new SintomaMental(nome,descricao,cadastro);

	}

	/**
	 * Recebe um Filme e o cadastra no estúdio escolhido.
	 * 
	 * @param modelo filme escolhido
	 */
	public void setarModelo(SintomaMental modelo) {
		view.getController().getCicloEscolhido().getMentais().add(modelo);
	}

	/**
	 * Retorna todos as entradas para o padrão.
	 */
	public void limpaCampo() {
		view.getFieldNome().setText("");
		view.getFieldDescricao().setText("");
		view.getFieldDescricao().setText("");
	}
		
		public void executarBotao(Object botaoFonte) {
			if (botaoFonte == view.getButtonCancelar()) {
				limpaCampo();
				
			} else {
				cicloEscolhido = resgatarCicloEscolhido(view.getFieldCiclo().getSelectedItem().toString());

				SintomaMental modelo = obterModelo();

				if (modelo != null) {
					setarModelo(modelo);
					limpaCampo();
					
				}
			}
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
	
