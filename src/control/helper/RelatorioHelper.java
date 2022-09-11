package control.helper;

import java.util.ArrayList;
import java.util.List;

import model.Ciclo;
import model.Dados;

import model.Pessoa;
import vision.Relatorio;


/**
 * Classe auxiliar que cont�m m�todos �teis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class RelatorioHelper {
	Relatorio view;

	/**
	 * Inicializa view.
	 * 
	 * @param view inst�ncia de CadastrarFilme
	 */
	public RelatorioHelper(Relatorio view) {
		this.view = view;
	}

	/**
	 * Pesquisa todos os estudios em Data e os armazena em uma array de String
	 * 
	 * @return Object[] a array com todos os estudios (sempre uma array de string)
	 */
	public Object[] criarArrayPessoas() {
		List<String> modelo = new ArrayList<>();

		modelo.add(null);

		for (Pessoa pessoa : Dados.getPessoas()) {
			modelo.add(pessoa.getNome());
		}

		return modelo.toArray();
	}

	/**
	 * Gera um texto formatado contendo todos os filmes desse est�dio.
	 * 
	 * O m�todo pesquisa nas arrays na classe Dados e simplesmente adiciona todos os
	 * nomes de filme em um modelo StringBuilder com o metodo append().
	 * 
	 * @return String o texto de relatorio completo
	 */
	public String gerarRelatorio() {
		boolean flag = false;
		StringBuilder modelo = new StringBuilder();

		modelo.append("Pessoas:\n");

		for (Pessoa pessoaAtual : Dados.getPessoas()) {
			if (pessoaAtual.getNome().equals(view.getFieldPessoa().getSelectedItem())) {
				flag = true;
				for (Ciclo cicloAtual : pessoaAtual.getCiclos()) {
					modelo.append("    -");
					modelo.append(cicloAtual.getNumero());
					modelo.append("\n");
				}
			}
		}

		if (!flag) {
			return "não há ciclos cadastrados para essa pessoa";
		}

		return modelo.toString();
	}

}
