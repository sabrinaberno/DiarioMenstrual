package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControllerFisico;



/**
 * JPanel para cadastrar um filme.
 * 
 * Herda a classe JCampos que cont�m um fundo, t�tulo e dois bot�es.
 * 
 * @author Eduardo Rodrigues
 */
public class CadastrarFisico extends Padrao {
	private static final long serialVersionUID = -7309653702183828956L;
	private JComboBox<Object> fieldCiclo;
	private JTextField fieldNome;
	private JTextField fieldLocal;
	private JTextField fieldIntensidade;
	private JTextField fieldCadastro;
	private ControllerFisico controller;

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	private JFrame janela;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFisico window = new CadastrarFisico();
					window.janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CadastrarFisico() {
		super("Cadastre um novo sintoma físico");

		controller = new ControllerFisico(this);

		JLabel labelNome = new JLabel("Nome do sintoma:");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setFont(Padrao.FONT);
		labelNome.setBounds(169, 172, 175, 13);
		add(labelNome);

		JLabel labelLocal = new JLabel("Local:");
		labelLocal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLocal.setFont(Padrao.FONT);
		labelLocal.setBounds(169, 204, 175, 13);
		add(labelLocal);

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

		JLabel labelIntensidade = new JLabel("Intensidade:");
		labelIntensidade.setFont(Padrao.FONT);
		labelIntensidade.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIntensidade.setBounds(158, 327, 186, 13);
		add(labelIntensidade);

		

		fieldNome = new JTextField();
		fieldNome.setBounds(405, 169, 147, 19);
		add(fieldNome);
		fieldNome.setColumns(10);

		fieldCiclo = new JComboBox<>();
		labelCiclo.setLabelFor(fieldCiclo);
		fieldCiclo.setBounds(405, 200, 147, 21);
		fieldCiclo.setModel(controller.atualizarModelo());
		add(fieldCiclo);

		fieldLocal = new JTextField();
		labelLocal.setLabelFor(fieldLocal);
		fieldLocal.setBounds(405, 236, 147, 19);
		add(fieldLocal);
		fieldLocal.setColumns(10);

		fieldIntensidade = new JTextField();
		labelIntensidade.setLabelFor(fieldIntensidade);
		fieldIntensidade.setBounds(405, 280, 147, 19);
		add(fieldIntensidade);
		fieldIntensidade.setColumns(10);

		fieldCadastro = new JTextField();
		labelCadastro.setLabelFor(fieldCadastro);
		fieldCadastro.setBounds(405, 324, 147, 19);
		add(fieldCadastro);
		fieldCadastro.setColumns(10);

		

	}

	public JComboBox<Object> getFieldCiclo() {
		return fieldCiclo;
	}


	public JTextField getFieldLocal() {
		return fieldLocal;
	}

	

	public JTextField getFieldIntensidade() {
		return fieldIntensidade;
	}

	

	public JTextField getFieldCadastro() {
		return fieldCadastro;
	}	
	

	public JTextField getFieldNome() {
		return fieldNome;
	}

	
	public ControllerFisico getController() {
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