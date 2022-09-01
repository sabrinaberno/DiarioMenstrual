package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.*;

/**
 * Página que lista os dados recebidos dos sintomas mentais cadastrados
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 */

public class TelaMental implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroMental;
	private JButton refreshMental;
	private static ControleDados dados;
	private JList<String> listaMentaisCadastrados;

	private String[] listaNomes = new String[50];

	public void mostrarDados(ControleDados d, int op){
		dados = d;

		    listaNomes = new ControleMentais(dados).getNomeMental();
			listaMentaisCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Sintomas mentais.");
			titulo = new JLabel("Sintomas mentais cadastrados");
			cadastroMental = new JButton("Cadastrar");
			refreshMental = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(50, 0, 500, 50);
			listaMentaisCadastrados.setBounds(50, 50, 290, 100);
			listaMentaisCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaMentaisCadastrados.setVisibleRowCount(10);

			cadastroMental.setBounds(70, 177, 100, 30);
			cadastroMental.setBackground(Color.pink);
			cadastroMental.setForeground(Color.black);
			refreshMental.setBounds(200, 177, 100, 30);
			refreshMental.setBackground(new Color (255, 246, 249));
			refreshMental.setForeground(Color.black);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaMentaisCadastrados);
			janela.add(cadastroMental);
			janela.add(refreshMental);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroMental.addActionListener(this);
			refreshMental.addActionListener(this);
			listaMentaisCadastrados.addListSelectionListener(this);

			
	}
	

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo aluno
		if(src == cadastroMental)	
			
			new DetalheMental().inserirEditar(1, dados, this, 0);

		
		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == refreshMental) {
			listaMentaisCadastrados.setListData(new ControleMentais(dados).getNomeMental());			
			listaMentaisCadastrados.updateUI();
		}

			}

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaMentaisCadastrados) {
			new DetalheMental().inserirEditar(2, dados, this, 
					listaMentaisCadastrados.getSelectedIndex());
		}

		
	}

}