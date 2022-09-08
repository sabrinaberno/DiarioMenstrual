package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;


import controller.ControllerDados;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Tela de menu.
 * @author Maria Abritta e Thyago Moura 
 * @version 1.0 (Abril 2022)
 */
public class TelaMenu {

	private static JFrame janela = new JFrame("Meu diário menstrual");
	private static JLabel titulo = new JLabel("O que você deseja fazer?");
	private JButton usuaria = new JButton("Usuaria");
	private static JButton ciclo = new JButton("Cadastrar novo ciclo");
	private static JButton mental = new JButton("Sintomas mentais");
	private static JButton fisico = new JButton("Sintomas físicos");
	private static JButton relatorio = new JButton("Relatório");
	public static ControllerDados dados = new ControllerDados();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu window = new TelaMenu();
					window.janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		janela = new JFrame();
		janela.setBounds(100, 100, 600, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);

		titulo.setForeground(new Color(255,92,138));
		titulo.setFont(new Font("Didot", Font.PLAIN, 35));
		titulo.setBounds(50, 25, 500, 50);
		janela.getContentPane().add(titulo);


		
		usuaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == usuaria) {
					janela.dispose();
					TelaPessoa.main(null);
				}
			}
		});
		usuaria.setBackground(new Color(255, 204, 255));
		usuaria.setFont(new Font("Cambria", Font.PLAIN, 15));
		usuaria.setBounds(162, 91, 113, 36);
		janela.getContentPane().add(usuaria);

		
		ciclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == relatorio) {
					janela.dispose();
					TelaCiclo.main(null);
				}
			}
		});
		ciclo.setFont(new Font("Cambria", Font.PLAIN, 15));
		ciclo.setBackground(new Color(204, 204, 255));
		ciclo.setBounds(162, 185, 113, 36);
		janela.getContentPane().add(relatorio);

		
		mental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == mental) {
					new TelaSintoma().mostrarDados(dados, 1);
				}
			}
		});
		mental.setFont(new Font("Cambria", Font.PLAIN, 15));
		mental.setBackground(new Color(255, 255, 204));
		mental.setBounds(162, 230, 113, 36);
		janela.getContentPane().add(mental);

		
		fisico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == fisico) {
					new TelaSintoma().mostrarDados(dados, 2);
				}
			}
		});
		fisico.setFont(new Font("Cambria", Font.PLAIN, 15));
		fisico.setBackground(new Color(204, 255, 255));
		fisico.setBounds(162, 138, 113, 36);
		janela.getContentPane().add(fisico);
	}

}
