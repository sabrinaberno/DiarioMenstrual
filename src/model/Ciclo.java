package model;


import java.util.Date;

/**
	 * Classe Ciclo simula o comportamento do ciclo menstrual e nela está agregado SintomaMental
	 *e SintomaFisico, já com Pessoa é uma associação simples.
	 * @author Mylena e Sabrina.
	 * @since 2022
	 * @version 2.0
	 **/


public class Ciclo {
	
	
	private Date dataInicioMenstruacao;
	private Date dataFinalMenstruacao;
	private int duracaoCiclo;
	private int numero;
	
	
	
	
	public Ciclo(Date i, Date f, int d, int n) {
		this.dataInicioMenstruacao = i;
		this.dataFinalMenstruacao = f;
		this.duracaoCiclo = d; 
		this.numero=n;
		
		}

	
	
	public Date getDataInicioMenstruacao() {
		return dataInicioMenstruacao;
	}



	public void setDataInicioMenstruacao(Date dataInicioMenstruacao) {
		this.dataInicioMenstruacao = dataInicioMenstruacao;
	}



	public Date getDataFinalMenstruacao() {
		return dataFinalMenstruacao;
	}



	public void setDataFinalMenstruacao(Date dataFinalMenstruacao) {
		this.dataFinalMenstruacao = dataFinalMenstruacao;
	}



	public int getDuracaoCiclo() {
		return duracaoCiclo;
	}



	public void setDuracaoCiclo(int duracaoCiclo) {
		this.duracaoCiclo = duracaoCiclo;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	


	public String toString() {
		return "Ciclo" +numero+  "teve início em: " + dataInicioMenstruacao+ ", com duração de " + duracaoCiclo+
				". Assim " + dataFinalMenstruacao+ "foi o último dia.";
	}

	
}