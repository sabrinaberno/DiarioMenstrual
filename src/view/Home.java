package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.HomeController;


public class Home extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
/*	private final JLabel labelLogin;
	private final JTextField fieldLogin;
	private final JLabel labelSenha;
	private final JTextField fieldSenha;
	private final JButton cadastrar;
	private final JButton cancelar;
	private final HomeController controller;

	public Home() {
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
	} */
}

