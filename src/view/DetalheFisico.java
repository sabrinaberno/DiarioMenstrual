package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.*;

/**
 * Página de cadastro dos dados relativos à um sintoma físico, incluindo listar e excluir o sintoma
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 */


public class DetalheFisico implements ActionListener {

	private JFrame janela;
	private JLabel labelFisico = new JLabel("Sintoma físico: ");
	private JTextField valorFisico;
	private JLabel labelIntensidade = new JLabel("Intensidade: ");
	private JTextField valorIntensidade;
	private JLabel labelCadastro = new JLabel("Data: ");
	private JTextField valorCadastro;
	private JLabel labelLocal = new JLabel("Local: ");
	private JTextField valorLocal;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;

	public void inserirEditar(int op, ControleDados d, 
			TelaFisico telaFisico, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro sintomas fisicos";
		if (op == 2) s = "Detalhe sintomas fisicos";
		
		

		janela = new JFrame(s);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		janela.setBounds(100, 100, 600, 600);		
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

		//Preenche dados com dados do sintoma mental clicado
		if (op == 2) {
			
			valorIntensidade = new JTextField(String.valueOf(dados.getFisicos()[pos].getIntensidade()));
			valorCadastro = new JTextField(dados.getFisicos()[pos].getCadastro());
			valorFisico = new JTextField(dados.getFisicos()[pos].getNomeFisico());
			valorLocal = new JTextField(dados.getFisicos()[pos].getLocal());
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoSalvar.setBackground(Color.pink);
			botaoSalvar.setForeground(Color.black);
			botaoExcluir.setBounds(245, 175, 115, 30);
			botaoExcluir.setBackground(Color.RED);
			botaoExcluir.setForeground(Color.white);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
			
							
		
		} else { //N�o preenche com dados

			valorFisico = new JTextField(200);
			valorIntensidade = new JTextField(200);
			valorCadastro = new JTextField(200);
			valorLocal = new JTextField(200);

			botaoSalvar.setBounds(245, 175, 115, 30);
		}
	
		
		labelIntensidade.setBounds(30, 20, 150, 25);
		valorIntensidade.setBounds(180, 20, 180, 25);
		labelCadastro.setBounds(30, 50, 150, 25);
		valorCadastro.setBounds(180, 50, 180, 25);
		labelFisico.setBounds(30, 80, 150, 25);
		valorFisico.setBounds(180, 80, 180, 25);
		labelLocal.setBounds(30, 110, 150, 25);
		valorLocal.setBounds(180, 110, 180, 25);
		
		
		
		
		
		if (op == 1  ) {
			
			this.janela.add(labelFisico);
			this.janela.add(valorFisico);
			this.janela.add(labelLocal);
			this.janela.add(valorLocal);
			this.janela.add(labelIntensidade);
			this.janela.add(valorIntensidade);
			this.janela.add(labelCadastro);
			this.janela.add(valorCadastro);
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoSalvar.setBackground(Color.pink);
			botaoSalvar.setForeground(Color.black);
			botaoExcluir.setBounds(245, 175, 115, 30);
			botaoExcluir.setBackground(Color.RED);
			botaoExcluir.setForeground(Color.white);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
			
		}

	
		this.janela.add(labelFisico);
		this.janela.add(valorFisico);
		this.janela.add(labelLocal);
		this.janela.add(valorLocal);
		this.janela.add(labelIntensidade);
		this.janela.add(valorIntensidade);
		this.janela.add(labelCadastro);
		this.janela.add(valorCadastro);		
		this.janela.add(botaoSalvar);
		this.janela.setLayout(null);
		this.janela.setBounds(100, 100, 600, 600);
		this.janela.setVisible(true);
		this.janela.setSize(400, 250);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res = true;
				if(opcao == 1) //cadastro de novo aluno
					novoDado[0] = Integer.toString(dados.getQtdFisicos());
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);						
				
				

				if (opcao == 1) 
					
					novoDado[1] =  valorIntensidade.getText();
					novoDado[2] =  valorCadastro.getText();					
					novoDado[3] =  valorFisico.getText();
					novoDado[4] =  valorLocal.getText();
					res = dados.inserirEditarMental(novoDado);
				
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

			if (opcao == 2) {//exclui aluno
				res = dados.removerFisico(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoMental(); 
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

	public void mensagemErroExclusaoMental() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o aluno est� matriculado\n"
				+ "em alguma disciplina. Se sim, cancele\n "
				+ "a matricula e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusaoFisico() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o professor est� respons�vel\n"
				+ "por alguma disciplina. Se sim, substitua\n "
				+ "o professor e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}