package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Sintoma.Intensidade;


public class CadastrarSintomaMental extends JFrame implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	private JPanel pane;
	
	private static JFrame janela = new JFrame("Sintoma Mental");
	private static JLabel titulo = new JLabel("Cadastro de Sintoma Mental");
	private JComboBox<Object> sintoma = new JComboBox<Object> ();
	
	public CadastrarSintomaMental () {
		
		janela.setBounds(100, 100, 600, 600);
		titulo.setBounds(50, 0, 500, 50);

		//janela.setContentPane(pane);	
		pane = new JPanel (); 
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		pane.setLayout(new BorderLayout(0, 0));
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		sintoma.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		sintoma.setModel(new DefaultComboBoxModel<Object>(Intensidade.values()));
		//panel.add(sintoma);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(sintoma);
		
		janela.setVisible(true);
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
