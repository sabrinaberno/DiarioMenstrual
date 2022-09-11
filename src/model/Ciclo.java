package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que contem os atributos de um ciclo
 * 
 * @author Mylena e Sabrina.
 * @since 2022
 * @version 1.0
 */
public class Ciclo {
	private String numero;
	private int duracao;	
	private ArrayList<String> nomeSintomaFisico;
	private ArrayList<String> nomeSintomaMental;
	private Date dataInicioMenstruacao;
	private Date dataFinalMenstruacao;
	
	

	/**
	 * Gera um ciclo
	 * 
	 * @param numero              	 indicador para contabilizar o número de ciclos cadstrados
	 * @param duraco			  	 duração do ciclo
	 * @param dataFinalMenstruacao 	 último dia da menstruação        
	 * @param dataInicioMenstruacao  primeiro dia da menstruação e do ciclo      
	 * @param nomeSintomaFisico      sintomas físicos relacionados ao ciclo     
	 * @param nomeSintomaMental      sintomas físicos relacionados ao ciclo
	 */
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
