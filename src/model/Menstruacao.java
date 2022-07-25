package model;

import java.util.Date;

public class Menstruacao {

	private Date dt_menstruacao_inicio;
	private Date dt_menstruacao_fim;
	private Enum<?> intensidade;
	
	
	
	public Enum<?> getIntensidade() {
		return intensidade;
	}
	public void setIntensidade(Enum<?> intensidade) {
		this.intensidade = intensidade;
	}
	
	
	public Date getDt_menstruacao_inicio() {
		return dt_menstruacao_inicio;
	}
	public void setDt_menstruacao_inicio(Date dt_menstruacao_incio) {
		this.dt_menstruacao_inicio = dt_menstruacao_inicio;
	}
	
	public Date getDt_menstruacao_fim() {
		return dt_menstruacao_fim;
	}
	public void setDt_menstruacao_fim(Date dt_menstruacao_fim) {
		this.dt_menstruacao_fim = dt_menstruacao_fim;
	}
}
