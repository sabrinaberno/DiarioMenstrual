package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;

import controller.HomeController;


public class Home extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(8, 1, 0, 0));
		
		
		
		
		
		
		super("My Home Page");
		
		this.controller = new HomeController(this);

		this.setSize(900, 700);
		this.setLayout(new GridLayout(3, 2));

		this.labelLogin = new JLabel("Login:");
		this.add(this.labelLogin);

		this.fieldLogin = new JTextField();
		this.add(this.fieldLogin);
		
		this.labelSenha = new JLabel("Senha:");
		this.add(this.labelSenha);

		this.fieldSenha = new JTextField();
		this.add(this.fieldSenha);

		this.cadastrar = new JButton("Cadastrar");
		this.cadastrar.addActionListener(this);
		this.add(this.cadastrar);

		this.cancelar = new JButton("Cancelar");
		this.cancelar.addActionListener(this);
		this.add(this.cancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.executarBotao(e);
	}

	public JLabel getLabelLogin() {
		return labelLogin;
	}

	public JTextField getFieldLogin() {
		return fieldLogin;
	}

	
	public JLabel getLabelSenha() {
		return labelSenha;
	}

	public JTextField getFieldSenha() {
		return fieldSenha;
	}
	
	

	public JButton getCadastrar() {
		return cadastrar;
	}

	
	public JButton getCancelar() {
		return cancelar;
	}

	public HomeController getController() {
		return controller;
	} 
}

