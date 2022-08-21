package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import model.Sintoma.Intensidade;
import model.SintomaMental.NomeSintomaMental;


public class CadastrarSintomaMental extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel painel = new JPanel();
	private static JFrame janela = new JFrame("Sintoma Mental");
	private static JLabel titulo = new JLabel("Cadastro de Sintoma Mental");
	private JComboBox <Intensidade> intensidade = new JComboBox<>();
	private JComboBox <NomeSintomaMental> nomeSintoma = new JComboBox<>();
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton cancelar = new JButton("Cancelar");
	private JLabel dataTxt = new JLabel("Data do sintoma mental (Ex: 15/02/2022): ");
	//private JFormattedTextField dataInicialInput = new JFormattedTextField(new MaskFormatter("##/##/####"));
	JTextField data = new JTextField();
	private JLabel nomeTxt = new JLabel("Selecione o seu sintoma: ");
	private JLabel intensidadeTxt = new JLabel("Selecione a intensidade do seu sintoma: ");

	public CadastrarSintomaMental ()
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
		
		
		dataTxt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		dataTxt.setBounds(50, 80, 400, 20);
		data.setBounds(50, 120, 500, 30);
		data.setColumns(10);
		janela.add(data);
		janela.add(dataTxt);
		
		
		nomeTxt.setFont(new Font("DIALOG_INPUT", Font.PLAIN, 18));
		nomeTxt.setBounds(50, 180, 400, 20);		
		nomeSintoma.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		nomeSintoma.setModel(new DefaultComboBoxModel<>(NomeSintomaMental.values()));
		nomeSintoma.setBounds(50, 210, 500, 30);
		janela.add(nomeTxt);
		janela.add(nomeSintoma); 
		
		
		intensidadeTxt.setFont(new Font("DIALOG_INPUT", Font.PLAIN, 18));
		intensidadeTxt.setBounds(50, 280, 400, 20);
		intensidade.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		intensidade.setModel(new DefaultComboBoxModel<>(Intensidade.values()));
		intensidade.setBounds(50, 310, 500, 30);
		janela.add(intensidadeTxt);
		janela.add(intensidade);
		
		
		cadastrar.setFont(new Font("DIALOG_INPUT", Font.PLAIN, 18));
		cadastrar.setBackground(Color.pink);
		cadastrar.setForeground(Color.BLACK);
		cadastrar.setBounds(50, 480, 240, 50);
		janela.add(cadastrar);
		
		cancelar.setFont(new Font("DIALOG_INPUT", Font.PLAIN, 18));
		cancelar.setBackground(Color.lightGray);
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
			new TelaInicial();
			janela.setVisible(false);
		} 
		
		if(click == cancelar) {
			new TelaInicial();
			janela.setVisible(false);
		}
			
	}





}
