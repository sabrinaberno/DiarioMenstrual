package model;

import java.util.Date;


public class Sintoma {
       
	//declarando o enum de intensidade
    public enum intensidade{
    	FRACA, RAZOAVEL, INSUPORTAVEL;
    }
    
    
    //declarando os atributos da classe pai Sintoma
    private Date data_do_cadastro;


	public Date getData_do_cadastro() {
		return data_do_cadastro;
	}


	public void setData_do_cadastro(Date data_do_cadastro) {
		this.data_do_cadastro = data_do_cadastro;
	}
    
    
}
