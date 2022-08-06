package model;

import java.util.Scanner;


public class Sintoma_mental extends Sintoma {
	
	private enum Nome_sintoma_mental {
		DESEQUILIBRADA(1), ESTRESSADA(2), MAL_HUMORADA(3), CALMA(4), ANSIOSA(5), ALEGRE(6), APATICA(7), SONOLENTA(8), 
		DESEJO_SALGADO(9), DESEJO_DOCE(10), AMOROSA(11),SENSIVEL(12), INSEGURA(13), INSONIA(14), VERTIGEM(15);
		
		private final int valor;
		
		Local_corpo(int valor){
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}
	
	}
	
	public Sintoma_mental () {
		
	}
	
	//private Scanner ler = new Scanner(System.in);// Para os metodos
	
	
	// Metodo Construtor de Usuario
	public Sintoma_mental (enum Nome_sintoma_mental) {
		super(data_do_cadastro, intensidade);
		this.Nome_sintoma_mental = Nome_sintoma_mental;
	}
	
	// Getters e Setters
	public enum getNome_sintoma_mental() {
		return nome_sintoma_mental;
	}
	
	public void setNome_sintoma_mental(enum Nome_sintoma_mental) {
		this.Nome_sintoma_mental = Nome_sintoma_mental;
	}
}
