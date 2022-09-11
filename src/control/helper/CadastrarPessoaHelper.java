package control.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Dados;
import model.Pessoa;
import vision.CadastrarPessoa;

/**
 * Classe auxiliar que cont�m m�todos �teis para sua respectivaa classe
 * controller.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarPessoaHelper {

	private CadastrarPessoa view;

	/**
	 * Inicializa view.
	 * 
	 * @param view inst�ncia de CadastrarEstudio
	 */
	public CadastrarPessoaHelper(CadastrarPessoa view) {
		this.view = view;
	}

	/**
	 * Resgata as informa��es da tela, valida essas informa��es e retorna um objeto
	 * Estudio (null caso a valida��o falhe).
	 * 
	 * @return Estudio ou null
	 */
	public Pessoa obterModelo() {
		String nome = view.getFieldNome().getText();		
		String modeloNascimento = view.getFieldData().getText();
		String email = view.getFieldEmail().getText();
		String senha = view.getSenha().getText();
		

		if (nome.isEmpty()) {
			view.getFieldNome().setText("");
			return null;
		}
		
		if (email.isEmpty()) {
			view.getFieldEmail().setText("");
			return null;
		}
		if (senha.isEmpty()) {
			view.getSenha().setText("");
			return null;
		}

		

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date data;
		try {
			data = formatador.parse(modeloNascimento);
		} catch (ParseException ee) {
			view.getFieldData().setText("");
			return null;
		}

		

		return new Pessoa(nome, data,email,senha);

	}

	/**
	 * Recebe um Estudio e o cadastra em Dados.
	 * 
	 * @param modelo Estudio para cadastrar
	 */
	public void setarModelo(Pessoa modelo) {
		Dados.getPessoas().add(modelo);
	}

	/**
	 * Retorna todos as entradas para o padr�o.
	 */
	public void limpaCampo() {
		view.getFieldNome().setText("");		
		view.getFieldData().setText("");
		
	}
}
