package model;


public class Sintoma_fisico extends Sintoma{
//criando uma classe filha Sintoma Físico que herda de Sintoma
	
// https://docs.microsoft.com/pt-br/dotnet/api/system.enum?view=net-6.0
	
	public enum Local_corpo {
		COSTAS(1), CABECA(2), ARTICULACAO(3), SEIO(4), UTERO(5), BARRIGA(6), ESTOMAGO(7), ROSTO(8), CORPO_INTEIRO(9); 

		private final int valor;
		
		Local_corpo(int valor){
			this.valor = valor;
		}

		int getValor() {
			return valor;
		}
		
		//Método Static para display o sintoma
		public static void display (int valor) {
			Local_corpo constant[] = Local_corpo.values();
		}
	}
	
	
	public enum Nome_sintoma_fisico {
		DOR(1), SENSIBILIDADE(2), COLICA(3), SANGRAMENTO(4), PRISAO_VENTRE(5), DIARREIA(6), INDIGESTAO(7), ACNE(8), INCHACO(9);
		
		private final int valor;
		
		Nome_sintoma_fisico(int valor){
			this.valor = valor;
		}

		int getValor() {
			return valor;
		}
		
		//Método Static para display o sintoma
		public static void display (int valor) {
			Nome_sintoma_fisico constant[] = Nome_sintoma_fisico.values();
		}
	
	}
	
	private Local_corpo local_corpo; 
	private Nome_sintoma_fisico nome_sintoma_fisico;
	// https://www.w3schools.com/java/java_enums.asp
	
	public Local_corpo getLocal_corpo() {
		// Nome_sintoma_mental constant[] = Nome_sintoma_mental.values();
		return local_corpo;
	}
	
	public void setLocal_corpo(Local_corpo local_corpo) {
		this.local_corpo = local_corpo;
		
	}
		
	public Nome_sintoma_fisico getNome_sintoma_fisico() {
		// Nome_sintoma_mental constant[] = Nome_sintoma_mental.values();
		return nome_sintoma_fisico;
	}
	
	public void setNome_sintoma_fisico(Nome_sintoma_fisico nome_sintoma_fisico) {
		this.nome_sintoma_fisico = nome_sintoma_fisico;
		
	}
}
