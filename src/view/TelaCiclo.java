package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControllerUsuarias;
import model.Pessoa;


/**
 * Tela de cadastro de cartão.
 * @author Maria Abritta e Thyago Moura 
 * @version 1.0 (Abril 2022)
 */
public class TelaCiclo {

	private JFrame frame;
	public static JTextField dataInicioMenstruacao;
	public static JTextField dataFinalMenstruacao;
	public static JTextField numero;
	public static JTextField duracao;
	static Pessoa cicloCadastrado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCiclo window = new TelaCiclo();
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
	public TelaCiclo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ControllerUsuarias controller = new ControllerUsuarias();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel tiruloUm_1 = new JLabel("Cadastro");
		tiruloUm_1.setForeground(new Color(51, 204, 204));
		tiruloUm_1.setFont(new Font("Elephant", Font.PLAIN, 37));
		tiruloUm_1.setBounds(126, 0, 194, 75);
		frame.getContentPane().add(tiruloUm_1);

		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setForeground(SystemColor.desktop);
		lblCadastro.setFont(new Font("Elephant", Font.PLAIN, 37));
		lblCadastro.setBounds(136, 14, 204, 75);
		frame.getContentPane().add(lblCadastro);

		JLabel tituloUm = new JLabel("Insira os dados necesarios ");
		tituloUm.setForeground(Color.BLACK);
		tituloUm.setFont(new Font("Elephant", Font.PLAIN, 17));
		tituloUm.setBackground(Color.CYAN);
		tituloUm.setBounds(99, 73, 239, 31);
		frame.getContentPane().add(tituloUm);

		JLabel tituloDois = new JLabel("para efetuar o cadastro do ciclo: ");
		tituloDois.setFont(new Font("Elephant", Font.PLAIN, 17));
		tituloDois.setBounds(109, 99, 239, 13);
		frame.getContentPane().add(tituloDois);

		JLabel tituloForma = new JLabel("Dia inicial do sangramento:");
		tituloForma.setFont(new Font("Cambria", Font.PLAIN, 15));
		tituloForma.setBounds(51, 136, 289, 14);
		frame.getContentPane().add(tituloForma);

		dataInicioMenstruacao = new JTextField();
		dataInicioMenstruacao.setColumns(10);
		dataInicioMenstruacao.setBounds(51, 157, 335, 20);
		frame.getContentPane().add(dataInicioMenstruacao);

		JLabel tituloNumCartao = new JLabel("Dia final do sangramento:");
		tituloNumCartao.setFont(new Font("Cambria", Font.PLAIN, 15));
		tituloNumCartao.setBounds(51, 217, 127, 14);
		frame.getContentPane().add(tituloNumCartao);

		dataFinalMenstruacao = new JTextField();
		dataFinalMenstruacao.setColumns(10);
		dataFinalMenstruacao.setBounds(51, 238, 335, 20);
		frame.getContentPane().add(dataFinalMenstruacao);

		JLabel tituloNome = new JLabel("Duração média do ciclo:");
		tituloNome.setVerticalAlignment(SwingConstants.BOTTOM);
		tituloNome.setFont(new Font("Cambria", Font.PLAIN, 15));
		tituloNome.setBounds(51, 298, 177, 14);
		frame.getContentPane().add(tituloNome);

		duracao = new JTextField();
		duracao.setColumns(10);
		duracao.setBounds(51, 319, 335, 20);
		frame.getContentPane().add(duracao);

		JLabel tituloCVV = new JLabel("Número:");
		tituloCVV.setVerticalAlignment(SwingConstants.BOTTOM);
		tituloCVV.setHorizontalAlignment(SwingConstants.LEFT);
		tituloCVV.setFont(new Font("Cambria", Font.PLAIN, 15));
		tituloCVV.setBounds(51, 379, 46, 14);
		frame.getContentPane().add(tituloCVV);

		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(51, 400, 335, 20);
		frame.getContentPane().add(numero);

		/**
		 * 	 * Verifica o cadastro inteiro de usuário, se está de acordo com as verificações específicas, não manda mensagem de erro.
		 */
		JButton check = new JButton("OK");
		check.setFont(new Font("Cambria", Font.PLAIN, 11));
		check.setBackground(SystemColor.desktop);
		check.setBounds(173, 444, 89, 23);
		frame.getContentPane().add(check);
		check.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String msgErro = "";

				if (dataInicioMenstruacao.getText().length() == 0 || dataFinalMenstruacao.getText().length() == 0
						|| numero.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!",
							"Falta de dados",
							JOptionPane.ERROR_MESSAGE);

					return;
				}
				
				if (msgErro.length() > 0) {
					JOptionPane.showMessageDialog(null, msgErro, "ERRO", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Confirmar Cadastro", "Deseja Confirmar o Cadastro?",
							JOptionPane.DEFAULT_OPTION);

					// registrar os dados no back
					// ControllerPagamentos.cadastrarCartao();

					// outros
					frame.dispose();
					TelaMenu.main(null);
				}
			}
		});
		frame.getContentPane().add(check);
	}

	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
