package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JComponent;

import model.Sintoma_fisico.Local_corpo;
import model.Sintoma_fisico.Nome_sintoma_fisico;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;


public class TelaInicial extends JFrame implements ActionListener {

		private static JFrame janela = new JFrame("Meu Diário Menstrual");
		private static JLabel titulo = new JLabel("Escolha qual ação você deseja executar");
		private static JButton cadastro_usuario = new JButton("Cadastrar Pessoa");
		private static JButton cadastro_ciclo = new JButton("Cadastrar novo Ciclo Menstrual");
		private static JButton cadastro_sintoma_fisico = new JButton("Cadastrar um Sintoma Físico");
		private static JButton cadastro_sintoma_mental = new JButton("Cadastrar um Sintoma Mental");
		private static JButton relatorio = new JButton("Relatórios");

	//	public static ControleDados dados = new ControleDados();
	 
		private JPanel pane;

		
		public TelaInicial() {
				
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//janela.setSize(400, 250);
			
			janela.setBounds(100, 100, 600, 600);
			titulo.setBounds(50, 0, 500, 50);

			//janela.setContentPane(pane);	
			pane = new JPanel (); 
			pane.setBorder(new EmptyBorder(5, 5, 5, 5));
			pane.setLayout(new BorderLayout(0, 0));

			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(cadastro_usuario);
			janela.add(cadastro_ciclo);
			janela.add(cadastro_sintoma_fisico);
			janela.add(cadastro_sintoma_mental);
			janela.add(relatorio);

			janela.setVisible(true);
			
			
			cadastro_usuario.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_usuario.setBounds(50, 70, 500, 50);
			
			cadastro_ciclo.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_ciclo.setBounds(50, 150, 500, 50);
			
			cadastro_sintoma_fisico.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_sintoma_fisico.setBounds(50, 230, 500, 50);
			
			cadastro_sintoma_mental.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_sintoma_mental.setBounds(50, 310, 500, 50);
			
			relatorio.setFont(new Font("Arial", Font.PLAIN, 20));
			relatorio.setBounds(50, 390, 500, 50);
			
			
		}
		
		
		public static void main(String[] args) {
			TelaInicial menu = new TelaInicial();
			
						
			cadastro_usuario.addActionListener(menu);
			cadastro_ciclo.addActionListener(menu);
			cadastro_sintoma_fisico.addActionListener(menu);
			cadastro_sintoma_mental.addActionListener(menu);
			relatorio.addActionListener(menu);
		}

		public void actionPerformed(ActionEvent e) {
			Object click = e.getSource();
			
			if(click == cadastro_usuario)
				new CadastrarPessoa();
			
			if(click == cadastro_ciclo)
				new CadastrarCiclo();
			
			if(click == cadastro_sintoma_fisico)
				new CadastrarSintomaFisico();
			
			if(click == cadastro_sintoma_mental)
				new CadastrarSintomaMental();
			
			if(click == relatorio)
				new TelaRelatorio();
		
		}
		
		
		
						
			
	}
	/*
	
	// listando os locais do corpo
			System.out.println("Locais do corpo:");
			for(Local_corpo locais: Local_corpo.values()){
				System.out.println(locais);
			}
		
			System.out.println("Digite o local do corpo para cadastrar um sintoma fisico:");
			Scanner corpo = new Scanner(System.in);

			//listando os nomes das dores fisicas
			System.out.println("\n Nome bla bla bla");
			for(Nome_sintoma_fisico nome_fisico : Nome_sintoma_fisico.values()){
				System.out.println(nome_fisico);
			}
	private final HomeController controller;

	public Home() {
		super("My Home Page");
		this.controller = new HomeController(this);

		this.setSize(900, 700);
		this.setLayout(new GridLayout(3, 2));

		this.labelLogin = new JLabel("Login:");
		this.add(this.labelLogin);

		this.fieldLogin = new JTextField();
		this.add(this.fieldLogin);
		
		this.labelSenha = new JLabel("Senha:");
		this.add(this.labelSenha);

		this.fieldSenha = new JTextField();
		this.add(this.fieldSenha);

		this.cadastrar = new JButton("Cadastrar");
		this.cadastrar.addActionListener(this);
		this.add(this.cadastrar);

		this.cancelar = new JButton("Cancelar");
		this.cancelar.addActionListener(this);
		this.add(this.cancelar);
	}

	*/

