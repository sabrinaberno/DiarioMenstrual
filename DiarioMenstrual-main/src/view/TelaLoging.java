package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import control.CadastrarPessoaControl;
import model.Pessoa;
/**
 * Tela de login da pessoa
 * @author Mylena e Sabrina
 * @version 1.0
 */
public class TelaLoging extends JFrame {

	
	CadastrarPessoaControl controller = new CadastrarPessoaControl();
	private static final long serialVersionUID = 1L;
	private JPanel painel = new JPanel();
	private JFrame frame;
	private  JFrame janela = new JFrame("Login");
	private JTextField email = new JTextField();;
	private JPasswordField senha = new JPasswordField();;
	static Pessoa usuariaLogada;
	JLabel titulo = new JLabel("Login");
	JLabel descricao = new JLabel("Insira seus dados abaixo ");
	JLabel txtEmail = new JLabel("Digite seu email:");
	JLabel txtSenha = new JLabel("Digite sua senha: ");
	JButton entrar = new JButton("Entrar");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoging window = new TelaLoging();
					window.janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TelaLoging() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	/**
	 * Create the application.
	 */
	
	private void initialize() {

		janela.setBounds(100, 100, 600, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);		
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		janela.setLayout(null);
		janela.setVisible(true);


		titulo.setForeground(new Color(240,92,138));
		titulo.setFont(new Font("Didot", Font.PLAIN, 37));
		titulo.setBounds(245, 35, 500, 50);
		janela.getContentPane().add(titulo);	

		
		descricao.setForeground(Color.BLACK);
		descricao.setFont(new Font("Roboto", Font.PLAIN, 23));
		descricao.setBackground(Color.CYAN);
		descricao.setBounds(180, 95, 300, 30);
		janela.getContentPane().add(descricao);

				
		txtEmail.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtEmail.setBounds(55, 160, 370, 30);
		janela.getContentPane().add(txtEmail);


		email.setBounds(55, 190, 495, 25);
		janela.getContentPane().add(email);

		
		txtSenha.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtSenha.setBounds(55, 235, 495, 35);
		janela.getContentPane().add(txtSenha);

		
		senha.setBounds(55, 265, 495, 25);
		janela.getContentPane().add(senha);
		

		entrar.setBackground(new Color(250,224,228));
		entrar.setForeground(Color.BLACK);
		entrar.setBorder(BorderFactory.createLineBorder(new Color(179,136,235), 2));
		entrar.setFont(new Font("Digot", Font.PLAIN, 22));
		entrar.setBounds(230, 350, 140, 50);
		janela.getContentPane().add(entrar);

		entrar.addActionListener(new ActionListener() {
		
		/**
		 * Tenta encontrar se o usuario ja foi cadastrado ou nao.
		 */
	
		
		public void actionPerformed(ActionEvent e) {				
				TelaLoging.usuariaLogada = CadastrarPessoaControl.validarLogin(email.getText(), senha.getText());
				
				if (TelaLoging.usuariaLogada == null) {
					// login deu errado, refazer login
				} else {
					frame.dispose();
					TelaMenu.main(null);
				}
			}
		});
			
	}
	
	
}
