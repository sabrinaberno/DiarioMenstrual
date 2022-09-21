package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import control.*;

/**
 * Tela de cadastro, edição, deleção e visualização dos sintomas 
 * @author Mylena e Sabrina
 * @version 1.0
 */


public class TelaSintoma implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroM;
	private JButton refreshM;
	private JButton cadastroF;
	private JButton refreshF;
	private static DadosControl dados;
	private JList<String> listaMentaisCadastrados;
	private JList<String> listaFisicosCadastrados;
	private String[] listaNomes = new String[50];

	public void mostrarDados(DadosControl d, int op){
		dados = d;

		switch (op) {

	/**
	 * Tela de cadastro, edição, visualização e exclusão  de sintomas mentais
	 */	
		case 1:
			listaNomes = new SintomaMentalControl(dados).getNome();
			listaMentaisCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Sintomas mentais");
			titulo = new JLabel("Sintomas Mentais Cadastrados");
			cadastroM = new JButton("Cadastrar");
			refreshM = new JButton("Recarregar");

			titulo.setFont(new Font("Digot", Font.BOLD, 20));
			titulo.setBounds(90, 10, 450, 30);
			listaMentaisCadastrados.setBounds(20, 50, 450, 300);
			listaMentaisCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaMentaisCadastrados.setVisibleRowCount(10);

			cadastroM.setBounds(70, 370, 170, 30);
			refreshM.setBounds(250, 370, 170, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaMentaisCadastrados);
			janela.add(cadastroM);
			janela.add(refreshM);

			janela.setSize(500, 500);
			janela.setVisible(true);

			cadastroM.addActionListener(this);
			refreshM.addActionListener(this);
			listaMentaisCadastrados.addListSelectionListener(this);

			break;

		/**
	 * Tela de cadastro, edição, visualização e exclusão  de sintomas mentais
	 */	

		case 2:
			listaNomes = new SintomaFisicoControl(dados).getNome();
			listaFisicosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Sintomas físicos");
			titulo = new JLabel("Sintomas Físicos cadastrados");
			cadastroF = new JButton("Cadastrar");
			refreshF = new JButton("Recarregar");

			titulo.setFont(new Font("Digot", Font.BOLD, 20));
			titulo.setBounds(90, 10, 350, 30);
			listaFisicosCadastrados.setBounds(20, 50, 450, 300);
			listaFisicosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaFisicosCadastrados.setVisibleRowCount(10);

			cadastroF.setBounds(70, 370, 170, 30);
			refreshF.setBounds(250, 370, 170, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaFisicosCadastrados);
			janela.add(cadastroF);
			janela.add(refreshF);

			janela.setSize(500, 500);
			janela.setVisible(true);

			cadastroF.addActionListener(this);
			refreshF.addActionListener(this);
			listaFisicosCadastrados.addListSelectionListener(this);

			break;

		default:
			JOptionPane.showMessageDialog(null,"Opçãoo não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}

	}



	//Captura eventos relacionados aos bot�es da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo sintoma mental
		if(src == cadastroM)
			new TelaDetalheSintoma().inserirEditar(1, dados, this, 0);

		//Cadastro de novo sintoma fisico
		if(src == cadastroF)
			new TelaDetalheSintoma().inserirEditar(2, dados, this, 0);

		// Atualiza a lista de nomes dos sintoma mental mostrada no JList
		if(src == refreshM) {
			listaMentaisCadastrados.setListData(new SintomaMentalControl(dados).getNome());			
			listaMentaisCadastrados.updateUI();
		}

		// Atualiza a lista de nomes dos sintoma fisico mostrada no JList
		if(src == refreshF) {
			listaFisicosCadastrados.setListData(new SintomaFisicoControl(dados).getNome());
			listaFisicosCadastrados.updateUI();
		}

	}

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaMentaisCadastrados) {
			new TelaDetalheSintoma().inserirEditar(3, dados, this, 
					listaMentaisCadastrados.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaFisicosCadastrados) {
			new TelaDetalheSintoma().inserirEditar(4, dados, this, 
					listaFisicosCadastrados.getSelectedIndex());
		}
	}

}