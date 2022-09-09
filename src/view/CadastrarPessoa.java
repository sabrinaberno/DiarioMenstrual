package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControllerUsuarias;
import model.Dados;
import model.Pessoa;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

/**
 * Tela de cadastro de usuário.
 * @author Mylena e Sabrina
 * @since 2022 
 * @version 1.0 
 */


public class CadastrarPessoa extends JFrame implements ActionListener {

	public JLabel titulo = new JLabel("Cadastro");
	private JPanel painel = new JPanel();
	private JFrame janela = new JFrame("Tela de Cadastro");
	public JLabel descricao = new JLabel("Insira os dados necesarios ");
	public JLabel nome = new JLabel("Nome em Letras maiusculas:");
	public static JTextField txtNome;
	public JLabel email = new JLabel("E-mail:");
	public static JTextField txtEmail = new JTextField();;
	public static JPasswordField txtsenha = new JPasswordField();
	public JLabel senha1 = new JLabel("Senha comecando com 3 letras maiusculas e ");
	public JLabel senha2 = new JLabel("terminar com 4 numeros):");
	public JButton check = new JButton("Cadastrar");

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public CadastrarPessoa() {
		
		ControllerUsuarias control = new ControllerUsuarias();
		janela.setBounds(100, 100, 600, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));


		titulo.setForeground(new Color(240,92,138));
		titulo.setFont(new Font("Elephant", Font.PLAIN, 37));
		titulo.setBounds(210, 30, 200, 75);
		janela.getContentPane().add(titulo);
		
		descricao.setFont(new Font("Elephant", Font.PLAIN, 20));
		descricao.setForeground(Color.BLACK);
		descricao.setBackground(Color.CYAN);
		descricao.setBounds(170, 100, 500, 50);
		janela.getContentPane().add(descricao);

		
		nome.setFont(new Font("Cambria", Font.PLAIN, 18));
		nome.setBounds(50, 170, 500, 20);
		janela.getContentPane().add(nome);

		txtNome = new JTextField();
		txtNome.setBounds(50, 195, 500, 30);
		janela.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		
		email.setFont(new Font("Cambria", Font.PLAIN, 18));
		email.setBounds(50, 260, 500, 20);
		janela.getContentPane().add(email);

		
		txtEmail.setBounds(50, 290, 500, 30);
		janela.getContentPane().add(txtEmail);

			

		senha1.setFont(new Font("Cambria", Font.PLAIN, 18));
		senha1.setBounds(50, 350, 500, 20);
		janela.getContentPane().add(senha1);


		senha2.setFont(new Font("Cambria", Font.PLAIN, 18));
		senha2.setBounds(50, 375, 500, 20);
		janela.getContentPane().add(senha2);

		txtsenha.setBounds(50, 410, 500, 30);
		janela.getContentPane().add(txtsenha);


		/**
		 * Faz a verificação das verificações necessárias de cada informação.
		 */
		check.setFont(new Font("Cambria", Font.PLAIN, 22));
		check.setForeground(Color.BLACK);
		check.setBorder(BorderFactory.createLineBorder(new Color(179,136,235), 2));
		check.setBounds(180, 470, 200, 40);
		janela.getContentPane().add(check);
		check.addActionListener(this);

				
	}


	public void actionPerformed(ActionEvent e) {
		
		@SuppressWarnings("deprecation")
		String msgErro = control.verificaCadastro(txtNome.getText(), txtEmail.getText(),
						
				txtsenha.getText());

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


					Dados.getPessoas().add(new Pessoa(txtNome.getText(), txtEmail.getText(), 
					txtsenha.getText()));

					
					janela.setVisible(false);
					new TelaLoging();
					
				}
			}
		});
	}
}