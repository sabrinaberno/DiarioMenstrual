package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ControllerCiclo;



/**
 * JPanel para cadastrar um estúdio.
 * 
 * Herda a classe JCampos que contém um fundo, título e dois botões.
 * 
 * @author Eduardo Rodrigues
 */
public class TelaCiclo extends Padrao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField numero;
	private JTextField duracao;
	private JFormattedTextField dataInicioMenstruacao;
	private JFormattedTextField dataFinalMenstruacao;
	private ControllerCiclo controller;

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	
private JFrame janela;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCiclo window = new TelaCiclo();
					window.janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TelaCiclo() {
		super("Cadastre um novo ciclo");

		controller = new ControllerCiclo(this);

		JLabel labelNumero = new JLabel("Número do ciclo:");
		labelNumero.setFont(Padrao.FONT);
		labelNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNumero.setBounds(169, 195, 175, 13);
		add(labelNumero);

		JLabel labelDuracao = new JLabel("Duracão média dos seus ciclos:");
		labelDuracao.setFont(Padrao.FONT);
		labelDuracao.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDuracao.setBounds(169, 243, 175, 13);
		add(labelDuracao);

		JLabel labelInicial = new JLabel("Data do inicio da menstruação:");
		labelInicial.setFont(Padrao.FONT);
		labelInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		labelInicial.setBounds(158, 297, 186, 13);
		add(labelInicial);

		JLabel labelFinal = new JLabel("Data do inicio da menstruação:");
		labelFinal.setFont(Padrao.FONT);
		labelFinal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFinal.setBounds(82, 343, 262, 13);
		add(labelFinal);

		numero = new JTextField();
		labelNumero.setLabelFor(numero);
		numero.setBounds(405, 192, 147, 19);
		add(numero);
		numero.setColumns(10);

		duracao = new JTextField();
		labelDuracao.setLabelFor(duracao);
		duracao.setBounds(405, 240, 147, 19);
		add(duracao);
		duracao.setColumns(10);

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException ignore) {
			//
		}
		if (mascaraData != null) {
			mascaraData.setPlaceholderCharacter('_');
		}
		dataInicioMenstruacao = new JFormattedTextField(mascaraData);
		labelInicial.setLabelFor(dataInicioMenstruacao);
		dataInicioMenstruacao.setBounds(405, 294, 147, 19);
		add(dataInicioMenstruacao);
		
		dataFinalMenstruacao = new JFormattedTextField(mascaraData);
		labelFinal.setLabelFor(dataFinalMenstruacao);
		dataFinalMenstruacao.setBounds(405, 294, 147, 19);
		add(dataFinalMenstruacao);

		
	}

	public JTextField getNumero() {
		return numero;
	}

	

	public JTextField getDuracao() {
		return duracao;
	}

	

	public JFormattedTextField getDataInicioMenstruacao() {
		return dataInicioMenstruacao;
	}

	

	public JFormattedTextField getDataFinalMenstruacao() {
		return dataFinalMenstruacao;
	}

	
	public ControllerCiclo getController() {
		return controller;
	}

	/**
	 * Executa o comando para o botão selecionado.
	 * 
	 * implementação da interface ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}
}