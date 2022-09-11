package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import control.*;


public class TelaSintoma implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroM;
	private JButton refreshM;
	private JButton cadastroF;
	private JButton refreshF;
	private JButton voltarM;
	private JButton voltarF;
	private static DadosControl dados;
	private JList<String> listaMentaisCadastrados;
	private JList<String> listaFisicosCadastrados;
	private String[] listaNomes = new String[50];

	public void mostrarDados(DadosControl d, int op){
		dados = d;

		switch (op) {
		case 1:// Mostra os dados de sintomas mentais cadastrados (JList)
			listaNomes = new SintomaMentalControl(dados).getNome();
			listaMentaisCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Sintomas mentais");
			titulo = new JLabel("Sintomas mentais cadastrados");
			cadastroM = new JButton("Cadastrar");
			refreshM = new JButton("Refresh");
			voltarM = new JButton("Voltar");

			titulo.setFont(new Font("Digot", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaMentaisCadastrados.setBounds(20, 50, 350, 120);
			listaMentaisCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaMentaisCadastrados.setVisibleRowCount(10);

			cadastroM.setBounds(70, 177, 100, 30);
			refreshM.setBounds(200, 177, 100, 30);
			voltarM.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaMentaisCadastrados);
			janela.add(cadastroM);
			janela.add(refreshM);
			janela.add(voltarM);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroM.addActionListener(this);
			refreshM.addActionListener(this);
			voltarM.addActionListener(this);
			listaMentaisCadastrados.addListSelectionListener(this);

			break;

		case 2:// Mostra os dados de sintomas fisicos cadastrados (JList)
			listaNomes = new SintomaFisicoControl(dados).getNome();
			listaFisicosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Sintomas físicos");
			titulo = new JLabel("Sintomas físicos cadastrados");
			cadastroF = new JButton("Cadastrar");
			refreshF = new JButton("Refresh");
			voltarF = new JButton("Voltar");

			titulo.setFont(new Font("Digot", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaFisicosCadastrados.setBounds(20, 50, 350, 120);
			listaFisicosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaFisicosCadastrados.setVisibleRowCount(10);

			cadastroF.setBounds(70, 177, 100, 30);
			refreshF.setBounds(200, 177, 100, 30);
			voltarF.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaFisicosCadastrados);
			janela.add(cadastroF);
			janela.add(refreshF);
			janela.add(voltarF);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroF.addActionListener(this);
			refreshF.addActionListener(this);
			voltarF.addActionListener(this);
			listaFisicosCadastrados.addListSelectionListener(this);

			break;

		default:
			JOptionPane.showMessageDialog(null,"Op��o n�o encontrada!", null, 
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