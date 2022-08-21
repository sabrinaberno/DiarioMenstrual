package model;



public class SintomaFisico extends Sintoma {
	public enum LocalCorpo {
		COSTAS(1), CABECA(2), ARTICULACAO(3), SEIO(4), UTERO(5), BARRIGA(6), ESTOMAGO(7), ROSTO(8), CORPO_INTEIRO(9); 

		private final int valor;
		
		LocalCorpo(int valor){
			this.valor = valor;
		}

		int getValor() {
			return valor;
		}
		
		
		public static void display (int valor) {
			LocalCorpo constant[] = LocalCorpo.values();
		}
	}
	
	
	public enum NomeSintomaFisico {
		DOR(1), SENSIBILIDADE(2), COLICA(3), SANGRAMENTO(4), PRISAO_VENTRE(5), DIARREIA(6), INDIGESTAO(7), ACNE(8), INCHACO(9);
		
		private final int valor;
		
		NomeSintomaFisico(int valor){
			this.valor = valor;
		}

		int getValor() {
			return valor;
		}
		

		public static void display (int valor) {
			NomeSintomaFisico constant[] = NomeSintomaFisico.values();
		}
	
	}
	private LocalCorpo localCorpo; 
	private static NomeSintomaFisico NomeSintomaFisico;
	
	public LocalCorpo getLocalCorpo() {
		return localCorpo;
	}
	public void setLocalCorpo(LocalCorpo localCorpo) {
		this.localCorpo = localCorpo;
	}
	public static NomeSintomaFisico getNomeSintomaFisico() {
		return NomeSintomaFisico;
	}
	public static void setNomeSintomaFisico(NomeSintomaFisico nomeSintomaFisico) {
		NomeSintomaFisico = nomeSintomaFisico;
	}
	
	@Override
	public String toString() {
		return "Sintoma" + NomeSintomaFisico + "no" + localCorpo;
	}

	
	
}
