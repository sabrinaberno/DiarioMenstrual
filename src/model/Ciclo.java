package model;

import java.util.Date;

public class Ciclo {
  // Atributos
  private Date data_inicial;
  private int duracao;
  private Date dia_final_menstruacao;
  private Date previsao_ovulacao;
  
  // Metodo Construtor de Ciclo
	public Pessoa(Date data_incial, int duracao, Date dia_final_menstruacao, Date previsao_ovulacao ) {
		this.data_inicila = data_inicial;
		this.duracao = duracao;
		this.dia_final_menstruacao = dia_final_menstruacao;
		this. previsao_ovulacao =  previsao_ovulacao;
	}
	// Getters e Setters
	public Date getData_inicial() {
		return data_incial;
	}
	public void setData_incial(Date data_incial) {
		this.data_incial = data_incial;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public Date getDia_final_menstruacao() {
		return dia_final_menstruacao;
	}
	public void setDia_final_menstruacao(Date dia_final_menstruacao) {
		this.dia_final_menstruacao = dia_final_menstruacao;
	}
  
	
