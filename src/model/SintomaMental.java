package model;


public class SintomaMental extends Sintoma {	

	
	public enum NomeSintomaMental {
		DESEQUILIBRADA(1), ESTRESSADA(2), MAL_HUMORADA(3), CALMA(4), ANSIOSA(5), ALEGRE(6), APATICA(7), SONOLENTA(8), 
		DESEJO_SALGADO(9), DESEJO_DOCE(10), AMOROSA(11),SENSIVEL(12), INSEGURA(13), INSONIA(14), VERTIGEM(15);
		
		private final int valor;
		
		NomeSintomaMental(int valor){
			this.valor = valor;
		}

		int getValor() {
			return valor;
		}
		
		
		public static void display (int valor) {
			
		}
	
	}
	private NomeSintomaMental NomeSintomaMental;
	public NomeSintomaMental getNomeSintomaMental() {
		return NomeSintomaMental;
	}
	public void setNomeSintomaMental(NomeSintomaMental nomeSintomaMental) {
		NomeSintomaMental = nomeSintomaMental;
	}
	
	@Override
	public String toString() {
		return "Sintoma mental" + NomeSintomaMental;
	}

}
