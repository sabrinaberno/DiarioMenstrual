import java.util.Scanner;

package model;


public class Sintoma_mental extends Sintoma {
	
	public enum nome_sintoma_mental {
		DESEQUILIBRADA, ESTRESSADA, MAL_HUMORADA, CALM, ANSIOSA, ALEGRE, APATICA, SONOLENTA, DESEJO_SALGADO, DESEJO_DOCE, AMOROSA,
		SENSIVEL, INSEGURA, INSONIA, VERTIGEM;
	}
	

	private Enum nome_sintoma_mental;
	
	private Scanner ler = new Scanner(System.in);// Para os metodos
	
	// Metodo Construtor de Usuario
	public Sintoma_mental(enum nome_sintoma_mental) {
		super(data_do_cadastro, intensidade);
		this.setData_do_cadastro(data_do_cadastro);
		this.setIntensidade(intensidade);
	}
	// Getters e Setters
	public enum getNome_sintoma_mental() {
		return nome_sintoma_mental;
	}
	public void setNome_sintoma_mental(Enum []) {
		
	

}
