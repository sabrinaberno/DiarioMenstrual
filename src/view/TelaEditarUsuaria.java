package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import control.CadastrarPessoaControl;

import model.Dados;

import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

/**
 * Tela para editar os dados de pessoa
 * @author Mylena e Sabrina
 */
public class TelaEditarUsuaria {

	private JFrame frame;
	public JTextField txtNome;
	public JTextField txtEmail;
    public JFormattedTextField txtNascimento;
	public JPasswordField senha;
	private CadastrarPessoaControl controller;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public TelaEditarUsuaria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		CadastrarPessoaControl controller = new CadastrarPessoaControl();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel tituloUm = new JLabel("Insira os dados necesarios ");
		tituloUm.setFont(new Font("Elephant", Font.PLAIN, 17));
		tituloUm.setForeground(Color.BLACK);
		tituloUm.setBackground(Color.CYAN);
		tituloUm.setBounds(111, 99, 239, 31);
		frame.getContentPane().add(tituloUm);

		JLabel tituloDois = new JLabel("para editar seu cadastro: ");
		tituloDois.setFont(new Font("Elephant", Font.PLAIN, 17));
		tituloDois.setBounds(121, 125, 239, 13);
		frame.getContentPane().add(tituloDois);

		JLabel tituloNome = new JLabel("Nome (Letras maiusculas):");
		tituloNome.setFont(new Font("Cambria", Font.PLAIN, 15));
		tituloNome.setBounds(46, 165, 176, 14);
		frame.getContentPane().add(tituloNome);

		txtNome = new JTextField();
		txtNome.setBounds(46, 186, 335, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("E-mail:");
		lblNewLabel_2_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(46, 246, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_1);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(46, 267, 335, 20);
		frame.getContentPane().add(txtEmail);

		

		

		/**
		 * Faz a verifica��o das verifica��es necess�rias de cada informa��o.
		 */
		JButton check = new JButton("OK");
		check.setFont(new Font("Cambria", Font.PLAIN, 11));
		check.setBackground(SystemColor.desktop);
		check.setBounds(174, 559, 89, 23);
		check.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String msgErro = controller.verificaCadastro(txtNome.getText(), txtEmail.getText(),  txtNascimento.getText(),					
						TelaLoging.usuariaLogada.getSenha());

				if (msgErro == null) {
					JOptionPane.showMessageDialog(null, "Alguma informacao esta vazia! Preencha todos os campos!",
							"Falta de dados",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (msgErro.length() > 0) {
					JOptionPane.showMessageDialog(null, msgErro, "ERRO", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Confirmar Edi��o", "Deseja Confirmar a Edi��o ?",
							JOptionPane.DEFAULT_OPTION);

					Dados.getPessoas().get(Dados.getPessoas().indexOf(TelaLoging.usuariaLogada)).editarDados(
							txtNome.getText(),txtNascimento.getText(), txtEmail.getText(), senha.getText());


					
				}
			}
		});

		frame.getContentPane().add(check);

		JLabel lblCadastro = new JLabel("Editar");
		lblCadastro.setForeground(SystemColor.desktop);
		lblCadastro.setFont(new Font("Elephant", Font.PLAIN, 37));
		lblCadastro.setBounds(146, 25, 204, 75);
		frame.getContentPane().add(lblCadastro);

		JLabel tiruloUm_1 = new JLabel("Editar");
		tiruloUm_1.setForeground(new Color(51, 204, 204));
		tiruloUm_1.setFont(new Font("Elephant", Font.PLAIN, 37));
		tiruloUm_1.setBounds(136, 11, 194, 75);
		frame.getContentPane().add(tiruloUm_1);
	}

	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarUsuaria window = new TelaEditarUsuaria();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
