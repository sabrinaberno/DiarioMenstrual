package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * Tela de buscar ciclo
 * @author Mylena e Sabrina
 */
public class TelaBuscarCiclo {

	private JFrame frame;
	private JTextField numero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarCiclo window = new TelaBuscarCiclo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarCiclo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("Ciclos");
		titulo.setForeground(new Color(240,92,138));
		titulo.setFont(new Font("Didot", Font.PLAIN, 45));
		titulo.setBounds(200, 40, 600, 50);
		frame.getContentPane().add(titulo);
		
		JLabel descricao = new JLabel("Digite o número do ciclo que deseja buscar ");
		descricao.setForeground(Color.BLACK);
		descricao.setFont(new Font("Roboto", Font.PLAIN, 20));
		descricao.setBounds(180, 95, 300, 30);
		frame.getContentPane().add(descricao);
		
		
		numero= new JTextField();
		numero.setColumns(10);
		numero.setBounds(55,190,495,25);
		frame.getContentPane().add(numero);
		
		/**
		 * Tenta encontrar o ciclo.
		 */
		JButton check = new JButton("OK");
		check.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				CadastrarCiclo.cicloCadastrado = CadastrarCiclo.validarBusca(numero.getText());
				if (CadastrarCiclo.numero == null) {
					JOptionPane.showMessageDialog(check,
							"Ciclo não encontrado!");				
					} else {
					frame.dispose();
					JOptionPane.showMessageDialog(check,
							"Numero : " + CadastrarCiclo.cicloCadastrado.getNumero() 
									
									);
				}
				frame.dispose();
				TelaMenu.main(null);
			}
		});
		check.setFont(new Font("Cambria", Font.PLAIN, 11));
		check.setBackground(SystemColor.desktop);
		check.setBounds(171, 148, 89, 23);
		frame.getContentPane().add(check);
	}
}