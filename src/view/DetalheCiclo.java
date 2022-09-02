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
 * Página de cadastro dos dados relativos ao ciclo atual, incluindo listar e excluir o ciclo
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 */


public class DetalheCiclo implements ActionListener {

	private JFrame janela;
	private JLabel labelNumero = new JLabel("Ciclo de número: ");
	private JTextField valorNumero;
	private JLabel labelSintomas = new JLabel("Sintomas do ciclo: ");
	private JTextField valorSintomas;
	private JLabel labelLocal = new JLabel("Local: ");
	private JTextField valorLocal;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelNascimento = new JLabel("Data de nascimento: ");
	private JTextField valorNascimento;
	private JLabel labelInicio = new JLabel("Data do início: ");
	private JTextField valorInicio;
	private JLabel labelFinal = new JLabel("Data final: ");
	private JTextField valorFinal;
	//private JLabel labelOvu = new JLabel("Dia previsto ovulação: ");
	//private JTextField valorOvu;		
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;

	public void inserirEditar(int op, ControleDados d, 
			TelaCiclo telaCiclo, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro ciclo";
		if (op == 2) s = "Detalhe ciclo";
		
		

		janela = new JFrame(s);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		janela.setBounds(100, 100, 600, 600);		
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

		//Preenche dados com dados do ciclo clicado
		if (op == 2) {
			
			valorNumero = new JTextField(dados.getCiclos()[pos].getNumero());
			valorNome = new JTextField(dados.getPessoas()[pos].getNome());
			valorNascimento = new JTextField(dados.getPessoas()[pos].getNascimento());
			valorInicio = new JTextField(dados.getCiclos()[pos].getDataInicioMenstruacao());
			valorSintomas  = new JTextField(dados.getMentais()[pos].getNomeMental()); //colocar o fisico tb
			valorFinal = new JTextField(dados.getCiclos()[pos].getDataFinalMenstruacao());
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoSalvar.setBackground(Color.pink);
			botaoSalvar.setForeground(Color.black);
			botaoExcluir.setBounds(245, 175, 115, 30);
			botaoExcluir.setBackground(Color.RED);
			botaoExcluir.setForeground(Color.white);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
			
							
		
		} else { //Não preenche com dados

			
			valorFinal = new JTextField(200);
			valorInicio = new JTextField(200);
			valorNascimento = new JTextField(200);
			valorNome = new JTextField(200);
			valorNumero = new JTextField(200);
			valorSintomas = new JTextField(200);			

			botaoSalvar.setBounds(245, 175, 115, 30);
		}
	
		
		
		labelLocal.setBounds(30, 110, 180, 25);
		valorLocal.setBounds(180, 110, 180, 25);	
		labelNumero.setBounds(30, 20, 150, 25);
		valorNumero.setBounds(180, 20, 180, 25);
		labelInicio.setBounds(30, 50, 150, 25);
		valorInicio.setBounds(180, 50, 180, 25);
		labelNome.setBounds(30, 80, 150, 25);
		valorNome.setBounds(180, 80, 180, 25);
		labelNascimento.setBounds(30, 110, 150, 25);
		valorNascimento.setBounds(180, 110, 180, 25);
		labelFinal.setBounds(30, 80, 180, 25);
		valorFinal.setBounds(180, 80, 180, 25);
		
		
		
		
		
		if (op == 1  ) {
			
			this.janela.add(labelNumero);
			this.janela.add(valorNumero);
			this.janela.add(labelNome);
			this.janela.add(valorNome);
			this.janela.add(labelNascimento);
			this.janela.add(valorNascimento);
			this.janela.add(labelInicio);
			this.janela.add(valorInicio);
			this.janela.add(labelFinal);
			this.janela.add(valorFinal);
			this.janela.add(labelSintomas);
			this.janela.add(valorSintomas);
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoSalvar.setBackground(Color.pink);
			botaoSalvar.setForeground(Color.black);
			botaoExcluir.setBounds(245, 175, 115, 30);
			botaoExcluir.setBackground(Color.RED);
			botaoExcluir.setForeground(Color.white);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
			
		}

	
		this.janela.add(labelNumero);
		this.janela.add(valorNumero);
		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelNascimento);
		this.janela.add(valorNascimento);
		this.janela.add(labelInicio);
		this.janela.add(valorInicio);
		this.janela.add(labelFinal);
		this.janela.add(valorFinal);
		this.janela.add(labelSintomas);
		this.janela.add(valorSintomas);		
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
				if(opcao == 1) //cadastro de novo ciclo
					novoDado[0] = Integer.toString(dados.getQtdCiclos());
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);						
				
				

				if (opcao == 1) 
					novoDado[1] =  valorNumero.getText();
				    novoDado[2] =  valorNome.getText();
				    novoDado[3] =  valorInicio.getText();
				    novoDado[4] =  valorFinal.getText();
				    novoDado[5] =  valorSintomas.getText();
				    novoDado[6] =  valorNascimento.getText();
				    
					res = dados.inserirEditarCiclos(novoDado);
				
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
				res = dados.removerCiclo(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusao(); 
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
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	

}