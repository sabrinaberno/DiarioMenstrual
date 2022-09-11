package vision;

import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;


import control.CadastrarPessoaControl;

/**
 * JPanel para cadastrar um est�dio.
 * 
 * Herda a classe JCampos que cont�m um fundo, t�tulo e dois bot�es.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarPessoa extends JCampos {
	private static final long serialVersionUID = -7318790884045444829L;
	private JTextField fieldNome;
	private JTextField fieldEmail;
	private static JPasswordField senha;
	private JFormattedTextField ftfieldData;
	private CadastrarPessoaControl controller;

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	public CadastrarPessoa() {
		super("Cadastre uma nova pessoa");

		controller = new CadastrarPessoaControl(this);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(JCampos.FONT);
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setBounds(169, 195, 175, 13);
		add(labelNome);


		JLabel labelData = new JLabel("Data de nascimento:");
		labelData.setFont(JCampos.FONT);
		labelData.setHorizontalAlignment(SwingConstants.RIGHT);
		labelData.setBounds(158, 297, 186, 13);
		add(labelData);
		
		JLabel labelEmail = new JLabel("Data de nascimento:");
		labelEmail.setFont(JCampos.FONT);
		labelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEmail.setBounds(158, 297, 186, 13);
		add(labelEmail);
		
		JLabel labelSenha = new JLabel("Senha : (Deve comecar com 3 letras maiusculas e 4 números");
		labelSenha.setFont(JCampos.FONT);
		labelSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSenha.setBounds(158, 297, 186, 13);
		add(labelSenha);

		
		fieldNome = new JTextField();
		labelNome.setLabelFor(fieldNome);
		fieldNome.setBounds(405, 192, 147, 19);
		add(fieldNome);
		fieldNome.setColumns(10);
		
		fieldEmail = new JTextField();
		labelEmail.setLabelFor(fieldNome);
		fieldEmail.setBounds(405, 192, 147, 19);
		add(fieldEmail);
		fieldEmail.setColumns(10);
		
		senha = new JPasswordField();
		labelSenha.setLabelFor(senha);
		senha.setBounds(405, 192, 147, 19);
		add(senha);
		senha.setColumns(10);

		

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException ignore) {
			//
		}
		if (mascaraData != null) {
			mascaraData.setPlaceholderCharacter('_');
		}
		ftfieldData = new JFormattedTextField(mascaraData);
		labelData.setLabelFor(ftfieldData);
		ftfieldData.setBounds(405, 294, 147, 19);
		add(ftfieldData);

	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	

	public JTextField getFieldEmail() {
		return fieldEmail;
	}

	

	public static JPasswordField getSenha() {
		return senha;
	}

	

	public JFormattedTextField getFieldData() {
		return ftfieldData;

	}

	public CadastrarPessoaControl getController() {
		return controller;
	}

	/**
	 * Executa o comando para o bot�o selecionado.
	 * 
	 * implementa��o da interface ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}
}