package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControllerLoging;
import model.Pessoa;

import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Tela de login da pessoa
 * @author Mylena e Sabrina
 * @version 1.0
 */
public class TelaLoging extends JFrame {

	private JPanel painel = new JPanel();
	private  JFrame janela = new JFrame("Login");
	private JTextField textField = new JTextField();;
	private JPasswordField passwordField = new JPasswordField();;
	static Pessoa usuariaLogada;
	JLabel titulo = new JLabel("Loging");
	JLabel descricao = new JLabel("Insira seus dados abaixo ");
	JLabel txtEmail = new JLabel("Digite seu email:");
	JLabel senha = new JLabel("Digite sua senha: ");
	JButton logar = new JButton("Entrar");

	/**
	 * Create the application.
	 */
	
	public TelaLoging() {

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

				
		txtEmail.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtEmail.setBounds(55, 160, 370, 30);
		janela.getContentPane().add(txtEmail);


		textField.setBounds(55, 190, 495, 25);
		janela.getContentPane().add(textField);

		
		senha.setFont(new Font("Cambria", Font.PLAIN, 18));
		senha.setBounds(55, 235, 495, 35);
		janela.getContentPane().add(senha);

		
		passwordField.setBounds(55, 265, 495, 25);
		janela.getContentPane().add(passwordField);
		

		logar.setBackground(new Color(250,224,228));
		logar.setForeground(Color.BLACK);
		logar.setBorder(BorderFactory.createLineBorder(new Color(179,136,235), 2));
		logar.setFont(new Font("Cambria", Font.PLAIN, 22));
		logar.setBounds(230, 350, 140, 50);
		janela.getContentPane().add(logar);

		logar.addActionListener(new ActionListener() {
		
		/**
		 * Tenta encontrar se o usuario ja foi cadastrado ou nao.
		 */
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				TelaLoging.usuariaLogada = ControllerLoging.validarLogin(textField.getText(), passwordField.getText());
				if (TelaLoging.usuariaLogada == null) {
					// login deu errado, refazer login
				} else {
					janela.dispose();
					new Menu();
				}
			}
		});
			
	}
}

	
	