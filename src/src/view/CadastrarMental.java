package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import controller.ControllerMental;



/**
 * JPanel para cadastrar um filme.
 * 
 * Herda a classe JCampos que cont�m um fundo, t�tulo e dois bot�es.
 * 
 * @author Eduardo Rodrigues
 */


public class CadastrarMental extends Padrao {
	private static final long serialVersionUID = -7309653702183828956L;
	private JComboBox<Object> fieldCiclo;
	private JTextField fieldNome;
	private JTextField fieldDescricao;
	private JTextField fieldCadastro;
	private ControllerMental controller;

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	
	
private JFrame janela;
	




public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				CadastrarMental window = new CadastrarMental();
				window.janela.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
	public CadastrarMental() {
		super("Cadastre um novo sintoma mental");

		controller = new ControllerMental(this);

		JLabel labelNome = new JLabel("Nome do sintoma:");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setFont(Padrao.FONT);
		labelNome.setBounds(169, 172, 175, 13);
		add(labelNome);

		

		JLabel labelCiclo = new JLabel("Ciclo:");
		labelCiclo.setFont(Padrao.FONT);
		labelCiclo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCiclo.setBounds(82, 239, 262, 13);
		add(labelCiclo);

		JLabel labelCadastro = new JLabel("Data dia que sentiu:");
		labelCadastro.setFont(Padrao.FONT);
		labelCadastro.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCadastro.setBounds(169, 283, 175, 13);
		add(labelCadastro);

		JLabel labelDescricao = new JLabel("Descrição:");
		labelDescricao.setFont(Padrao.FONT);
		labelDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDescricao.setBounds(158, 327, 186, 13);
		add(labelDescricao);

		

		fieldNome = new JTextField();
		labelNome.setBounds(405, 169, 147, 19);
		add(fieldNome);
		fieldNome.setColumns(10);

		fieldCiclo = new JComboBox<>();
		labelCiclo.setLabelFor(fieldCiclo);
		fieldCiclo.setBounds(405, 200, 147, 21);
		fieldCiclo.setModel(controller.atualizarModelo());
		add(fieldCiclo);

		
		fieldDescricao = new JTextField();
		labelDescricao.setLabelFor(fieldDescricao);
		fieldDescricao.setBounds(405, 280, 147, 19);
		add(fieldDescricao);
		fieldDescricao.setColumns(10);

		fieldCadastro = new JTextField();
		labelCadastro.setLabelFor(fieldCadastro);
		fieldCadastro.setBounds(405, 324, 147, 19);
		add(fieldCadastro);
		fieldCadastro.setColumns(10);

		

	}

	public JComboBox<Object> getFieldCiclo() {
		return fieldCiclo;
	}


	

	public JTextField getFieldDescricao() {
		return fieldDescricao;
	}

	
	public JTextField getFieldCadastro() {
		return fieldCadastro;
	}	
	

	public JTextField getFieldNome() {
		return fieldNome;
	}

	
	public ControllerMental getController() {
		return controller;
	}

	

	/**
	 * Executa o comando para o bot�o selecionado.
	 * 
	 * implementa��o da interface ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}
}