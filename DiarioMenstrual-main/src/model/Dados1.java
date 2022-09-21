package model;


public class Dados1 {
	
	private  SintomaMental[] sintomasMentais = new SintomaMental[50];
	private int qtdMentais = 0;
	private SintomaFisico [] sintomasFisicos = new SintomaFisico[50];
	private int qtdFisicos = 0;
	
	
	public void fillWithSomeData() {
		
		for(int i = 0; i < 5; i++) {
			sintomasMentais[i] = new SintomaMental("Sintoma mental"+i,"insuportável"+i,"20/05/2022"); 
					
			sintomasFisicos[i] = new SintomaFisico("Sintoma Físico"+i,(i+1), "útero"+i, "25/08/2022");
				
		}
		
		qtdMentais = 3;
		qtdFisicos = 5;
		
	}
	
	
	
	public SintomaMental[] getSintomaMentais() {
		return sintomasMentais;
	}
	
	public void setSintomaMentais(SintomaMental[] sintomasMentais) {
		this.sintomasMentais = sintomasMentais;
	}
	
	public void inserirEditarSintomasMentais(SintomaMental m, int pos) {
		this.sintomasMentais[pos] = m;
		if(pos == qtdMentais) qtdMentais++;
	}
	
	public int getQtdMentais() {
		return qtdMentais;
	}
	public void setQtdMentais(int qtdMentais) {
		this.qtdMentais = qtdMentais;
	}	
	
	public SintomaFisico[] getSintomasFisicos() {
		return sintomasFisicos;
	}
	
	public void setSintomasFisicos(SintomaFisico[] sintomasFisicos) {
		this.sintomasFisicos = sintomasFisicos;
	}
	
	public void inserirEditaSintomasFisicos(SintomaFisico f, int pos) {
		this.sintomasFisicos[pos] = f;
		if(pos == qtdFisicos) qtdFisicos++;
	}
	
	
	public int getQtdFisicos() {
		return qtdFisicos;
	}
	public void setQtdFisicos(int qtdFisicos) {
		this.qtdFisicos = qtdFisicos;
	}
	

}
