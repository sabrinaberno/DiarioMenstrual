package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Tela de menu.
 * @author Mylena e Sabrina
 * @version 2.0 
 */
public class TelaMenu {

	private JFrame janela;
	JLabel titulo = new JLabel("Diário menstrual");
	JButton usuaria = new JButton("Editar dados pessoa");
	JButton ciclo = new JButton("Cadastrar Ciclo");
	JButton mental = new JButton("Sintomas mentais");
	JButton fisico = new JButton("Sintomas físicos");
	JButton relatorio = new JButton("Relatório");
	

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
		janela.setBounds(200, 200, 600, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);

		
		titulo.setForeground(Color.magenta);
		titulo.setFont(new Font("Digot", Font.PLAIN, 37));
		titulo.setBounds(150, 40, 600, 50);
		janela.getContentPane().add(titulo);


		usuaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == usuaria) {
					janela.dispose();
					TelaEditarUsuaria.main(null);
				}
			}
		});
		usuaria.setBackground(new Color(227,99,151));
		usuaria.setFont(new Font("Roboto", Font.BOLD, 18));
		usuaria.setBounds(210, 150, 200, 40);
		janela.getContentPane().add(usuaria);

		
		ciclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == ciclo) {
					janela.dispose();
					CadastrarPessoa.main(null);
				}
			}
		});
		ciclo.setFont(new Font("Roboto", Font.BOLD, 18));
		ciclo.setBackground(new Color(245,183,0));
		ciclo.setBounds(210, 210, 200, 40);
		janela.getContentPane().add(ciclo);

		
		mental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == mental) {
					janela.dispose();
					CadastrarPessoa.main(null);
				}
			}
		});
		mental.setFont(new Font("Roboto", Font.BOLD, 18));
		mental.setBackground(new Color(60,145,230));
		mental.setBounds(210, 270, 200, 40);
		janela.getContentPane().add(mental);

		
		fisico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == fisico) {
					janela.dispose();
					CadastrarPessoa.main(null);
				}
			}
		});
		fisico.setFont(new Font("Roboto", Font.BOLD, 18));
		fisico.setBackground(new Color(105,220,158));
		fisico.setBounds(210, 330, 200, 40);
		janela.getContentPane().add(fisico);
		
		relatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == relatorio) {
					janela.dispose();
					CadastrarPessoa.main(null);
				}
			}
		});
		relatorio.setFont(new Font("Roboto", Font.BOLD, 18));
		relatorio.setBackground(new Color(250,130,76));
		relatorio.setBounds(210, 390, 200, 40);
		janela.getContentPane().add(relatorio);
	}

	public static void dispose() {
		// TODO Auto-generated method stub
		
	}

}




		
		

		
