package model;

public abstract class Sintoma {
	private String dtCadastro;
	public enum Intensidade{
    	FRACA(1), RAZOAVEL(2), INSUPORTAVEL(3);
    	
    	private final int valor;
		
    	Intensidade(int valor){
			this.valor = valor;
		}

		int getValor() {
			return valor;
		}
		
		public static void display (int valor) {
			
		}
		
    }

	public String getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(String dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	

}
