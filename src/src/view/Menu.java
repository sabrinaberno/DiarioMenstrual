package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Tela de menu.
 * @author Maria Abritta e Thyago Moura 
 * @version 1.0 (Abril 2022)
 */
public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel tiruloUm = new JLabel("Diário Menstrual!");
		tiruloUm.setForeground(SystemColor.desktop);
		tiruloUm.setFont(new Font("Elephant", Font.PLAIN, 37));
		tiruloUm.setBounds(130, 14, 204, 75);
		frame.getContentPane().add(tiruloUm);

		

		JButton usuario = new JButton("Usuaria");
		usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == usuario) {
					frame.dispose();
					TelaPessoa.main(null);
				}
			}
		});
		usuario.setBackground(new Color(255, 204, 255));
		usuario.setFont(new Font("Cambria", Font.PLAIN, 15));
		usuario.setBounds(162, 91, 113, 36);
		frame.getContentPane().add(usuario);

		JButton bicicletario = new JButton("Adicionar sintoma físico");
		bicicletario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == bicicletario) {
					frame.dispose();
					CadastrarFisico.main(null);
				}
			}
		});
		bicicletario.setFont(new Font("Cambria", Font.PLAIN, 15));
		bicicletario.setBackground(new Color(204, 204, 255));
		bicicletario.setBounds(162, 185, 113, 36);
		frame.getContentPane().add(bicicletario);

		JButton bicicletas = new JButton("Adicionar sintoma mental");
		bicicletas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == bicicletas) {
					frame.dispose();
					CadastrarMental.main(null);
				}
			}
		});
		bicicletas.setFont(new Font("Cambria", Font.PLAIN, 15));
		bicicletas.setBackground(new Color(255, 255, 204));
		bicicletas.setBounds(162, 230, 113, 36);
		frame.getContentPane().add(bicicletas);

		JButton pagamentos = new JButton("AdicionarNovoCiclo");
		pagamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == pagamentos) {
					frame.dispose();
					TelaCiclo.main(null);
				}
			}
		});
		pagamentos.setFont(new Font("Cambria", Font.PLAIN, 15));
		pagamentos.setBackground(new Color(204, 255, 255));
		pagamentos.setBounds(162, 138, 113, 36);
		frame.getContentPane().add(pagamentos);
	}

	public static void dispose() {
		// TODO Auto-generated method stub
		
	}

}