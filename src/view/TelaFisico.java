package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.*;

/**
 * Página que lista os dados recebidos dos sintomas fisicos cadastrados
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 */


public class TelaFisico implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastro;
	private JButton refresh;
	private static ControleDados dados;
	private JList<String> listaCadastrados;

	private String[] listaNomes = new String[50];

	public void mostrarDados(ControleDados d, int op){
		dados = d;

		    listaNomes = new ControleFisicos(dados).getNomeFisico();
			listaCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Sintomas físicos.");
			titulo = new JLabel("Sintomas físicos cadastrados");
			cadastro = new JButton("Cadastrar");
			refresh = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(50, 0, 500, 50);
			listaCadastrados.setBounds(50, 50, 290, 100);
			listaCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaCadastrados.setVisibleRowCount(10);

			cadastro.setBounds(70, 177, 100, 30);
			cadastro.setBackground(Color.pink);
			cadastro.setForeground(Color.black);
			refresh.setBounds(200, 177, 100, 30);
			refresh.setBackground(new Color (255, 246, 249));
			refresh.setForeground(Color.black);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaCadastrados);
			janela.add(cadastro);
			janela.add(refresh);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastro.addActionListener(this);
			refresh.addActionListener(this);
			listaCadastrados.addListSelectionListener(this);

			
	}
	

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo aluno
		if(src == cadastro)	
			
			new DetalheFisico().inserirEditar(1, dados, this, 0);

		
		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == refresh) {
			listaCadastrados.setListData(new ControleFisicos(dados).getNomeFisico());			
			listaCadastrados.updateUI();
		}

			}

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaCadastrados) {
			new DetalheFisico().inserirEditar(2, dados, this, 
					listaCadastrados.getSelectedIndex());
		}

		
	}

}