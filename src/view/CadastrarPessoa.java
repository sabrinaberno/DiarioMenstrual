package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControleDados;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Página de cadastro de Pessoa, a qual deve constar nome e data de nascimento.
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 */

public class CadastrarPessoa extends JFrame implements ActionListener {	
	
		private static final long serialVersionUID = 1L;
		
		private JPanel painel = new JPanel();
		private static JFrame janela = new JFrame("Pessoa");
		private static JLabel titulo = new JLabel("Cadastro de Pessoa");		
		private JButton cadastrar = new JButton("Cadastrar");
		private JButton cancelar = new JButton("Cancelar");
		private JLabel nomeTxt = new JLabel("Qual o seu nome? ");		
			JTextField nome = new JTextField();
		private JLabel dtNascimentoTxt = new JLabel("Qual a sua data de nascimento? ");
			JTextField dtNascimento = new JTextField();
		public static ControleDados dados= new ControleDados();

		public CadastrarPessoa ()
		{
			
			janela.setBounds(100, 100, 600, 600);
			painel.setBorder(new EmptyBorder(5, 5, 5, 5));
			painel.setLayout(new BorderLayout(0, 0));
			setContentPane(painel);
			painel.setBorder(new EmptyBorder(5, 5, 5, 5));
			painel.setLayout(new BorderLayout(0, 0));
					

			titulo.setFont(new Font("Arial", Font.BOLD, 22));
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			titulo.setBounds(50, 0, 500, 50);
			janela.add(titulo);
			
			
			nomeTxt.setFont(new Font("DIALOG_INPUT", Font.PLAIN, 18));
			nomeTxt.setBounds(50, 130, 400, 20);
			nome.setBounds(50, 180, 500, 30);
			nome.setColumns(10);
			janela.add(nome);
			janela.add(nomeTxt);
			
			dtNascimentoTxt.setFont(new Font("DIALOG_INPUT", Font.PLAIN, 18));
			dtNascimentoTxt.setBounds(50, 290, 400, 20);
			dtNascimento.setBounds(50, 340, 500, 30);
			dtNascimento.setColumns(10);
			janela.add(dtNascimento);
			janela.add(dtNascimentoTxt);
			
			
			
			cadastrar.setFont(new Font("DIALOG_INPUT", Font.PLAIN, 18));
			cadastrar.setBackground(Color.pink);
			cadastrar.setForeground(Color.BLACK);
			cadastrar.setBounds(50, 480, 240, 50);
			janela.add(cadastrar);
			
			cancelar.setFont(new Font("DIALOG_INPUT", Font.PLAIN, 18));
			cancelar.setBackground(new Color (255, 246, 249));
			cancelar.setForeground(Color.BLACK);
			cancelar.setBounds(310, 480, 240, 50);
			janela.add(cancelar);
			
			
			janela.setLayout(null);
			janela.setVisible(true);
			
			cadastrar.addActionListener(this);
			cancelar.addActionListener(this);
		}
		
		
		public void actionPerformed(ActionEvent e) {
			Object click = e.getSource();

			if(click == cadastrar) {
				new Menu();
			} 
			
			if(click == cancelar) {
				new Menu();
				janela.setVisible(false);
			}
				
		}

    }