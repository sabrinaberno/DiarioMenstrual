package vision;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import javax.swing.JFormattedTextField;


import javax.swing.text.MaskFormatter;

import control.NovoSintomaFisicoControl;



/**
 * JPanel para cadastrar um est�dio.
 * 
 * Herda a classe JCampos que cont�m um fundo, t�tulo e dois bot�es.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarNovoSintomaFisico extends JCampos {
	private static final long serialVersionUID = 3798826210256319527L;
	private JTextField fieldNome;
	private JTextField fieldIntensidade;
	private JFormattedTextField fieldData;	
	private JTextField fieldLLocal;	
	private NovoSintomaFisicoControl controller;

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	public CadastrarNovoSintomaFisico() {
		super("Cadastre um novo sintoma físico");

		controller = new NovoSintomaFisicoControl(this);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setFont(FONT);
		labelNome.setBounds(78, 182, 287, 21);
		add(labelNome);

		JLabel labelIntensidade = new JLabel("Intensidade:");
		labelIntensidade.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIntensidade.setFont(FONT);
		labelIntensidade.setBounds(78, 216, 287, 21);
		add(labelIntensidade);

		JLabel labelLocal = new JLabel("Local:");
		labelLocal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLocal.setFont(FONT);
		labelLocal.setBounds(78, 257, 287, 21);
		add(labelLocal);
		

		JLabel labelData = new JLabel("Data de cadastro:");
		labelData.setFont(FONT);
		labelData.setHorizontalAlignment(SwingConstants.RIGHT);
		labelData.setBounds(78, 328, 287, 28);
		add(labelData);

		fieldNome = new JTextField();
		fieldNome.setBounds(398, 181, 198, 24);
		add(fieldNome);
		fieldNome.setColumns(10);

		fieldLLocal = new JTextField();
		fieldLLocal.setBounds(398, 215, 198, 24);
		add(fieldLLocal);
		fieldLLocal.setColumns(10);

		fieldIntensidade = new JTextField();
		fieldIntensidade.setBounds(398, 256, 198, 24);
		add(fieldIntensidade);
		fieldIntensidade.setColumns(10);
		
		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException ignore) {
			//
		}
		if (mascaraData != null) {
			mascaraData.setPlaceholderCharacter('_');
		}
		fieldData = new JFormattedTextField(mascaraData);
		labelData.setLabelFor(fieldData);
		fieldData.setBounds(398, 290, 198, 24);
		add(fieldData);

		
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldIntensidade() {
		return fieldIntensidade;
	}
	

	public JFormattedTextField getFieldLData() {
		return fieldData;
	}
	
	public JTextField getFieldLocal() {
		return fieldLLocal;
	}


	

	public NovoSintomaFisicoControl getController() {
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
