package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.*;
/**
 * tela geral de biciletas.
 * @author Maria Abritta e Thyago Moura 
 * @version 1.0 (Abril 2022)
**/

public class TelaSintoma implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroMental;
	private JButton refreshMental;
	private JButton cadastroFisico;
	private JButton refreshFisico;
	private static ControllerDados dados;
	private JList<String> listaMentaisCadastrados;
	private JList<String> listaFisicosCadastrados;
	private String[] listaNomes = new String[50];
	
	
	

	public void mostrarDados(ControllerDados d, int op){
		dados = d;

		switch (op) {
		case 1:// Mostrar dados de sintomas mentais cadastrados (JList)
			listaNomes = new ControllerMental(dados).getNome();
			listaMentaisCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Sintomas mentais");
			titulo = new JLabel("Sintomas mentais cadastrados");
			cadastroMental = new JButton("Cadastrar");
			refreshMental = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaMentaisCadastrados.setBounds(20, 50, 350, 120);
			listaMentaisCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaMentaisCadastrados.setVisibleRowCount(10);

			cadastroMental.setBounds(70, 177, 100, 30);
			refreshMental.setBounds(200, 177, 100, 30);

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

			break;

		case 2:// Mostrar dados de fisicos cadastrados (JList)
			listaNomes = new ControllerFisico(dados).getNome();
			listaFisicosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Sintomas físicos");
			titulo = new JLabel("Sintomas físicos cadastrados");
			cadastroFisico = new JButton("Cadastrar");
			refreshFisico = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaFisicosCadastrados.setBounds(20, 50, 350, 120);
			listaFisicosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaFisicosCadastrados.setVisibleRowCount(10);

			cadastroFisico.setBounds(70, 177, 100, 30);
			refreshFisico.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaFisicosCadastrados);
			janela.add(cadastroFisico);
			janela.add(refreshFisico);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroFisico.addActionListener(this);
			refreshFisico.addActionListener(this);
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
		
		//Cadastro de novo aluno
		if(src == cadastroMental)
			new TelaDetalheSintoma().inserirEditar(1, dados, this, 0);

		//Cadastro de novo professor
		if(src == cadastroFisico)
			new TelaDetalheSintoma().inserirEditar(2, dados, this, 0);

		// Atualiza a lista de nomes de alunos mostrada no JList
		if(src == refreshMental) {
			listaMentaisCadastrados.setListData(new ControllerMental(dados).getNomeAluno());			
			listaMentaisCadastrados.updateUI();
		}

		// Atualiza a lista de nomes de professores mostrada no JList
		if(src == refreshFisico) {
			listaMentaisCadastrados.setListData(new ControllerFisico(dados).getNomeProf());
			listaMentaisCadastrados.updateUI();
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

	


