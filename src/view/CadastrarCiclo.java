package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;


import javax.swing.JButton;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;


import model.Ciclo;
	


public class CadastrarCiclo extends JFrame implements ActionListener {
		
	private static final long serialVersionUID = 1L;		
	private JPanel painel = new JPanel();
	private static JFrame janela = new JFrame("Ciclo atual");
	private static JLabel titulo = new JLabel("Cadastro de novo ciclo menstrual");
	private JButton cadastrar = new JButton("Cadastrar ciclo");
	private JButton cancelar = new JButton("Cancelar");
	private JLabel dataInicioTxt = new JLabel("Data do início da menstrução (Ex: 15/02/2022): ");
		JTextField dataInicio = new JTextField();
	private JLabel dataFinalTxt = new JLabel("Data do final da menstrução (Ex: 20/02/2022): ");
		JTextField dataFinal = new JTextField();
		//private JFormattedTextField dataInicialInput = new JFormattedTextField(new MaskFormatter("##/##/####"));
		

	public CadastrarCiclo ()
		{
			
			janela.setBounds(100, 100, 600, 600);
			painel.setBorder(new EmptyBorder(5, 5, 5, 5));
			painel.setLayout(new BorderLayout(0, 0));
			setContentPane(painel);
			painel.setBorder(new EmptyBorder(5, 5, 5, 5));
			painel.setLayout(new BorderLayout(0, 0));
					

			titulo.setFont(new Font("Arial", Font.BOLD, 18));
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			titulo.setBounds(50, 0, 500, 50);
			janela.add(titulo);
			
			
			dataInicioTxt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			dataInicioTxt.setBounds(50, 130, 400, 20);			
			dataInicio.setBounds(50, 180, 500, 30);
			dataInicio.setColumns(10);			
			janela.add(dataInicio);
			janela.add(dataInicioTxt);
			
			dataFinalTxt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			dataFinalTxt.setBounds(50, 290, 400, 20);
			dataFinal.setBounds(50, 340, 500, 30);
			dataFinal.setColumns(10);
			janela.add(dataFinal);
			janela.add(dataFinalTxt);				
			
			
			cadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			cadastrar.setBounds(50, 480, 240, 50);
			janela.add(cadastrar);		
			
			cancelar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			cancelar.setBounds(310, 480, 240, 50);
			janela.add(cancelar);
			
			
			janela.setLayout(null);
			janela.setVisible(true);
			
			
		}
		
		
		
		
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}





	}
