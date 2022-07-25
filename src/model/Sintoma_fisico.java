package model;

public class Sintoma_fisico extends Sintoma {

	// estudar Enum
	
	private Enum<?> dores;
	private Enum<?> alteracoes_fisicas;
	
	
	
	public Enum<?> getAlteracoes_fisicas() {
		return alteracoes_fisicas;
	}
	public void setAlteracoes_fisicas(Enum<?> alteracoes_fisicas) {
		this.alteracoes_fisicas = alteracoes_fisicas;
	}
	public Enum<?> getDores() {
		return dores;
	}
	public void setDores(Enum<?> dores) {
		this.dores = dores;
	}
	
	
}
