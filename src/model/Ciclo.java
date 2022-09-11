package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que armazena as informa��es de um filme.
 * 
 * @author Eduardo Rodrigues
 */
public class Ciclo {
	private String numero;
	private int duracao;	
	private ArrayList<String> nomeSintomaFisico;
	private ArrayList<String> nomeSintomaMental;
	private Date dataInicioMenstruacao;
	private Date dataFinalMenstruacao;
	
	

	/**
	 * Gera um filme, nomeAtores recebe uma nova ArrayList em branco.
	 * 
	 * @param nome                 nome do filme
	 * @param mesesDesenvolvimento numero de meses de desenvolvimento
	 * @param anoLancamento        ano do lancamento
	 * @param numCopyright         numero de copyright do filme
	 * @param custoTotal           custo total de producao
	 * @param diretor              diretor do filme
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
