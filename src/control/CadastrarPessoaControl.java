package control;

import appmain.MainFrameControl;
import control.helper.CadastrarPessoaHelper;
import model.Dados;
import model.Pessoa;
import vision.CadastrarPessoa;

/**
 * Classe auxiliar que cont�m a l�gica por tr�s da classe CadastraEstudio.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see CadastrarEstudio
 * @see CadastrarEstudioHelper
 */
public class CadastrarPessoaControl {

	private CadastrarPessoa view;
	private CadastrarPessoaHelper helper;

	/**
	 * Inicializa view e helper.
	 * 
	 * @param view A tela
	 */
	public CadastrarPessoaControl(CadastrarPessoa view) {
		this.view = view;
		this.helper = new CadastrarPessoaHelper(view);
	}

	/**
	 * Executa uma a��o de acordo com o bot�o selecionado na view
	 * 
	 * Casos: Caso bot�o cancelar: limpe as entradas e volte ao menu.
	 * 
	 * Caso botao confirmar: crie um modelo de Estudio (null caso contenha
	 * informa��es erradas), cadastra o est�dio em Dados, limpa as entradas e mostra
	 * o menu.
	 * 
	 * @param botaoSelecionado Um botao da tela
	 */
	public void executarBotao(Object botaoSelecionado) {
		if (botaoSelecionado == view.getButtonCancelar()) {
			helper.limpaCampo();
			MainFrameControl.mostrarMenu();
		} else {
			Pessoa modelo = helper.obterModelo();

			if (modelo != null) {
				helper.setarModelo(modelo);
				helper.limpaCampo();
				MainFrameControl.mostrarMenu();
			}
		}
	}
	
	public static Pessoa validarLogin(String login, String senha) {
		for (Pessoa usr : Dados.getPessoas()) {
			if (usr.getNome().equals(login) && usr.getSenha().equals(senha)) {
				return usr;
			}
		}
		return null;

	}
	
	/**
	 * Verifica se o nome colocado no loging foi cadastrado
	 * @param nome 
	 * @return retorna as informa��es do usu�rio encontrado caso ele for encontrado
	 */
	public static Pessoa validarBusca(String login) {
		
		for (Pessoa usr : Dados.getPessoas()) {
			if (usr.getNome().equals(login)) {
				return usr;
			}
		}
		return null;

	}
	
	public String verificaCadastro(String nome, String email, String senha) {
		String msgErro = "";
		if (nome.length() == 0 || email.length() == 0 || 			
				 senha.length() == 0) {
			return null;
		}
		if (!validarNome(nome)) {
			msgErro += "Nome invalido\n";
		}
		if (!validarEmail(email)) {
			msgErro += "Email invalido\n";
		}
		
		
		if (!validarSenha(senha)) {
			msgErro += "Senha invalida\n";
		}
		return msgErro;
	}
	
	
	/**
	 * Verifica a respota do nome do usuário. Faz as verificações:
	 * (1) Se a resposta contém apenas letras.
	 * @param nomeInput
	 * @return booleano verdadeiro ou falso.
	 */
	public boolean validarNome(String nomeInput) {
		boolean verificar = true;
		if (!nomeInput.substring(0).matches("[A-Z]*")) {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Verifica a respota do e-mail do usuário. Faz as verificações:
	 * (1) Se a resposta contém o @ do e-mail.
	 * @param emailValid
	 * @return booleano verdadeiro ou falso.
	 */
	public boolean validarEmail(String emailValid) {
		boolean verificar = true;

		if (!emailValid.substring(0).matches("(.*)@(.*)")) {
			verificar = false;
		}
		return verificar;
	}



	/**
	 * Verifica a respota da senha do usuário. Faz as verificações:
	 * (1) Se a resposta contém necessariamente 7 caracteres.
	 * (2) Se a resposta contém 3 letras maiúsculas e 4 números.
	 * @param senhaValid
	 * @return booleano verdadeiro ou falso.
	 */
	public boolean validarSenha(String senhaValid) {
		boolean verificar = true;
		if (senhaValid.length() != 7) {
			verificar = false;
		}
		if (!senhaValid.substring(0, 3).matches("[A-Z]*")) {
			verificar = false;
		}
		if (!senhaValid.substring(3).matches("[0-9]*")) {
			verificar = false;
		}
		return verificar;
	}

	

	/**
	 * Deleta todas as informações dos usuários.
	 * @param usr
	 */
	public void deletarUsuario(Pessoa usr) {
		Dados.getPessoas().remove(usr);
	}

	public CadastrarPessoaHelper getHelper() {
		return helper;
	}
}
