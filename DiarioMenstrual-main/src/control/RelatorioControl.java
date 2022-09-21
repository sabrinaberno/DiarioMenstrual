package control;

import java.util.ArrayList;
import java.util.List;




import model.Ciclo;
import model.Dados;
import model.SintomaFisico;
import model.SintomaMental;
import view.TelaMenu;



/**
 * Classe auxiliar que cont�m a l�gica por tr�s da classe RelatorioFilmes.
 * 
 * @author Eduardo Rodrigues
 * 
 * @see RelatorioFilmes
 * @see RelatorioFilmesHelper
 */
public class RelatorioControl {


	
	public Object[] criarArrayCiclos() {
		List<String> modelo = new ArrayList<>();

		modelo.add(null);

		for (Ciclo ciclo : Dados.getCiclos()) {
			modelo.add(ciclo.getNumero());
		}

		return modelo.toArray();
	}
	
	public String gerarRelatorio() {
		StringBuilder modelo = new StringBuilder();

		modelo.append("Sintomas mentais:\n");

		for (SintomaMental mentalAtual : Dados.getMentais()) {
			modelo.append("    -");
			modelo.append(mentalAtual.getNome());
			modelo.append("\n");
			modelo.append(mentalAtual.getDescricao());
			modelo.append("\n");
			modelo.append(mentalAtual.getCadastro());
			modelo.append("\n");
		}

		modelo.append("\nSintomas físicos:\n");

		for (SintomaFisico fisicoAtual : Dados.getFisicos()) {
			modelo.append("    -");
			modelo.append(fisicoAtual.getNome());
			modelo.append("\n");
			modelo.append(fisicoAtual.getLocal());
			modelo.append("\n");
			modelo.append(fisicoAtual.getCadastro());
			modelo.append("\n");
			modelo.append(fisicoAtual.getIntensidade());
			modelo.append("\n");
		}

		return modelo.toString();
		
	}

		public void executarBotao(Object botaoSelecionado) {
			view.Relatorio.getFieldRelatorio().setText("");
			
			TelaMenu.main(null);
		}

		
	
}
