package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe molde de Ciclo
 * 
 * @author Mylena e Sabrina
 */
public class Ciclo {
	private String numero;
	private int duracao;	
	private ArrayList<String> nomeSintomaFisico;
	private ArrayList<String> nomeSintomaMental;
	private Date dataInicioMenstruacao;
	private Date dataFinalMenstruacao;
	
	

	public Ciclo(String n, int d, Date i,Date f ) {
		this.numero = n;
		this.duracao = d;	
		this.dataFinalMenstruacao=f;
		this.dataInicioMenstruacao=i;
		this.nomeSintomaFisico = new ArrayList<>();
		this.nomeSintomaMental = new ArrayList<>();
		
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
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

	public List<String> getNomeSintomaFisico() {
		return nomeSintomaFisico;
	}
	
	public List<String> getNomeSintomaMental() {
		return nomeSintomaMental;
	}


}
