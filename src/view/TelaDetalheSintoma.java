package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import control.*;

public class TelaDetalheSintoma implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelData = new JLabel("Data do cadastro: ");
	private JTextField valorData;
	private JLabel labelIntensidade = new JLabel("Intensidade: ");
	private JTextField valorIntensidade;
	private JLabel labelDescricao = new JLabel("Descrição: ");
	private JTextField valorDescricao;
	private JLabel labelLocal = new JLabel("Local: ");
	private JTextField valorLocal;	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static DadosControl dados;
	private int posicao;
	private int opcao;
	private String s;

	public void inserirEditar(int op, DadosControl d, 
			TelaSintoma ts, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro de sintomas mentais";
		if (op == 2) s = "Cadastro de sintomas físicos";
		if (op == 3) s = "Detalhe de sintomas mentais";
		if (op == 4) s = "Detalhe de sintomas físicos";

		janela = new JFrame(s);

	
		if (op == 3) {
			valorNome = new JTextField(dados.getSintomaMentais()[pos].getNome(), 200);
			valorDescricao = new JTextField(dados.getSintomaMentais()[pos].getDescricao(),200);
			valorIntensidade = new JTextField(200);
			valorData = new JTextField(String.valueOf(dados.getSintomaMentais()[pos].getCadastro()), 200);
			valorLocal = new JTextField(200);
				

		} else if (op == 4) { 
			valorNome = new JTextField(dados.getSintomasFisicos()[pos].getNome(), 200);
			valorDescricao = new JTextField(200);
			valorIntensidade = new JTextField(String.valueOf(dados.getSintomasFisicos()[pos].getIntensidade()), 200);
			valorData = new JTextField(String.valueOf(dados.getSintomasFisicos()[pos].getCadastro()), 200);
			valorLocal = new JTextField(dados.getSintomasFisicos()[pos].getLocal(), 200);

		} else { 

			valorNome = new JTextField(200);
			valorDescricao = new JTextField(200);
			valorIntensidade = new JTextField(200);
			valorData = new JTextField(200);
			valorLocal= new JTextField(200);
			

			botaoSalvar.setBounds(245, 175, 115, 30);
		}

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelDescricao.setBounds(30, 50, 150, 25);
		valorDescricao.setBounds(180, 50, 180, 25);
		labelIntensidade.setBounds(30, 50, 180, 25);
		valorIntensidade.setBounds(180, 50, 180, 25);		
		labelData.setBounds(30, 80, 150, 25);
		valorData.setBounds(180, 80, 180, 25);
		labelLocal.setBounds(30, 110, 150, 25);
		valorLocal.setBounds(180, 110, 180, 25);
		

		if (op == 1 || op == 3 ) {
			this.janela.add(labelDescricao);
			this.janela.add(valorDescricao);

		}

		if (op == 2 || op == 4) {

			this.janela.add(labelIntensidade);
			this.janela.add(valorIntensidade);
			this.janela.add(labelLocal);
			this.janela.add(valorLocal);
			
			
		}

		//Coloca botoes de excluir e salvar
		if (op == 3 || op == 4) {
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}

		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelData);
		this.janela.add(valorData);	
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 250);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1) //cadastro de novo aluno
					novoDado[0] = Integer.toString(dados.getQtdMentais());
				else if (opcao == 2) // cadastro de novo prof
					novoDado[0] = Integer.toString(dados.getQtdFisicos());
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);

				novoDado[1] =  valorNome.getText();
				novoDado[3] =  valorData.getText();
				

				if (opcao == 1 || opcao == 3) {
					novoDado[2] =  valorDescricao.getText();
					res = dados.inserirEditarSintomasMentais(novoDado);
				} else {
					novoDado[2] =  valorIntensidade.getText();
					novoDado[4] =  valorLocal.getText();
					
					res = dados.inserirEditaSintomasFisicos(novoDado);
				}

				if(res) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}

		if(src == botaoExcluir) {
			

			


			
		}
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar os dados!", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
				
	}

	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir os dados!", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
	}
	

}


