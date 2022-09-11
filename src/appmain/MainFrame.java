package appmain;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;


import vision.CadastrarCiclo;

import vision.CadastrarFisicos;

import vision.CadastrarPessoa;
import vision.Menu;
import vision.Relatorio;
import vision.TelaEditarUsuaria;
import vision.TelaLoging;
import vision.CadastrarNovoSintomaFisico;

/**
 * A tela principal do aplicativo, JFrame que armazena todos os JPanel em seu
 * CardLayout.
 * 
 * @author Eduardo Rodrigues
 * @version 2.0
 * 
 */
public class MainFrame extends JFrame implements AncestorListener {

	private static final long serialVersionUID = 4433210214073367477L;
	private JPanel contentPane;
	private static Container cont;
	private Menu menu;
	private CadastrarCiclo cadastrarCiclo;
	private CadastrarFisicos cadastrarFisicos;
	private CadastrarNovoSintomaFisico cadastrarNovoFisicos;
	private CadastrarPessoa cadastrarPessoa;	
	private Relatorio relatorio;
	private TelaEditarUsuaria telaEditarUsuaria;
	private TelaLoging telalogin;
	private MainFrameControl controller;

	/**
	 * Executa o app.
	 * 
	 * @param args argumentos de execucao
	 */
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	/**
	 * Cria o frame com CardLayout e tamanho fixo.
	 */
	public MainFrame() {
		controller = new MainFrameControl(this);

		setTitle("App de Cadastro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/vision/images/icon.png")));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());

		menu = new Menu();
		menu.addAncestorListener(this);

		cadastrarPessoa = new CadastrarPessoa();
		cadastrarPessoa.addAncestorListener(this);

		relatorio = new Relatorio();
		relatorio.addAncestorListener(this);

		cadastrarNovoFisicos = new CadastrarNovoSintomaFisico();
		cadastrarNovoFisicos.addAncestorListener(this);

		cadastrarFisicos = new CadastrarFisicos();
		cadastrarFisicos.addAncestorListener(this);

		cadastrarCiclo = new CadastrarCiclo ();
		cadastrarCiclo.addAncestorListener(this);
		
		//telalogin = new TelaLoging ();
		//telalogin.addAncestorListener(this);
		
		
		//telaEditarUsuaria = new TelaEditarUsuaria ();
		//telaEditarUsuaria.addAncestorListener(this);
		

		getContentPane().add(menu, "menu");
		getContentPane().add(cadastrarCiclo, "cadastrarCiclo");
		getContentPane().add(cadastrarFisicos, "cadastrarFisicos");
		getContentPane().add(cadastrarNovoFisicos, "cadastrarNovoFisicos");
		getContentPane().add(relatorio, "relatorio");
		getContentPane().add(cadastrarPessoa, "cadastrarPessoa");
		//getContentPane().add(telaEditarUsuaria, "telaEditarUsuaria");
		//getContentPane().add(telalogin, "telalogin");
		
		

		cont = getContentPane();
	}

	public static Container getCont() {
		return cont;
	}

	public Menu getMenu() {
		return menu;
	}

	public CadastrarCiclo getCadastrarCiclo() {
		return cadastrarCiclo;
	}

	

	public TelaEditarUsuaria getTelaEditarUsuaria() {
		return telaEditarUsuaria;
	}

	

	

	
	public TelaLoging getTelalogin() {
		return telalogin;
	}

	
	public CadastrarFisicos getCadastrarFisicos() {
		return cadastrarFisicos;
	}


	public CadastrarNovoSintomaFisico getCadastrarNovoFisicos() {
		return cadastrarNovoFisicos;
	}

	
	public CadastrarPessoa getCadastrarPessoa() {
		return cadastrarPessoa;
	}

	
	public Relatorio getRelatorio() {
		return relatorio;
	}
	

	public MainFrameControl getController() {
		return controller;
	}

	/**
	 * Modifica algo nos Components quando eles forem mostrados pelo m�todo
	 * CardLayout.show()
	 * 
	 * � a implementa��o da interface AncestorListener
	 */
	@Override
	public void ancestorAdded(AncestorEvent event) {
		controller.mudarTela(event.getSource());
	}

	@Override
	public void ancestorRemoved(AncestorEvent event) {
		// Vazio
	}

	@Override
	public void ancestorMoved(AncestorEvent event) {
		// Vazio
	}
}