package view;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.ControllerCiclo;
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
public class TelaRelatorio extends PadraoRelatorio {

	private static final long serialVersionUID = -4020189813495152570L;
	private JComboBox<Object> fieldCiclo;
	private JTextArea fieldRelatorio;
	private ControllerCiclo controller;
	private JScrollPane scrollPane;

	/**
	 * Cria o panel com os campos para o relatorio.
	 */
	public TelaRelatorio() {
		super("Relatorio de cilos");

		controller = new ControllerCiclo(this);

		JLabel lblNewLabel = new JLabel("Escolha o ciclo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(Padrao.FONT);
		lblNewLabel.setBounds(49, 135, 162, 21);
		add(lblNewLabel);

		fieldCiclo = new JComboBox<>();
		fieldCiclo.addActionListener(this);
		fieldCiclo.setBounds(71, 168, 113, 21);
		add(fieldCiclo);

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

	public JComboBox<Object> getFieldCiclo() {
		return fieldCiclo;
	}

	public JTextArea getFieldRelatorio() {
		return fieldRelatorio;
	}

	public ControlllerCiclo getController() {
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