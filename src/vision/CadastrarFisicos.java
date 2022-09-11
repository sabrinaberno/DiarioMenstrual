package vision;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import control.CadastrarSintomaFisicoControl;

import javax.swing.JScrollPane;

/**
 * JPanel para selecionar atores para o filme.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarFisicos extends JPanel implements ActionListener {
	private static final long serialVersionUID = 3378863774624440091L;
	private JList<String> fieldSintomas;
	private JButton buttonSelecionar;
	private JButton buttonNovoSintoma;
	private JButton buttonFinalizar;
	private CadastrarSintomaFisicoControl controller;

	/**
	 * Cria o panel com uma lista com bot�o, um bot�o para cadastrar um novo ator e
	 * um bot�o para finalizar o cadastro.
	 */
	public  CadastrarFisicos () {
		controller = new CadastrarSintomaFisicoControl(this);

		setBackground(new Color(245, 245, 220));
		setLayout(null);
		setBounds(100, 100, 830, 522);

		JLabel labelTitulo = new JLabel("Quais sintomas estão no ciclo?");
		labelTitulo.setFont(JCampos.FONT);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(278, 61, 254, 13);
		add(labelTitulo);

		JLabel labelTitulo2 = new JLabel("Escolha ou Cadastre um sintoma físico");
		labelTitulo2.setFont(JCampos.FONT);
		labelTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo2.setBounds(108, 84, 602, 13);
		add(labelTitulo2);

		JLabel labelLista = new JLabel("Lista:");
		labelLista.setHorizontalAlignment(SwingConstants.CENTER);
		labelLista.setFont(JCampos.FONT);
		labelLista.setBounds(367, 114, 68, 13);
		add(labelLista);

		buttonSelecionar = new JButton("Selecionar");
		buttonSelecionar.setForeground(new Color(153, 51, 102));
		buttonSelecionar.setFont(JCampos.FONT);
		buttonSelecionar.setBackground(Color.LIGHT_GRAY);
		buttonSelecionar.setBounds(122, 429, 117, 21);
		buttonSelecionar.addActionListener(this);
		add(buttonSelecionar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 132, 588, 289);
		add(scrollPane);

		fieldSintomas = new JList<>();
		scrollPane.setViewportView(fieldSintomas);
		fieldSintomas.setModel(controller.atualizarModeloLista());
		fieldSintomas.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		fieldSintomas.setFont(JCampos.FONT);
		fieldSintomas.setForeground(Color.BLACK);
		fieldSintomas.setBackground(new Color(245, 245, 220));

		buttonNovoSintoma = new JButton("Novo sintoma");
		buttonNovoSintoma.setFont(JCampos.FONT);
		buttonNovoSintoma.setForeground(Color.BLACK);
		buttonNovoSintoma.setBackground(SystemColor.activeCaption);
		buttonNovoSintoma.setBounds(122, 463, 182, 49);
		buttonNovoSintoma.addActionListener(this);
		add(buttonNovoSintoma);

		buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setEnabled(false);
		buttonFinalizar.setForeground(new Color(153, 0, 0));
		buttonFinalizar.setFont(JCampos.FONT);
		buttonFinalizar.setBackground(Color.LIGHT_GRAY);
		buttonFinalizar.setBounds(601, 477, 107, 21);
		buttonFinalizar.addActionListener(this);
		add(buttonFinalizar);

		JLabel labelFundo = new JLabel("");
		labelFundo.setBounds(0, 0, 830, 522);
		labelFundo.setIcon(new ImageIcon(CadastrarFisicos.class.getResource("/vision/images/iconCurtain.png")));
		add(labelFundo);
	}

	public JList<String> getFieldSintomas() {
		return fieldSintomas;
	}

	public JButton getButtonSelecionar() {
		return buttonSelecionar;
	}

	public JButton getButtonNovoSintoma() {
		return buttonNovoSintoma;
	}

	public CadastrarSintomaFisicoControl getController() {
		return controller;
	}

	public JButton getButtonFinalizar() {
		return buttonFinalizar;
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