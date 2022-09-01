package model;

	/**
	 * Classe Ciclo simula o comportamento do ciclo menstrual e nela está agregado SintomaMental
	 *e SintomaFisico, já com Pessoa é uma associação simples.
	 * @author Mylena e Sabrina.
	 * @since 2022
	 * @version 2.0
	 **/


public class Ciclo {
	
	private Pessoa pessoa;
	private String dataInicioMenstruacao;
	private String dataFinalMenstruacao;
	private int duracaoCiclo;
	private SintomaMental sintomaMental;
	private SintomaFisico sintomaFisico;
	private String numero;
	
	
	
	
	public Ciclo(Pessoa p, String i, String f, int d, SintomaMental m, SintomaFisico s) {
		dataInicioMenstruacao = i;
		dataFinalMenstruacao = f;
		duracaoCiclo = d; 
		sintomaMental = m;
		sintomaFisico = s;
	}

	public Ciclo(String string, String string2, int parseInt, String string3, int parseInt2) {
		// TODO Auto-generated constructor stub
	}

	

	public void cadastrar() {
		int qtd;
		String numero = "Ciclo ";
		Ciclo c = this;
		SintomaFisico f = this.getSintomaFisico();
		qtd = f.getNumSintomas();
		f.setNumSintomas(qtd+1);
		SintomaMental m = this.getSintomaMental();
		qtd = m.getNumSintomas();
		m.setNumSintomas(qtd+1);
		c.setPessoa(pessoa);
		c.setDataFinalMenstruacao(dataFinalMenstruacao);
		c.setDataInicioMenstruacao(dataInicioMenstruacao);
		c.setDuracaoCiclo(qtd);
		c.setNumero(numero);
	}


	public final String getNumero() {
		return numero;
	}



	public final void setNumero(String numero) {
		this.numero = numero;
	}



	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public  String getDataInicioMenstruacao() {
		return dataInicioMenstruacao;
	}


	public void setDataInicioMenstruacao(String dataInicioMenstruacao) {
		this.dataInicioMenstruacao = dataInicioMenstruacao;
	}


	public  String getDataFinalMenstruacao() {
		return dataFinalMenstruacao;
	}


	public void setDataFinalMenstruacao(String dataFinalMenstruacao) {
		this.dataFinalMenstruacao = dataFinalMenstruacao;
	}

	public int getDuracaoCiclo() {
		return duracaoCiclo;
	}


	public  void setDuracaoCiclo(int duracaoCiclo) {
		this.duracaoCiclo = duracaoCiclo;
	}


	public  SintomaMental getSintomaMental() {
		return sintomaMental;
	}


	public void setSintomaMental(SintomaMental sintomaMental) {
		this.sintomaMental = sintomaMental;
	}


	public SintomaFisico getSintomaFisico() {
		return sintomaFisico;
	}

	public void setSintomaFisico(SintomaFisico sintomaFisico) {
		this.sintomaFisico = sintomaFisico;
	}



	
	public String toString() {
		return "Ciclo" +numero+ "d@ " + pessoa.getNome() + "teve início em: " + dataInicioMenstruacao+ ", com duração de " + duracaoCiclo+
				". Assim " + dataFinalMenstruacao+ "foi o último dia.";
	}

	
}