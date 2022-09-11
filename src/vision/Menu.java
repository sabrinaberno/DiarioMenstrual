package vision;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.MenuControl;

import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * JPanel de menu.
 * 
 * @author Eduardo Rodrigues
 */
public class Menu extends JPanel implements ActionListener {
	private static final long serialVersionUID = -6180976424149762050L;
	private final JButton buttonRegistrarPessoa;
	private final JButton buttonMostrarRelatorio;	
	private JButton buttonAdicionarCiclo;
	private final JButton buttonAdicionarFisicos;
	private final MenuControl controller;

	/**
	 * Cria o painel com um fundo e v�rios bot�es e textos.
	 */
	public Menu() {
		controller = new MenuControl(this);

		setBackground(new Color(245, 245, 220));
		setBounds(100, 100, 830, 522);
		setLayout(null);

		buttonAdicionarCiclo = new JButton("Adicionar ciclos a pessoa");
		buttonAdicionarCiclo.setEnabled(false);
		buttonAdicionarCiclo.setBackground(Color.LIGHT_GRAY);
		buttonAdicionarCiclo.setForeground(Color.BLACK);
		buttonAdicionarCiclo.setFont(JCampos.FONT);
		buttonAdicionarCiclo.setBounds(280, 213, 267, 31);
		buttonAdicionarCiclo.addActionListener(this);
		add(buttonAdicionarCiclo);

		buttonMostrarRelatorio = new JButton("Mostrar relatório");
		buttonMostrarRelatorio.setEnabled(false);
		buttonMostrarRelatorio.setForeground(Color.BLACK);
		buttonMostrarRelatorio.setBackground(Color.LIGHT_GRAY);
		buttonMostrarRelatorio.setFont(JCampos.FONT);
		buttonMostrarRelatorio.setBounds(280, 254, 267, 31);
		buttonMostrarRelatorio.addActionListener(this);
		add(buttonMostrarRelatorio);

		buttonAdicionarCiclo = new JButton("Adicionar ciclo");
		buttonAdicionarCiclo.setEnabled(false);
		buttonAdicionarCiclo.setFont(JCampos.FONT);
		buttonAdicionarCiclo.setBackground(Color.LIGHT_GRAY);
		buttonAdicionarCiclo.setForeground(Color.BLACK);
		buttonAdicionarCiclo.setBounds(280, 295, 267, 31);
		buttonAdicionarCiclo.addActionListener(this);
		add(buttonAdicionarCiclo);

		buttonAdicionarFisicos = new JButton("Adicionar sintoma mental");
		buttonAdicionarFisicos.setEnabled(false);
		buttonAdicionarFisicos.setFont(JCampos.FONT);
		buttonAdicionarFisicos.setBackground(Color.LIGHT_GRAY);
		buttonAdicionarFisicos.setForeground(Color.BLACK);
		buttonAdicionarFisicos.setBounds(280, 336, 267, 31);
		buttonAdicionarFisicos.addActionListener(this);
		add(buttonAdicionarFisicos);

	

		buttonRegistrarPessoa = new JButton("Registrar nova pessoa");
		buttonRegistrarPessoa.setFont(JCampos.FONT);
		buttonRegistrarPessoa.setForeground(Color.BLACK);
		buttonRegistrarPessoa.setBackground(Color.LIGHT_GRAY);
		buttonRegistrarPessoa.setBounds(280, 166, 267, 37);
		buttonRegistrarPessoa.addActionListener(this);
		add(buttonRegistrarPessoa);

		JLabel labelMenu = new JLabel("Menu");
		labelMenu.setHorizontalAlignment(SwingConstants.TRAILING);
		labelMenu.setForeground(Color.BLACK);
		labelMenu.setFont(new Font("Algerian", Font.BOLD, 50));
		labelMenu.setBounds(21, 227, 144, 69);
		add(labelMenu);

		JLabel labelIconMask = new JLabel("");
		labelIconMask.setBounds(228, 0, 217, 145);
		labelIconMask.setIcon(new ImageIcon(Menu.class.getResource("/vision/images/iconMask.png")));
		add(labelIconMask);

		JLabel labelIconMenu = new JLabel("");
		labelIconMenu.setBounds(0, 0, 209, 522);
		labelIconMenu.setIcon(new ImageIcon(Menu.class.getResource("/vision/images/fundo.png")));
		add(labelIconMenu);

		JLabel labelTitulo = new JLabel("Diário menstrual");
		labelTitulo.setFont(new Font("Algerian", Font.PLAIN, 35));
		labelTitulo.setBounds(455, 60, 325, 47);
		add(labelTitulo);

		JLabel labelIconUNB = new JLabel("");
		labelIconUNB.setBounds(680, 382, 100, 69);
		labelIconUNB.setIcon(new ImageIcon(Menu.class.getResource("/vision/images/iconUnb.png")));
		add(labelIconUNB);

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

	public JButton getButtonAdicionarCiclo() {
		return buttonAdicionarCiclo;
	}
	

	public JButton getButtonMostrarRelatorio() {
		return buttonMostrarRelatorio;
	}

	public JButton getButtonAdicionarFisicos() {
		return buttonAdicionarFisicos;
	}

	public JButton getButtonRegistrarPessoa() {
		return  buttonRegistrarPessoa;
	}
	

	public MenuControl getController() {
		return controller;
	}
}