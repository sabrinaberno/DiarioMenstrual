package model;

import java.util.Date;


public abstract class Sintoma {
	
	//Atributos
	private Date data_do_cadastro;
	private enum intensidade
       
	//declarando o enum de intensidade
    public enum intensidade{
    	FRACA, RAZOAVEL, INSUPORTAVEL;
    }
    
    
	private Scanner ler = new Scanner(System.in);// Para realizar os metodos

	// Metodo Construtor de Sintoma
	public Sintoma(Date data_do_cadastro, enum intensidade, ) {
		this.data_do_cadastro =data_do_cadastro;
		this.intensidade = intensidade;
	}
	// //declarando os atributos da classe pai Sintoma
	public Date getData_do_cadastro() {
		return data_do_cadastro;
	}
	public void setData_do_cadastro(Date data_do_cadastro) {
		this.data_do_cadastro = data_do_cadastro;
	}
	public enum getIntensidade() {
		return intensidade;
	}
	public void setIntensidade(enum intensidade) {
		this.intensidade = intensidade;
	}
	
	// Metodos
	public void cadastrarSintoma() {
		System.out.print("\nQual dia é hoje");
		setData_do_cadastro(ler.nextLine());
		System.out.print("Qual é a intensiade:");
		setIntensidade(ler.nextLine());
		//setUsuario(usuario);// Chama funcao que edita o usuario
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
	}
	}
	public void editarSintoma() {
		char opcao;
		
		System.out.println("\nO que deseja editar?");
		System.out.println("\n1 -Data\n2 - Intensidade\n3 ");
		opcao = ler.next().charAt(0);
		if( (int)opcao <  || (int)opcao > )   {// Menu de escolha para o que editar dentro das infos editáveis
			System.out.println("\nNumero invalido.");
		}else {
			switch(opcao) {
				case '1':
					System.out.print("Informe a data:");
					setData_do_cadastro(ler.nextLine());
					System.out.println("Data alterada com sucesso.");
					break;
				case '2':
					System.out.print("Escolha a intensidade:");
					setIntensidade(ler.nextLine());
					System.out.println("Intensidade alterada com sucesso.");
					break;
				
			}
		}
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
	}
		
	public void deletarSintoma() {
		setData_do_cadastro(null);
		setIntensidade(null);
		
		System.out.println("\nSintoma deletado com sucesso.");
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
	}
}
