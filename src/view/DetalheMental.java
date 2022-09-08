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
 * Página de cadastro dos dados relativos à um sintoma mental, incluindo listar e excluir o sintoma
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0 
 */

public class DetalheMental implements ActionListener {

	private JFrame janela;
	private JLabel labelMental = new JLabel("Sintoma mental: ");
	private JTextField valorMental;
	private JLabel labelIntensidade = new JLabel("Intensidade: ");
	private JTextField valorIntensidade;
	private JLabel labelCadastro = new JLabel("Data: ");
	private JTextField valorCadastro;		
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[50];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;

	public void inserirEditar(int op, ControleDados d, 
			TelaMental telaMental, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro sintomas mentais";
		if (op == 2) s = "Detalhe sintomas mentais";
		
		

		janela = new JFrame(s);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		janela.setBounds(100, 100, 600, 600);		
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

		//Preenche dados com dados do sintoma mental clicado
		if (op == 2) {
			
			valorIntensidade = new JTextField(String.valueOf(dados.getMentais()[pos].getIntensidade()));
			valorCadastro = new JTextField(dados.getMentais()[pos].getCadastro());
			valorMental = new JTextField(dados.getMentais()[pos].getNomeMental());
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoSalvar.setBackground(Color.pink);
			botaoSalvar.setForeground(Color.black);
			botaoExcluir.setBounds(245, 175, 115, 30);
			botaoExcluir.setBackground(Color.RED);
			botaoExcluir.setForeground(Color.white);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
			
							
		
		}else { //Nao preenche com dados

			valorMental = new JTextField(200);
			valorIntensidade = new JTextField(200);
			valorCadastro = new JTextField(200);			

			botaoSalvar.setBounds(245, 175, 115, 30);
		} 
	
		
		labelIntensidade.setBounds(30, 20, 150, 25);
		valorIntensidade.setBounds(180, 20, 180, 25);
		labelCadastro.setBounds(30, 50, 150, 25);
		valorCadastro.setBounds(180, 50, 180, 25);
		labelMental.setBounds(30, 80, 150, 25);
		valorMental.setBounds(180, 80, 180, 25);
		
		
		
		
		
		if (op == 1  ) {
			
			this.janela.add(labelMental);
			this.janela.add(valorMental);
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

	
		this.janela.add(labelMental);
		this.janela.add(valorMental);
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
				if(opcao == 1)
					novoDado[0] = Integer.toString(dados.getQtdMentais());
				else 
					novoDado[0] = Integer.toString(posicao);						
				
				

				if (opcao == 1) 
					
					novoDado[1] =  valorIntensidade.getText();
					novoDado[2] =  valorCadastro.getText();					
					novoDado[3] =  valorMental.getText();
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
				res = dados.removerMental(posicao);
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
		JOptionPane.showMessageDialog(null, "ERRO AO SALVAR OS DADOS!");
				janela.dispose();
	}

	public void mensagemErroExclusaoMental() {
		JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR OS DADOS!");
				janela.dispose();
	}
	
	
}