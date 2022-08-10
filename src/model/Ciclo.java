package model;

public class Ciclo {
  // Atributos
  private String data_inicial;
  private int duracao;
  private String dia_final_menstruacao;
  
  // Metodo Construtor de Ciclo
  public Ciclo () {
	  
  }
  
  	public Ciclo (String data_inicial, int duracao, String dia_final_menstruacao, String previsao_ovulacao ) {
		
  		this.data_inicial = data_inicial;
		this.duracao = duracao;
		this.dia_final_menstruacao = dia_final_menstruacao;
		
	}
	// Getters e Setters
	public String getData_inicial() {
		return data_inicial;
	}
	public void setData_incial(String data_incial) {
		this.data_inicial = data_incial;
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
}