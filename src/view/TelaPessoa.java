package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Dados;
/**
 * Tela de pessoa com as suas opções.
 * @author Mylena e Sabrina
 * @version 3.0
 */
public class TelaPessoa {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPessoa window = new TelaPessoa();
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
	public TelaPessoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Usuaria");
		lblUsuario.setForeground(SystemColor.desktop);
		lblUsuario.setFont(new Font("Elephant", Font.PLAIN, 37));
		lblUsuario.setBounds(141, 14, 204, 75);
		frame.getContentPane().add(lblUsuario);

		JLabel tiruloUm_1 = new JLabel("Usuaria");
		tiruloUm_1.setForeground(new Color(51, 204, 204));
		tiruloUm_1.setFont(new Font("Elephant", Font.PLAIN, 37));
		tiruloUm_1.setBounds(131, 0, 194, 75);
		frame.getContentPane().add(tiruloUm_1);

		JButton listar = new JButton("Listar dados");
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Printa todas as infos da Pessoa
				JOptionPane.showMessageDialog(listar,
						"Seu nome : " + TelaLoging.usuariaLogada.getNome() +
								
								"\nSeu email : " + TelaLoging.usuariaLogada.getEmail() +				
								"\nSuaSenha : " + TelaLoging.usuariaLogada.getSenha() );
				frame.dispose();
				Menu.main(null);
			}
			
		});
		listar.setBackground(new Color(255, 204, 255));
		listar.setFont(new Font("Cambria", Font.PLAIN, 15));
		listar.setBounds(155, 100, 130, 34);
		frame.getContentPane().add(listar);

		JButton editar = new JButton("Editar dados");
		editar.setFont(new Font("Cambria", Font.PLAIN, 15));
		editar.setBackground(new Color(204, 204, 255));
		editar.setBounds(155, 145, 130, 34);
		frame.getContentPane().add(editar);
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == editar) {
					frame.dispose();
					
					TelaEditarUsuaria.main(null);
				}
			}
		});

		JButton deletar = new JButton("Deletar dados");
		deletar.setBackground(new Color(255, 255, 204));
		deletar.setFont(new Font("Cambria", Font.PLAIN, 15));
		deletar.setBounds(155, 235, 130, 34);

		deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dados.getPessoas().remove(TelaLoging.usuariaLogada);
				System.out.println(Dados.getPessoas().size());
				JOptionPane.showMessageDialog(deletar, "Usuaria deletada, saindo do diário");
				frame.dispose();
				TelaInicial.main(null);
			}
		});
		frame.getContentPane().add(deletar);
		
		JButton btnBuscarUsuario = new JButton("Buscar usuaria");
		btnBuscarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == btnBuscarUsuario) {
					frame.dispose();
					TelaBuscarUsuaria.main(null);
				}
			}
		});
		btnBuscarUsuario.setFont(new Font("Cambria", Font.PLAIN, 15));
		btnBuscarUsuario.setBackground(new Color(153, 204, 255));
		btnBuscarUsuario.setBounds(155, 190, 130, 34);
		frame.getContentPane().add(btnBuscarUsuario);
	}
}
