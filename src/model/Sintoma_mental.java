package model;

// https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
public class Sintoma_mental extends Sintoma {
	
	public enum Nome_sintoma_mental {
		DESEQUILIBRADA(1), ESTRESSADA(2), MAL_HUMORADA(3), CALMA(4), ANSIOSA(5), ALEGRE(6), APATICA(7), SONOLENTA(8), 
		DESEJO_SALGADO(9), DESEJO_DOCE(10), AMOROSA(11),SENSIVEL(12), INSEGURA(13), INSONIA(14), VERTIGEM(15);
		
		private final int valor;
		
		Nome_sintoma_mental(int valor){
			this.valor = valor;
		}

		int getValor() {
			return valor;
		}
		
		//Método Static para display o sintoma
		public static void display (int valor) {
			Nome_sintoma_mental constant[] = Nome_sintoma_mental.values();
		}
	
	}
	
	// declarando uma variável para guardar o enum
	private Nome_sintoma_mental nome_sintoma_mental;

	// Metodo Construtor de Usuario
	public Sintoma_mental(String data_do_cadastro, Intensidade intensidade, Nome_sintoma_mental nome_sintoma_mental) {
		super(data_do_cadastro, intensidade);
		this.nome_sintoma_mental = nome_sintoma_mental;
	}
	
	// Getters e Setters
	public Nome_sintoma_mental getSintoma_mental() {
		// Nome_sintoma_mental constant[] = Nome_sintoma_mental.values();

		
		return nome_sintoma_mental;
	}
	
	public void setNome_sintoma_mental(Nome_sintoma_mental nome_sintoma_mental) {
		this.nome_sintoma_mental = nome_sintoma_mental;
		
		//
	}
}