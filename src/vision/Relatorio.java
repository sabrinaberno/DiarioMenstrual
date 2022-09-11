package vision;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import control.RelatorioControl;

import javax.swing.JScrollPane;
import java.awt.Font;

/**
 * JPanel para mostrar um relatorio de filmes.
 * 
 * Herda a classe JRelatorios que cont�m um fundo, t�tulo e um bot�o.
 * 
 * @author Eduardo Rodrigues
 */
public class Relatorio extends JRelatorios {

	private static final long serialVersionUID = -4020189813495152570L;
	private JComboBox<Object> fieldPessoa;
	private JTextArea fieldRelatorio;
	private RelatorioControl controller;
	private JScrollPane scrollPane;

	/**
	 * Cria o panel com os campos para o relatorio.
	 */
	public Relatorio() {
		super("Relatorio de filmes");

		controller = new RelatorioControl(this);

		JLabel lblNewLabel = new JLabel("Escolha a pessoa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(JCampos.FONT);
		lblNewLabel.setBounds(49, 135, 162, 21);
		add(lblNewLabel);

		fieldPessoa = new JComboBox<>();
		fieldPessoa.addActionListener(this);
		fieldPessoa.setBounds(71, 168, 113, 21);
		add(fieldPessoa);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 109, 512, 295);
		add(scrollPane);

		fieldRelatorio = new JTextArea();
		fieldRelatorio.setFont(new Font("Digot", Font.PLAIN, 12));
		scrollPane.setViewportView(fieldRelatorio);
		fieldRelatorio.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		fieldRelatorio.setBackground(new Color(245, 245, 220));
		fieldRelatorio.setEditable(false);
	}

	public JComboBox<Object> getFieldPessoa() {
		return fieldPessoa;
	}

	public JTextArea getFieldRelatorio() {
		return fieldRelatorio;
	}

	public RelatorioControl getController() {
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
