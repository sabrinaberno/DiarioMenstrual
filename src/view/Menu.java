package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import controller.*;

/**
 * Tela principal, onde o usuário poderá selecionar qual ação ele deseja realizar dentro do aplicativo
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 
 */

public class Menu implements ActionListener {
	
	private static JFrame janela = new JFrame("Meu diário menstrual");
	private static JLabel titulo = new JLabel("O que você deseja fazer?");
	private static JButton pessoa = new JButton("Cadastrar pessoa");
	private static JButton ciclo = new JButton("Ciclos");
	private static JButton mental = new JButton("Sintomas mentais");
	private static JButton fisico = new JButton("Sintomas físicos");
	public static ControleDados dados = new ControleDados();
	private JPanel painel = new JPanel (); 
	
		
	public Menu() {

		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		janela.setBounds(100, 100, 600, 600);
		titulo.setBounds(145, 0, 500, 50);	
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(new BorderLayout(0, 0));

		
		titulo.setFont(new Font("Arial", Font.BOLD, 22));
		
		
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		janela.add(titulo);
		janela.add(pessoa);
		janela.add(ciclo);
		janela.add(fisico);
		janela.add(mental);
		
		
		pessoa.setFont(new Font("Arial", Font.PLAIN, 20));
		pessoa.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));		
		pessoa.setOpaque(true);
		pessoa.setBackground(new Color(205, 180, 219));
		pessoa.setForeground(Color.BLACK);
		pessoa.setBounds(50, 70, 500, 50);
		
		ciclo.setFont(new Font("Arial", Font.PLAIN, 20));
		ciclo.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
		ciclo.setOpaque(true);
		ciclo.setBackground(new Color(255, 200, 221));
		ciclo.setForeground(Color.BLACK);
		ciclo.setBounds(50, 150, 500, 50);
		
		fisico.setFont(new Font("Arial", Font.PLAIN, 20));
		fisico.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
		fisico.setOpaque(true);
		fisico.setBackground(new Color(255, 175, 204));
		fisico.setForeground(Color.BLACK);
		fisico.setBounds(50, 230, 500, 50);
		
		mental.setFont(new Font("Arial", Font.PLAIN, 20));
		mental.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
		ciclo.setOpaque(true);
		mental.setBackground(new Color(189, 224, 254));
		mental.setForeground(Color.BLACK);			
		mental.setBounds(50, 310, 500, 50);
		
		
		

		}
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		
		pessoa.addActionListener(menu);
		ciclo.addActionListener(menu);
		fisico.addActionListener(menu);
		mental.addActionListener(menu);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();	
		
		if(src == mental)
			new TelaMental().mostrarDados(dados, 1);
		
		if(src == fisico)
			new TelaFisico().mostrarDados(dados, 2);
		
		if(src == pessoa) {
			new CadastrarPessoa().setVisible(false);
			}
		if(src == ciclo) {
			new TelaCiclo().mostrarDados(dados, 3);
			}
		
		
	
		
		
		
		
			
		}
		}
	





		
		

		