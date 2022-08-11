package model;

public class BancoDados {
    
     private static List<Ciclo> ciclos = new ArrayList<Ciclo>();
 
    /*
     * Ciclos
     */

    public static List<Ciclo> getCiclos() {
        return ciclos;
    }

    public static void addCiclo(Ciclo ciclo){
        ciclos.add(ciclo);
    }

    public static void atualizaCiclo(int linhaSelecionada,Ciclo ciclo){
       ciclos.set(linhaSelecionada, ciclo);
    }

    public static void removeCiclo(Ciclo ciclo){
        ciclos.remove(ciclos);
    }
    
}
