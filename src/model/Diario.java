package model;

import java.util.ArrayList;


import model.database.DatabaseProvider;

public class Diario {
	
	private final ArrayList<Ciclo> ciclos;
	
	public Diario() {	
	this.ciclos= new ArrayList<>();
	
	DatabaseProvider.getCiclos().add(new Ciclo());
	
	}

	public ArrayList<Ciclo> getCiclos() {
		return ciclos;
	}

	
}
	
