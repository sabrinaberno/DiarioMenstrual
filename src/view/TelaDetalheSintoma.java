package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.*;

public class TelaDetalheSintoma implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelIntensidade = new JLabel("Intensidade: ");
	private JTextField valorIntensidade;
	private JLabel labelCadastro = new JLabel("Data do cadastro: ");
	private JTextField valorCadastro;
	private JLabel labelLocal = new JLabel("Local: ");
	private JTextField valorLocal;		
	private JLabel labelDescricao = new JLabel("Descrição: ");
	private JTextField valorDescricao;	
	private JLabel labelTipo = new JLabel("Tipo: ");
	private JComboBox<String> valorTipo;	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private ControllerFisico controllerF;
	private ControllerMental controllerM;
	private static ControllerDados dados;
	private int posicao;
	private int opcao;
	private String s;
	

	public void inserirEditar(int op, ControllerDados d, 
			TelaPessoa p, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro de sintomas mentais";
		if (op == 2) s = "Cadastro de sintomas fisicos";
		if (op == 3) s = "Detalhe de sintomas mentais";
		if (op == 4) s = "Detalhe de sintomas fisicos";

		janela = new JFrame(s);

		//Preenche dados com dados de sintomas mentais clicado
		if (op == 3) {
			valorNome = new JTextField(dados.getMentais()[pos].getNome(), 200);
			valorTipo.setModel(new DefaultComboBoxModel<>(new String[] { "Fisico", "Mental"}));
			valorCadastro = new JTextField(dados.getMentais()[pos].getCadastro(),200);
			valorDescricao = new JTextField(String.valueOf(dados.getAlunos()[pos].getCPF()), 200);
			valorLocal = new JTextField(200);
			valorIntensidade = new JTextField(200);		

		} else if (op == 4) { //Preenche dados com dados do professor clicado 
			valorNome = new JTextField(dados.getFisicos()[pos].getNome(), 200);
			valorTipo = new JTextField(dados.getFisicos()[pos].getTipo(),200);
			valorCadastro = new JTextField(dados.getFisicos()[pos].getCadastro(),200);
			valorDescricao = new JTextField(200);
			valorLocal = new JTextField(dados.getFisicos()[pos].geLocal(), 200);
			valorIntensidade = new JTextField(String.valueOf(dados.getFisicos()[pos].getIntensidade()), 200);	;

		} else { //N�o preenche com dados

			valorNome = new JTextField(200);
			valorTipo.setModel(new DefaultComboBoxModel<>(new String[] { "Fisico", "Mental"}));
			valorCadastro = new JTextField(200);
			valorDescricao = new JTextField(200);
			valorLocal = new JTextField(200);
			valorIntensidade = new JTextField(3);
			

			botaoSalvar.setBounds(245, 175, 115, 30);
		}

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelTipo.setBounds(78, 292, 287, 26);
		valorTipo.setModel(new DefaultComboBoxModel<>(new String[] { "Fisico", "Mental"}));
		valorTipo.setBounds(398, 290, 198, 30);
		labelCadastro.setBounds(30, 50, 180, 25);
		valorCadastro.setBounds(180, 50, 180, 25);		
		labelDescricao.setBounds(30, 80, 150, 25);
		valorDescricao.setBounds(180, 80, 180, 25);
		labelLocal.setBounds(30, 110, 150, 25);
		valorLocal.setBounds(180, 110, 180, 25);
		labelIntensidade.setBounds(30, 140, 150, 25);
		valorIntensidade.setBounds(180, 140, 28, 25);
		

		//Coloca os campos relacionados a endereco se aluno
		if (op == 1 || op == 3 ) {
			this.janela.add(labelDescricao);
			this.janela.add(valorDescricao);

		}

		//Coloca campos relacionados a valor hora/aula se professor
		if (op == 2 || op == 4) {

			this.janela.add(labelLocal);
			this.janela.add(valorLocal);
			this.janela.add(labelIntensidade);
			this.janela.add(valorIntensidade);
		}

		//Coloca botoes de excluir e salvar
		if (op == 3 || op == 4) {
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}

		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelTipo);
		this.janela.add(valorTipo);
		this.janela.add(labelCadastro);
		this.janela.add(valorCadastro);
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
				novoDado[2] =  valorTipo.getText();
				novoDado[4] =  valorCadastro.getText();
				

				if (opcao == 1 || opcao == 3) {
					novoDado[3] =  valorDescricao.getText();
					res = dados.inserirEditarMental(novoDado);
				} else {
					novoDado[3] =  valorIntensidade.getText();
					novoDado[5] =  valorLocal.getText();
					res = dados.inserirEditarFisico(novoDado);
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
			boolean res = false;

			if (opcao == 3) {//exclui aluno
				res = dados.removerMental(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoAluno(); 
			}
				
			if (opcao == 4){ //exclui professor
				res = dados.removerFisico(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoProf(); 
			}


			
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
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. CPF, identidade, DDD e telefone n�o cont�m apenas n�meros", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoAluno() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o aluno est� matriculado\n"
				+ "em alguma disciplina. Se sim, cancele\n "
				+ "a matricula e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusaoProf() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o professor est� respons�vel\n"
				+ "por alguma disciplina. Se sim, substitua\n "
				+ "o professor e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}


	public JTextField getValorNome() {
		return valorNome;
		}


	public JTextField getValorIntensidade() {
		return valorIntensidade;
	}


	public JTextField getValorCadastro() {
		return valorCadastro;
	}


	public JTextField getValorLocal() {
		return valorLocal;
	}

	public JTextField getValorDescricao() {
		return valorDescricao;
	}


	public JComboBox<String> getValorTipo() {
		return valorTipo;
	}


	public ControllerFisico getControllerF() {
		return controllerF;
	}
	
	public ControllerMental getControllerM() {
		return controllerM;
	}


	
	
	

}