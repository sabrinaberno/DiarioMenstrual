package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import control.RelatorioControl;

import javax.swing.JScrollPane;
import java.awt.Font;

/**
 *  Tela que mostra o relatório os ciclos e seus sintomas 
 * 
 * @author Mylena e Sabrina 
 * @since 2022
 * @version 1.0 
 */

public class Relatorio implements ActionListener {
	
	private JButton buttonVoltar;	
	private static JTextArea fieldRelatorio= new JTextArea();
	private RelatorioControl controller;
	private JScrollPane scrollPane= new JScrollPane();
	JLabel lblCiclo = new JLabel("Escolha o ciclo");
	private JFrame janela;
	JLabel titulo = new JLabel("Relatório");
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio window = new Relatorio();
					window.janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Cria o panel com os campos para o relatorio.
	 */
	public Relatorio() {
		

		controller = new RelatorioControl();
		
		janela = new JFrame();
		janela.setBounds(45, 15, 1000, 800);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);
		
		titulo.setForeground(new Color(227,99,151));
		titulo.setFont(new Font("Digot", Font.BOLD, 50));
		titulo.setBounds(380, 45, 600, 50);
		janela.getContentPane().add(titulo);	
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.black);
		scrollPane.setBounds(150, 150, 700, 500);
		janela.add(scrollPane);

		fieldRelatorio = new JTextArea(50,50);
		fieldRelatorio.setFont(new Font("Digot", Font.PLAIN, 12));
		scrollPane.setViewportView(fieldRelatorio);
		fieldRelatorio.setBorder(new LineBorder(new Color(21,21,40), 3));
		fieldRelatorio.setBackground(new Color(253,238,245));
		
		buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(this);
		buttonVoltar.setForeground(Color.BLACK);
		buttonVoltar.setBorder(BorderFactory.createLineBorder(new Color(1,22,39), 1));
		buttonVoltar.setBackground(new Color(188,224,253));
		buttonVoltar.setFont(new Font("Digot", Font.BOLD, 20));
		buttonVoltar.setBounds(450, 700, 100, 45);
		janela.add(buttonVoltar); 
		
	
		
		
		
	}

	

	public static JTextArea getFieldRelatorio() {
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
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	public  JButton getButtonVoltar() {
		return buttonVoltar;
	}




	
}
