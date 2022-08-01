package model;


public class Sintoma_fisico extends Sintoma{
//criando uma classe filha Sintoma Físico que herda de Sintoma
	
// https://docs.microsoft.com/pt-br/dotnet/api/system.enum?view=net-6.0
	
	public enum Local_corpo {
		COSTAS, CABECA, ARTICULACAO, SEIO, UTERO, BARRIGA, ESTOMAGO, ROSTO, CORPO_INTEIRO; 
	}
	
	
	public enum Nome_sintoma_fisico {
		DOR, SENSIBILIDADE, COLICA, SANGRAMENTO, PRISAO_VENTRE, DIARREIA, INDIGESTAO, ACNE, INCHACO;
	}
	
	// https://www.w3schools.com/java/java_enums.asp
	
	/*public enum getLocal_corpo {
		System.out.println("Locais do corpo:");
		for(local_corpo locais: local_corpo.values()){
			System.out.println(locais);
		}
	} */
	
}
