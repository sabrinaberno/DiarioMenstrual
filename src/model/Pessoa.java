package model;

public class Pessoa {		
		private String nome;
		private String dtNascimento;		
	
	public Pessoa(String nome, String dtNascimento) {
		
		this.nome = nome;
		this.dtNascimento = dtNascimento;	
		
				
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public  String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento( String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [Nome= "+ nome +", Nascimento= "+ dtNascimento +" ]";
	}
}
	
