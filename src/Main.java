import model.Sintoma_fisico.*;

import java.util.* ;
//import javax.swing.WindowConstants;


public class Main {
	
	public static void main(String[] args) {
	/*	Home home = new Home();
		home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		home.setVisible(true);
	*/
		
		
	    //listando os locais do corpo
		System.out.println("Locais do corpo:");
		for(Local_corpo locais: Local_corpo.values()){
			System.out.println(locais);
		}
	
		System.out.println("Digite o local do corpo para cadastrar um sintoma fisico:");
		Scanner corpo = new Scanner(System.in);

		//listando os nomes das dores fisicas
		System.out.println("\n Nome bla bla bla");
		for(Nome_sintoma_fisico nome_fisico : Nome_sintoma_fisico.values()){
			System.out.println(nome_fisico);
		}
	
		
			/*Local_corpo myVar = Local_corpo.SEIO; 
	    System.out.println(myVar);
			 */
	}	
}