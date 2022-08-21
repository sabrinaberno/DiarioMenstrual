package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class TelaInicial extends JFrame implements ActionListener {
	
		private static JFrame janela = new JFrame("Meu Diário Menstrual");
		private static JLabel titulo = new JLabel("O que você deseja fazer?");
		private static JButton cadastro_usuario = new JButton("Cadastrar Pessoa");
		private static JButton cadastro_ciclo = new JButton("Cadastrar novo Ciclo Menstrual");
		private static JButton cadastro_sintoma_fisico = new JButton("Cadastrar um Sintoma Físico");
		private static JButton cadastro_sintoma_mental = new JButton("Cadastrar um Sintoma Mental");
		private static JButton relatorio = new JButton("Diários");
		private JPanel painel = new JPanel (); 
		private JLabel fundo = new JLabel ("");

	//	public static ControleDados dados = new ControleDados();
	 
		private static final long serialVersionUID = 1L;

		
		public TelaInicial() {	
			
			
			fundo.setBounds(680, 382, 100, 69);
			fundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/view/imagens/back.png")));
			add(fundo);
			
			setBackground(new Color(245, 245, 220));
			setBounds(100, 100, 830, 522);
			setLayout(null);
			
				
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//janela.setSize(400, 250);
			
			janela.setBounds(100, 100, 600, 600);
			titulo.setBounds(50, 0, 500, 50);

			//janela.setContentPane(pane);	
			painel.setBorder(new EmptyBorder(5, 5, 5, 5));
			painel.setLayout(new BorderLayout(0, 0));

			
			titulo.setFont(new Font("Arial", Font.BOLD, 22));
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
			cadastro_usuario.setBackground(Color.orange);
			cadastro_usuario.setForeground(Color.BLACK);
			cadastro_usuario.setBounds(50, 70, 500, 50);
			
			cadastro_ciclo.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_ciclo.setBackground(Color.yellow);
			cadastro_ciclo.setForeground(Color.BLACK);
			cadastro_ciclo.setBounds(50, 150, 500, 50);
			
			cadastro_sintoma_fisico.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_sintoma_fisico.setBackground(Color.green);
			cadastro_sintoma_fisico.setForeground(Color.BLACK);
			cadastro_sintoma_fisico.setBounds(50, 230, 500, 50);
			
			cadastro_sintoma_mental.setFont(new Font("Arial", Font.PLAIN, 20));
			cadastro_sintoma_mental.setBackground(Color.blue);
			cadastro_sintoma_mental.setForeground(Color.white);			
			cadastro_sintoma_mental.setBounds(50, 310, 500, 50);
			
			relatorio.setFont(new Font("Arial", Font.PLAIN, 20));
			relatorio.setBackground(Color.red);
			relatorio.setForeground(Color.white);			
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

			if(click == cadastro_usuario) {
				new CadastrarPessoa();
				janela.setVisible(false);
			}
				
			
			if(click == cadastro_ciclo) {
				new CadastrarCiclo();
				janela.setVisible(false);
			}
				
			
			if(click == cadastro_sintoma_fisico) {
				new CadastrarSintomaFisico();
				janela.setVisible(false);
			}
				
			
			if(click == cadastro_sintoma_mental) {
				new CadastrarSintomaMental();
				janela.setVisible(false);
			}
				
			
			if(click == relatorio) {
				new TelaDiario();
				janela.setVisible(false);
			}
				
		
		}
		
		
		
						
			
	}
