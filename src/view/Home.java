package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;



public class Home extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(8, 1, 0, 0));
		
		JButton btnCadastrarCiclo = new JButton("Cadastrar Novo Ciclo");
		btnCadastrarCiclo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCadastrarCiclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				try {
					tela = new CadastrarCiclo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				tela.setVisible(true);
				setVisible(false);
			}
		});

		panel.add(btnCadastrarCiclo);

		
		
		
	}
}

