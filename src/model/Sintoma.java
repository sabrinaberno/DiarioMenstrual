package model;

import java.util.Date;

public abstract class Sintoma {
	
	private Date dt_cadastro;
	private Enum<?> intensidade;

	public Enum<?> getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(Enum<?> intensidade) {
		this.intensidade = intensidade;
	}

	public Date getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	
}
