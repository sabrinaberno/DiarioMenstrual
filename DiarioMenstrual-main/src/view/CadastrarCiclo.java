package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import control.CadastrarCicloControl;
import model.Ciclo;
import model.Dados;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.text.ParseException;


/**
 * Tela de cadastro de ciclo.
 * @author Mylena e Sabrina 
 * @since 2022
 * @version 1.0 
 */
public class CadastrarCiclo implements ActionListener {
	
	static Ciclo cicloCadastrado;
	
	CadastrarCicloControl controller = new CadastrarCicloControl();
	private JPanel painel = new JPanel();
	private  JFrame janela = new JFrame();	
	JLabel titulo = new JLabel("Cadastrar ciclo");
	JLabel descricao = new JLabel("Insira os dados do seu ciclo abaixo ");
	JLabel txtInicio = new JLabel("Data do início da menstruação:");
	JLabel txtFinal = new JLabel("Data do final da menstruação: ");
	JLabel txtDuracao = new JLabel("Quantos dias dura em média o seu ciclo? ");
	JLabel txtDuracao2 = new JLabel("(Por duração do ciclo, compreende-se os dias entre uma menstruação e outra) ");
	JLabel txtDuracao3 = new JLabel("Caso não tenha ideia, considere que um ciclo tem duração média de 28 dias  ");
	JLabel txtNumero = new JLabel("Qual o número desse ciclo? ");
	JButton check = new JButton("Cadastrar");
	static JButton cancelar = new JButton("Cancelar");	
	JButton buscarCiclo = new JButton("Buscar Ciclo");
	public static JTextField duracao;
	public static JTextField numero;
	public static JFormattedTextField dtInicio;
	public static JFormattedTextField dtFinal;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCiclo window = new CadastrarCiclo();
					window.janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public CadastrarCiclo() {
		
		janela.setBounds(100, 100, 600, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);		
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		janela.setContentPane(painel);
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		janela.setLayout(null);
		janela.setVisible(true);


		titulo.setForeground(new Color(240,92,138));
		titulo.setFont(new Font("Didot", Font.PLAIN, 45));
		titulo.setBounds(150, 40, 600, 50);
		janela.getContentPane().add(titulo);	

		
		descricao.setForeground(Color.BLACK);
		descricao.setFont(new Font("Roboto", Font.PLAIN, 20));
		descricao.setBounds(140, 95, 400, 50);
		janela.getContentPane().add(descricao);

				
		txtInicio.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtInicio.setBounds(55, 160, 370, 30);
		janela.getContentPane().add(txtInicio);
		
		txtFinal.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFinal.setBounds(55,230, 370, 30);
		janela.getContentPane().add(txtFinal);
		
		
		txtDuracao.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtDuracao.setBounds(55, 300, 370, 30);
		janela.getContentPane().add(txtDuracao);
		
		txtDuracao2.setFont(new Font("Roboto", Font.PLAIN, 15));
		txtDuracao2.setBounds(35, 320, 600, 30);
		janela.getContentPane().add(txtDuracao2);
		
		txtDuracao3.setFont(new Font("Roboto", Font.PLAIN, 15));
		txtDuracao3.setBounds(35, 340, 600, 30);
		janela.getContentPane().add(txtDuracao3);
		
		txtNumero .setFont(new Font("Roboto", Font.PLAIN, 18));
		txtNumero .setBounds(55, 410, 500, 30);
		janela.getContentPane().add(txtNumero );
		
		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException ignore) {
			//
		}
		if (mascaraData != null) {
			mascaraData.setPlaceholderCharacter('_');
		}
		
		dtInicio= new JFormattedTextField(mascaraData);
		txtInicio.setLabelFor(txtInicio);
		dtInicio.setBounds(55, 190, 370, 20);
		janela.add(dtInicio);	
		
		dtFinal= new JFormattedTextField(mascaraData);
		txtFinal.setLabelFor(txtFinal);
		dtFinal.setBounds(55, 260, 370, 20);
		janela.add(dtFinal);	
		
		duracao = new JTextField();
		duracao.setBounds(55, 370, 495, 25);
		janela.getContentPane().add(duracao);

		numero = new JTextField();	
		numero.setBounds(55, 440, 495, 25);
		janela.getContentPane().add(numero);
		
		cancelar.setBackground(Color.LIGHT_GRAY);
		cancelar.setForeground(Color.BLACK);
		cancelar.addActionListener(this);
		cancelar.setBorder(BorderFactory.createLineBorder(new Color(179,136,235), 2));
		cancelar.setFont(new Font("Digot", Font.PLAIN, 20));
		cancelar.setBounds(50, 480, 100, 50);
		janela.getContentPane().add(cancelar);
	
		

		check.setBackground(new Color(250,224,228));
		check.setForeground(Color.BLACK);
		check.addActionListener(this);
		check.setBorder(BorderFactory.createLineBorder(new Color(179,136,235), 2));
		check.setFont(new Font("Digot", Font.PLAIN, 20));
		check.setBounds(200, 480, 100, 50);
		janela.getContentPane().add(check);
		
		
		buscarCiclo.setBackground(new Color(250,224,228));
		buscarCiclo.setForeground(Color.BLACK);
		buscarCiclo.addActionListener(this);
		buscarCiclo.setBorder(BorderFactory.createLineBorder(new Color(179,136,235), 2));
		buscarCiclo.setFont(new Font("Digot", Font.PLAIN, 20));
		buscarCiclo.setBounds(350, 480, 150, 50);
		janela.getContentPane().add(buscarCiclo);
			
				
			
				
	}


	public static JTextField getDuracao() {
		return duracao;
	}




	public static JTextField getNumero() {
		return numero;
	}


	


	public static JFormattedTextField getDtInicio() {
		return dtInicio;
	}
	


	public static JFormattedTextField getDtFinal() {
		return dtFinal;
	}
	
	public JButton getCheck() {
		return check;
	}




	public static JButton getCancelar() {
		return cancelar;
	}


	

	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
		Object src = e.getSource();		
		if (src == buscarCiclo) {
			janela.dispose();
			TelaBuscarCiclo.main(null);
		}
		
		CadastrarCiclo.cicloCadastrado = CadastrarCicloControl.validarCadastro(numero.getText());
		if (CadastrarCiclo.cicloCadastrado == null) {
			
		} else {
			janela.dispose();
			TelaMenu.main(null);
		}
	}

	
public static Ciclo validarBusca(String numero) {
		
		for (Ciclo c : Dados.getCiclos()) {
			if (c.getNumero().equals(numero)) {
				return c;
			}
		}
		return null;

	}







	
	}
	
 
	



