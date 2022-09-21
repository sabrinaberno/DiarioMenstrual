package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import control.CadastrarPessoaControl;
import model.Dados;
import model.Pessoa;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.text.ParseException;


/**
 * Tela de cadastro de usuário.
 * @author Mylena e Sabrina 
 * @since 2022
 * @version 1.0 
 */
public class CadastrarPessoa {
	
	CadastrarPessoaControl controller = new CadastrarPessoaControl();
	private JPanel painel = new JPanel();
	private  JFrame janela = new JFrame("Cadastro");	
	JLabel titulo = new JLabel("Cadastro");
	JLabel descricao = new JLabel("Insira seus dados abaixo ");
	JLabel txtEmail = new JLabel("Qual o seu e-mail?");
	JLabel txtSenha = new JLabel("Escolha uma senha (4 letras maiúsculas e 2 números) ");
	JLabel txtNome = new JLabel("Qual o seu nome? ");
	JLabel txtDtNascimento = new JLabel("Qual a sua data de nascimento? ");
	JButton check = new JButton("Cadastrar");
	public static JTextField nome;
	public static JTextField email;
	public static JPasswordField senha = new JPasswordField();
	public static JFormattedTextField nascimento;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPessoa window = new CadastrarPessoa();
					window.janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public CadastrarPessoa() {
		
		janela.setBounds(100, 100, 600, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);		
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		janela.setContentPane(painel);
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		janela.setLayout(null);
		janela.setVisible(true);


		titulo.setForeground(new Color(240,92,138));
		titulo.setFont(new Font("Didot", Font.PLAIN, 45));
		titulo.setBounds(200, 40, 600, 50);
		janela.getContentPane().add(titulo);	

		
		descricao.setForeground(Color.BLACK);
		descricao.setFont(new Font("Roboto", Font.PLAIN, 20));
		descricao.setBounds(180, 95, 300, 30);
		janela.getContentPane().add(descricao);

				
		txtNome.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtNome.setBounds(55, 160, 370, 30);
		janela.getContentPane().add(txtNome);
		
		txtDtNascimento.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtDtNascimento.setBounds(55,230, 370, 30);
		janela.getContentPane().add(txtDtNascimento);
		
		
		txtEmail.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtEmail.setBounds(55, 300, 370, 30);
		janela.getContentPane().add(txtEmail);
		
		txtSenha.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtSenha.setBounds(55, 370, 500, 30);
		janela.getContentPane().add(txtSenha);
		
		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException ignore) {
			//
		}
		if (mascaraData != null) {
			mascaraData.setPlaceholderCharacter('_');
		}
		
		nascimento = new JFormattedTextField(mascaraData);
		txtDtNascimento.setLabelFor(txtDtNascimento);
		nascimento.setBounds(55, 260, 370, 20);
		janela.add(nascimento);	
		
		nome = new JTextField();
		nome.setBounds(55, 190, 495, 25);
		janela.getContentPane().add(nome);

		email = new JTextField();	
		email.setBounds(55, 330, 495, 25);
		janela.getContentPane().add(email);
		
		senha.setBounds(55, 400, 495, 25);
		janela.getContentPane().add(senha);
		

		check.setBackground(new Color(250,224,228));
		check.setForeground(Color.BLACK);
		check.setBorder(BorderFactory.createLineBorder(new Color(179,136,235), 2));
		check.setFont(new Font("Digot", Font.PLAIN, 20));
		check.setBounds(230, 480, 140, 50);
		janela.getContentPane().add(check);
		
		/**
		 * Verificação dos dados inseridos pelo usuário
		 */

		check.addActionListener(new ActionListener() {
			

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				
				
				String msgErro = controller.verificaCadastro(nome.getText(), email.getText(),
				senha.getText());

				if (msgErro == null) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!",
							"Falta de dados",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (msgErro.length() > 0) {
					JOptionPane.showMessageDialog(null, msgErro, "ERRO", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Confirmar Cadastro", "Deseja Confirmar o Cadastro ?",
							JOptionPane.DEFAULT_OPTION);

					Dados.getPessoas().add(new Pessoa(txtNome.getText(),txtDtNascimento.getText(), txtEmail.getText(), 
							 senha.getText()));

					// outros
					janela.dispose();
					TelaLoging.main(null);
				}
				
			}
			
		});

		
				
	}

 
	public static JTextField getNome() {
		return nome;
	}


	

	public static JTextField getEmail() {
		return email;
	}




	public static JPasswordField getSenha() {
		return senha;
	}


	

	public static JFormattedTextField getNascimento() {
		return nascimento;
	}



}