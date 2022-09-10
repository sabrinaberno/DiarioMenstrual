package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import model.Dados;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Tela inicial, a primeira tela que aparece quando inicializa a aplication
 * @author Mylena e Sabrina
 * @version 2.0 
 */
public class TelaInicial {

	private JFrame frame;
	private JLabel titulo = new JLabel("Diário Menstrual");
	private static JButton cadastro = new JButton("Cadastrar-se");
	private JButton login = new JButton("Fazer Login");

	public static void main (String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); }
		

	public TelaInicial() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().setVisible(true);
		frame.setBounds(100, 100, 450, 224);

		titulo.setForeground(new Color(255,92,138));
		titulo.setFont(new Font("Didot", Font.PLAIN, 35));
		titulo.setBounds(90, 20, 500, 75);
		frame.getContentPane().add(titulo);

		
		cadastro.setBounds(163, 111, 119, 38);

		if (Dados.getPessoas().size() > 0) {
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object src = e.getSource();
					if (src == login) {
						frame.dispose();
						new TelaInicial();
					}
				}
			});

			login.setFont(new Font("Cambria", Font.PLAIN, 15));
			login.setBackground(new Color(204, 153, 255));
			login.setBounds(50, 100, 119, 38);
			cadastro.setBounds(160, 150, 119, 38);
			frame.setBounds(100, 100, 450, 250);
			frame.getContentPane().add(login);
		}

		cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == cadastro) {
					frame.dispose();
					new CadastrarPessoa();
				}
			}
		});

		cadastro.setBackground(new Color(250,224,228));
		cadastro.setForeground(Color.BLACK);
		cadastro.setBorder(BorderFactory.createLineBorder(new Color(179,136,235), 2));

		frame.getContentPane().add(cadastro);

		
		

}


}




