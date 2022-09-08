package view;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.ControllerRelatorio;

import javax.swing.JScrollPane;
import java.awt.Font;

/**
 * JPanel para mostrar um relatorio de filmes.
 * 
 * Herda a classe JRelatorios que contém um fundo, título e um botão.
 * 
 * @author Eduardo Rodrigues
 */
public class TelaRelatorio  {
	
	
	private JButton buttonVoltar;
	private JComboBox<Object> fieldCiclos;
	private JTextArea fieldRelatorio;
	private ControllerRelatorio controller;
	private JScrollPane scrollPane;

	/**
	 * Cria o panel com os campos para o relatorio.
	 */
	public TelaRelatorio() {
		

		controller = new ControllerRelatorio();
		

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(this);
		buttonVoltar.setForeground(new Color(153, 0, 0));
		buttonVoltar.setBackground(Color.LIGHT_GRAY);
		buttonVoltar.setFont(JCampos.FONT);
		buttonVoltar.setBounds(657, 428, 119, 21);
		add(buttonVoltar);

		JLabel labelFundo = new JLabel("");
		labelFundo.setBounds(0, 0, 830, 522);
		labelFundo.setIcon(new ImageIcon(JRelatorios.class.getResource("/vision/images/iconScreen.png")));
		add(labelFundo);

		JLabel lblNewLabel = new JLabel("Escolha o ciclo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(49, 135, 162, 21);
		add(lblNewLabel);

		fieldEstudio = new JComboBox<>();
		fieldEstudio.addActionListener(this);
		fieldEstudio.setBounds(71, 168, 113, 21);
		add(fieldEstudio);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 109, 512, 295);
		add(scrollPane);

		fieldRelatorio = new JTextArea();
		fieldRelatorio.setFont(new Font("Algerian", Font.PLAIN, 12));
		scrollPane.setViewportView(fieldRelatorio);
		fieldRelatorio.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		fieldRelatorio.setBackground(new Color(245, 245, 220));
		fieldRelatorio.setEditable(false);
	}

	public JComboBox<Object> getFieldEstudio() {
		return fieldEstudio;
	}

	public JTextArea getFieldRelatorio() {
		return fieldRelatorio;
	}

	public RelatorioFilmesControl getController() {
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