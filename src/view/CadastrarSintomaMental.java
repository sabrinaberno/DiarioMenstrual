package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JComboBox;

import model.Sintoma.Intensidade;


public class CadastrarSintomaMental extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel painel = new JPanel();
	private static JFrame janela = new JFrame("Sintoma Mental");
	private static JLabel titulo = new JLabel("Cadastro de Sintoma Mental");
	private JComboBox <Intensidade> sintoma = new JComboBox<>();
	private JButton cadastrar = new JButton("Cadastrar Ciclo");
	private JLabel dataInicial = new JLabel("Data do início do ciclo :");
	//private JFormattedTextField dataInicialInput = new JFormattedTextField(new MaskFormatter("##/##/####"));
	private JLabel dataFinal = new JLabel("Data do fim da menstruação :");
	//private JFormattedTextField dataFinalInput = new JFormattedTextField(new MaskFormatter("##/##/####"));
	
	public CadastrarSintomaMental () {
		
		janela.setBounds(100, 100, 600, 600);
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(new BorderLayout(0, 0));
		setContentPane(painel);
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(new BorderLayout(0, 0));

		titulo.setBounds(50, 0, 500, 50);
		sintoma.setBounds(50, 100, 400, 100);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		sintoma.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		sintoma.setModel(new DefaultComboBoxModel<>(Intensidade.values()));
		
		cadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cadastrar.setBounds(50, 450, 200, 50);

		dataInicial.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		dataInicial.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		
		janela.setLayout(null);
		janela.setVisible(true);
		
		
		janela.add(titulo);
		janela.add(sintoma);
		janela.add(cadastrar);
		janela.add(dataInicial);
		//janela.add(dataInicialInput);
		janela.add(dataFinal);
		//janela.add(dataFinalInput);
		
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}





}
