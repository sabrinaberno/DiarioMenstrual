package model;


public class Sintoma_fisico extends Sintoma{
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
	
	
	public enum Nome_sintoma_fisico {
		DOR, SENSIBILIDADE, COLICA, SANGRAMENTO, PRISAO_VENTRE, DIARREIA, INDIGESTAO, ACNE, INCHACO;
	}
	
	/*public Sintoma_fisico () {
		
	} */
	
	public Sintoma_fisico (Enum <> local_corpo, Enum <> Nome_sintoma_fisico ) {
		//descobrir como chamar um enum
		super (data_cadastro);
		
	}
	// https://www.w3schools.com/java/java_enums.asp
	
	public void getLocal_corpo (){
		System.out.println("Locais do corpo:");
		for(Local_corpo locais: Local_corpo.values()){
			System.out.println(locais);
		}
	}
	
	
}
