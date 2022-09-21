package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Ciclo;
import model.Dados;
import model.Pessoa;
import view.CadastrarCiclo;
import view.CadastrarPessoa;
import view.TelaMenu;



/**
 * Classe organia a lógica entre a view CadastrarPessoa e a model Pessoa.
 * 
 * @author Mylena e Sabrina
 * 
 * @see CadastrarCiclo  
 *
 */
public class CadastrarCicloControl {
	
	private Pessoa pessoaEscolhida;
	
	public Pessoa resgatarPessoaEscolhida(String nome) {
		for (Pessoa pessoaAtual : Dados.getPessoas()) {
			if (pessoaAtual.getNome().equals(nome)) {
				return pessoaAtual;
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
	public Object[] criarArraPessoas() {
		List<String> modelo = new ArrayList<>();

		for (Pessoa pessoa : Dados.getPessoas()) {
			modelo.add(pessoa.getNome());
		}

		return modelo.toArray();
	}

	
	public Ciclo obterModelo() {
		String numero = CadastrarCiclo.getNumero().getText();		
		String modeloDuracao = CadastrarCiclo.getDuracao().getText();
		String modeloInicio = CadastrarCiclo.getDtInicio().getText();
		String modeloFinal = CadastrarCiclo.getDtFinal().getText();

		Date dtInicio;
		Date dtFinal;
		int duracao;
		

		if (numero.isEmpty()) {
			CadastrarCiclo.getNumero().setText("");
			return null;
		}
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			dtInicio = formatador.parse(modeloInicio);
		} catch (ParseException ee) {
			CadastrarCiclo.getDtInicio().setText("");
			return null;
		}
		
		try {
			dtFinal = formatador.parse(modeloFinal);
		} catch (ParseException ee) {
			CadastrarCiclo.getDtFinal().setText("");
			return null;
		}
		
		try {
			duracao = Integer.parseInt(modeloDuracao);
		} catch (NumberFormatException e) {
			CadastrarCiclo.getDuracao().setText("");
			return null;
		}
		
		

		return new Ciclo(numero, duracao, dtInicio, dtFinal);

	}
	
	/**
	 * Recebe um Ciclo e o cadastra em Dados.
	 * 
	 * @param modelo de Ciclo para cadastrar
	 */
	public void setarModelo(Ciclo modelo) {
		Dados.getCiclos().add(modelo);
	}

	/**
	 * Retorna todos as entradas para o padrão.
	 */
	public void limpaCampo() {
		CadastrarCiclo.getNumero().setText("");
		CadastrarCiclo.getDtFinal().setText("");
		CadastrarCiclo.getDtInicio().setText("");
		CadastrarCiclo.getDuracao().setText("");
	}
	
	public void executarBotao(Object botaoFonte) {
		if (botaoFonte == CadastrarCiclo.getCancelar()) {
			limpaCampo();
			
			TelaMenu.main(null);
		} else {
			pessoaEscolhida = resgatarPessoaEscolhida(CadastrarPessoa.getNome().getSelectedText().toString());

			Ciclo modelo = obterModelo();

			if (modelo != null) {
				setarModelo(modelo);
				limpaCampo();
				
			}
		}
	}
	
public static Ciclo validarBusca(String numero) {
		
		for (Ciclo c : Dados.getCiclos()) {
			if (c.getNumero().equals(numero)) {
				return c;
			}
		}
		return null;

	}

/**
 * Verifica se o numero do ciclo foi cadastrado
 * @param numero
 * 
 */
public static Ciclo validarCadastro(String numero) {
	for (Ciclo c : Dados.getCiclos()) {
		if (c.getNumero().equals(numero) ) {
			return c;
		}
	}
	return null;

}

	/**
	 * Usado para preencher a caixa com as pessoas
	 * 
	 * 
	 */
	public DefaultComboBoxModel<Object> atualizarModelo() {
		return new DefaultComboBoxModel<>(criarArraPessoas());
	}

	public Pessoa gePessoaEscolhida() {
		return pessoaEscolhida;
	}

	
}
