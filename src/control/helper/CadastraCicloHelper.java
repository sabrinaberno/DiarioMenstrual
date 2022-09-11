package control.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Ciclo;
import model.Dados;

import model.Pessoa;
import vision.CadastrarCiclo;

/**
 * Classe auxiliar que cont�m m�todos �teis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastraCicloHelper {

	CadastrarCiclo view;

	/**
	 * Inicializa view.
	 * 
	 * @param view inst�ncia de CadastrarFilme
	 */
	public CadastraCicloHelper(CadastrarCiclo view) {
		this.view = view;
	}

	/**
	 * Procura nos est�dios cadastrados e retorna o est�dio cujo nome seja igual ao
	 * escolhido (null caso n�o exista).
	 * 
	 * @param nome Nome do estudio
	 * @return estudio escolhido
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
	 * Gera uma array de Object (sempre String) com o nome de todos os est�dios
	 * cadastrados.
	 * 
	 * @return Object[] nomes dos est�dios
	 */
	public Object[] criarArrayPessoas() {
		List<String> modelo = new ArrayList<>();

		for (Pessoa pessoa : Dados.getPessoas()) {
			modelo.add(pessoa.getNome());
		}

		return modelo.toArray();
	}

	/**
	 * Resgata as informa��es da tela, valida essas informa��es e retorna um objeto
	 * Filme (null caso a valida��o falhe).
	 * 
	 * @return Filme ou null
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
	 * Recebe um Filme e o cadastra no est�dio escolhido.
	 * 
	 * @param modelo filme escolhido
	 */
	public void setarModelo(Ciclo modelo) {
		view.getController().getPessoaEscolhida().getCiclos().add(modelo);
	}

	/**
	 * Retorna todos as entradas para o padr�o.
	 */
	public void limpaCampo() {
		view.getFieldNome().setText("");
		view.getFieldDuracao().setText("");
		view.getFieldDataInicio().setText("");
		view.getFieldDataFinal().setText("");
		
	}
}
