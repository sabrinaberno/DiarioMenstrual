package model;

import java.util.ArrayList;
import java.util.List;

import model.Ciclo;


public class DatabaseProvider {
	private static final List<Ciclo> CICLOS = new ArrayList<>();

	
	public static List<Ciclo> getCiclos() {
		return CICLOS;
		
	}
}


