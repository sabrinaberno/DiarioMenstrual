package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
 * @version 2.0
 */
public class TelaLoging {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	static Pessoa usuariaLogada;
	JLabel titulo = new JLabel("Loging");
	JLabel descricao_1 = new JLabel("Insira os dados necesarios ");
	JLabel descricao_2 = new JLabel("para efetuar seu loging: ");
	JLabel Nome = new JLabel("Nome (Letras maiusculas):");
	JLabel Senha = new JLabel("Senha (Deve comecar com 3 letras maiusculas e \n terminar com 4 numeros): ");
	JButton logar = new JButton("Logar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoging window = new TelaLoging();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLoging() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		titulo.setForeground(new Color(255,92,138));
		titulo.setFont(new Font("Didot", Font.PLAIN, 37));
		titulo.setBounds(153, 13, 194, 75);
		frame.getContentPane().add(titulo);	

		
		descricao_1.setForeground(Color.BLACK);
		descricao_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		descricao_1.setBackground(Color.CYAN);
		descricao_1.setBounds(110, 88, 239, 31);
		frame.getContentPane().add(descricao_1);

		
		descricao_2.setFont(new Font("Roboto", Font.PLAIN, 17));
		descricao_2.setBounds(120, 114, 239, 13);
		frame.getContentPane().add(descricao_2);

		
		Nome.setFont(new Font("Cambria", Font.PLAIN, 15));
		Nome.setBounds(53, 152, 176, 14);
		frame.getContentPane().add(Nome);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(53, 173, 335, 20);
		frame.getContentPane().add(textField);

		
		Senha.setVerticalAlignment(SwingConstants.BOTTOM);
		Senha.setHorizontalAlignment(SwingConstants.LEFT);
		Senha.setFont(new Font("Cambria", Font.PLAIN, 15));
		Senha.setBounds(53, 214, 335, 14);
		frame.getContentPane().add(Senha);

		

		passwordField = new JPasswordField();
		passwordField.setBounds(53, 251, 335, 20);
		frame.getContentPane().add(passwordField);
		
		logar.setBackground(new Color(250,224,228));
		logar.setForeground(Color.BLACK);
		logar.setBorder(BorderFactory.createLineBorder(new Color(179,136,235), 2));
		logar.setFont(new Font("Cambria", Font.PLAIN, 11));
		logar.setBounds(171, 287, 89, 23);
		frame.getContentPane().add(logar);

		/**
		 * Tenta encontrar se o usu�rio j� foi cadastrado ou n�o.
		 */
		
		logar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				TelaLoging.usuariaLogada = ControllerLoging.validarLogin(textField.getText(), passwordField.getText());
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