package control;

import model.Dados;
import model.Pessoa;
import view.CadastrarPessoa;


/**
 * Classe organia a lógica entre a view CadastrarPessoa e a model Pessoa.
 * 
 * @author Mylena e Sabrina
 * 
 * @see CadastrarPessoa  
 * @see TelaLogging
 */
public class CadastrarPessoaControl {

	
	public Pessoa obterModelo() {
		String nome = CadastrarPessoa.getNome().getText();		
		String nascimento = CadastrarPessoa.getNascimento().getText();
		String email = CadastrarPessoa.getEmail().getText();
		@SuppressWarnings("deprecation")
		String senha = CadastrarPessoa.getSenha().getText();
		

		if (nome.isEmpty()) {
			CadastrarPessoa.getNome().setText("");
			return null;
		}
		
		if (email.isEmpty()) {
			CadastrarPessoa.getEmail().setText("");
			return null;
		}
		if (senha.isEmpty()) {
			CadastrarPessoa.getSenha().setText("");
			return null;
		}
		
		if (nascimento.isEmpty()) {
			CadastrarPessoa.getSenha().setText("");
			return null;
		}		
		

		return new Pessoa(nome, nascimento,email,senha);

	}
	
	
	public static Pessoa validarLogin(String login, String senha) {
		for (Pessoa usr : Dados.getPessoas()) {
			if (usr.getEmail().equals(login) && usr.getSenha().equals(senha)) {
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
	 * (1) Se a resposta contém necessariamente 6 caracteres.
	 * (2) Se a resposta contém 4 letras maiúsculas e 2 números.
	 * @param senhaValid
	 * @return booleano verdadeiro ou falso.
	 */
	public boolean validarSenha(String senhaValid) {
		boolean verificar = true;
		if (senhaValid.length() != 6) {
			verificar = false;
		}
		if (!senhaValid.substring(0, 4).matches("[A-Z]*")) {
			verificar = false;
		}
		if (!senhaValid.substring(5, 6).matches("[0-9]*")) {
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

	
}
