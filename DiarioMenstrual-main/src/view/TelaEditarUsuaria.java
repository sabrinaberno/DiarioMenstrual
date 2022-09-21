package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.text.MaskFormatter;

import control.CadastrarPessoaControl;

import model.Dados;

import javax.swing.JPasswordField;
import java.text.ParseException;


/**
 * Tela para editar os dados de pessoa
 * @author Mylena e Sabrina
 * @since 2021
 * @version 1.0
 */
public class TelaEditarUsuaria {

	private JFrame janela = new JFrame();
	public JTextField txtNome;
	public JTextField txtEmail;
    public JFormattedTextField txtNascimento;
	public JPasswordField txtSenha = new JPasswordField();
	public JLabel titulo = new JLabel("Editar");
	public JButton check = new JButton("Atualizar");
	public JLabel descricao = new JLabel("Edite os dados necesarios ");
	public JLabel nome = new JLabel("Nome (Letras maiusculas):");
	public JLabel email = new JLabel("E-mail:");
	public JLabel dtNascimento = new JLabel("Data de Nascimento:");
	public JLabel senha = new JLabel("Senha:");
	

	/**
	 * Initialize the application.
	 */

	public TelaEditarUsuaria() {
		CadastrarPessoaControl controller = new CadastrarPessoaControl();
		
		janela.setBounds(100, 100, 600, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);		
	
		
		janela.setLayout(null);
		janela.setVisible(true);


		titulo.setForeground(new Color(240,92,138));
		titulo.setFont(new Font("Didot", Font.PLAIN, 45));
		titulo.setBounds(240, 40, 600, 50);
		janela.getContentPane().add(titulo);	

		
		descricao.setForeground(Color.BLACK);
		descricao.setFont(new Font("Roboto", Font.PLAIN, 20));
		descricao.setBounds(180, 95, 300, 30);
		janela.getContentPane().add(descricao);

				
		nome.setFont(new Font("Roboto", Font.PLAIN, 18));
		nome.setBounds(55, 160, 370, 30);
		janela.getContentPane().add(nome);


		txtNome = new JTextField();
		txtNome.setBounds(55, 190, 495, 25);
		janela.getContentPane().add(txtNome);		

		dtNascimento.setFont(new Font("Roboto", Font.PLAIN, 18));
		dtNascimento.setBounds(55,230, 495, 30);
		janela.getContentPane().add(dtNascimento);
		
			
		
		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException ignore) {
			//
		}
		if (mascaraData != null) {
			mascaraData.setPlaceholderCharacter('_');
		}
				
		txtNascimento = new JFormattedTextField(mascaraData);
		dtNascimento.setLabelFor(dtNascimento);
		txtNascimento.setBounds(55, 270, 495, 25);
		janela.add(txtNascimento);	

		email.setFont(new Font("Roboto", Font.PLAIN, 18));
		email.setBounds(55, 310, 495, 30);
		janela.getContentPane().add(email);

		txtEmail = new JTextField();	
		txtEmail.setBounds(55, 340, 495, 25);
		janela.getContentPane().add(txtEmail);
				
		senha.setFont(new Font("Roboto", Font.PLAIN, 18));
		senha.setBounds(55, 370, 500, 30);
		janela.getContentPane().add(senha);

		txtSenha.setBounds(55, 410, 495, 25);
		janela.getContentPane().add(txtSenha);
		

		
		check.setBackground(new Color(250,224,228));
		check.setForeground(Color.BLACK);
		check.setBorder(BorderFactory.createLineBorder(new Color(179,136,235), 2));
		check.setFont(new Font("Digot", Font.PLAIN, 20));
		check.setBounds(230, 480, 140, 50);
		janela.getContentPane().add(check);

		/**
		 * Faz a verifica��o das verifica��es necess�rias de cada informa��o.
		 */
		check.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String msgErro = controller.verificaCadastro(txtNome.getText(), txtEmail.getText(),					
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
					JOptionPane.showMessageDialog(null, "Confirmar Alteração", "Deseja Confirmar a Edi��o ?",
							JOptionPane.DEFAULT_OPTION);

					Dados.getPessoas().get(Dados.getPessoas().indexOf(TelaLoging.usuariaLogada)).editarDados(
							txtNome.getText(),txtNascimento.getText(), txtEmail.getText(), senha.getText());


					
				}
			}
		});


		
		
	
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarUsuaria window = new TelaEditarUsuaria();
					window.janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
