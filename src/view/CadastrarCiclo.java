package view;

import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import control.CadastrarCicloControl;



/**
 *  Tela para cadastrar o ciclo do usuário
 * 
 * @author Mylena e Sabrina
 * @since 2022
 * @version 1.0
 * 
 */

public class CadastrarCiclo extends JCampos {
	private static final long serialVersionUID = -7309653702183828956L;
	private JComboBox<Object> fieldPessoa;
	private JTextField fieldNumero;
	private JTextField fieldDuracao;	
	private JFormattedTextField fiedlDataFinal;
	private JFormattedTextField fieldDataInicio;
	private CadastrarCicloControl controller;

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	public CadastrarCiclo() {
		super("Cadastre um novo ciclo");

		controller = new CadastrarCicloControl(this);

		JLabel labelNome = new JLabel("Número do ciclo:");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setFont(JCampos.FONT);
		labelNome.setBounds(169, 172, 175, 13);
		add(labelNome);

		JLabel labelInicio = new JLabel("Data início menstruação:");
		labelInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		labelInicio.setFont(JCampos.FONT);
		labelInicio.setBounds(169, 204, 175, 13);
		add(labelInicio);

		JLabel labelDuracao = new JLabel("Duração:");
		labelDuracao.setFont(JCampos.FONT);
		labelDuracao.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDuracao.setBounds(169, 236, 175, 13);
		add(labelDuracao);
		
		JLabel labelFinal = new JLabel("Data final menstruação:");
		labelFinal.setFont(JCampos.FONT);
		labelFinal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFinal.setBounds(169, 268, 175, 13);
		add(labelFinal);

		

		fieldNumero = new JTextField();
		fieldNumero.setBounds(405, 169, 147, 19);
		add(fieldNumero);
		fieldNumero.setColumns(10);

		fieldPessoa = new JComboBox<>();
		labelNome.setLabelFor(fieldPessoa);
		fieldPessoa.setBounds(405, 200, 147, 21);
		fieldPessoa.setModel(controller.atualizarModelo());
		add(fieldPessoa);

		fieldDuracao = new JTextField();
		labelDuracao.setLabelFor(fieldDuracao);
		fieldDuracao.setBounds(405, 236, 147, 19);
		add(fieldDuracao);
		fieldDuracao.setColumns(10);

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException ignore) {
			//
		}
		if (mascaraData != null) {
			mascaraData.setPlaceholderCharacter('_');
		}
		
		fieldDataInicio = new JFormattedTextField(mascaraData);
		labelInicio.setLabelFor(fieldDataInicio);
		fieldDataInicio.setBounds(405, 272, 147, 19);
		add(fieldDataInicio);
		
		fiedlDataFinal = new JFormattedTextField(mascaraData);
		labelFinal.setLabelFor(fiedlDataFinal);
		fiedlDataFinal.setBounds(405, 308, 147, 19);
		add(fiedlDataFinal);


	}		


	public JComboBox<Object> getFieldPessoa() {
		return fieldPessoa;
	}

	public JTextField getFieldNome() {
		return fieldNumero;
	}

	public JTextField getFieldDuracao() {
		return fieldDuracao;
	}
	
	public JFormattedTextField getFieldDataFinal() {
		return fiedlDataFinal;

	}



	public JFormattedTextField getFieldDataInicio() {
		return fieldDataInicio;

	}
	

	public CadastrarCicloControl getController() {
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