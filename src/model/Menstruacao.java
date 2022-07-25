package model;

import java.util.Date;

public class Menstruacao {

	private Date dt_menstruacao;
	private Enum<?> intensidade;
	
	
	
	public Enum<?> getIntensidade() {
		return intensidade;
	}
	public void setIntensidade(Enum<?> intensidade) {
		this.intensidade = intensidade;
	}
	
	
	public Date getDt_menstruacao() {
		return dt_menstruacao;
	}
	public void setDt_menstruacao(Date dt_menstruacao) {
		this.dt_menstruacao = dt_menstruacao;
	}
	
}
