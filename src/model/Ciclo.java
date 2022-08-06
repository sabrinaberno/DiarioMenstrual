package model;

import java.util.Date;

public class Ciclo {
  // Atributos
  private String data_inicial;
  private int duracao;
  private String dia_final_menstruacao;
  private String previsao_ovulacao;
  
  // Metodo Construtor de Ciclo
  public Ciclo () {
	  
  }
  
  	public Ciclo (String data_incial, int duracao, String dia_final_menstruacao, String previsao_ovulacao ) {
		
  		this.data_inicila = data_inicial;
		this.duracao = duracao;
		this.dia_final_menstruacao = dia_final_menstruacao;
		this. previsao_ovulacao =  previsao_ovulacao;
		
	}
	// Getters e Setters
	public String getData_inicial() {
		return data_incial;
	}
	public void setData_incial(String data_incial) {
		this.data_incial = data_incial;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public String getDia_final_menstruacao() {
		return dia_final_menstruacao;
	}
	public void setDia_final_menstruacao(String dia_final_menstruacao) {
		this.dia_final_menstruacao = dia_final_menstruacao;
	}
  
	
