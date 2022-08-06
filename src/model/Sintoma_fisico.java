package model;


public class Sintoma_fisico extends Sintoma {
//criando uma classe filha Sintoma Físico que herda de Sintoma
	
// https://docs.microsoft.com/pt-br/dotnet/api/system.enum?view=net-6.0
	
	private enum Local_corpo {
		COSTAS(1), CABECA(2), ARTICULACAO(3), SEIO(4), UTERO(5), BARRIGA(6), ESTOMAGO(7), ROSTO(8), CORPO_INTEIRO(9); 
	
		private final int valor;
		
		Local_corpo(int valor){
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}
	}
	
	
	private enum Nome_sintoma_fisico {
		DOR(1), SENSIBILIDADE(2), COLICA(3), SANGRAMENTO(4), PRISAO_VENTRE(5), DIARREIA(6), INDIGESTAO(7), ACNE(8), INCHACO(8);
	
		private final int valor;
		
		Nome_sintoma_fisico(int valor){
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}
	}
	
	
	public Sintoma_fisico () {
		
	}
	
	public Sintoma_fisico (Enum <> Local_corpo, Enum <> Nome_sintoma_fisico ) {
		//descobrir como chamar um enum
		super (data_cadastro, intensidade);
		this.Local_corpo = Local_corpo;
		this.Nome_sintoma_fisico = Nome_sintoma_fisico;
		
		
	}
	
	// https://www.w3schools.com/java/java_enums.asp
	
	public void getLocal_corpo (){
		System.out.println("Locais do corpo:");
		for(Local_corpo locais: Local_corpo.values()){
			System.out.println(locais);
		}
	}
	
	
}
