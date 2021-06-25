package Buscas.BuscaCega;

import espacoDeEstados.Estado;
import espacoDeEstados.Puzzle8;
import estrategiasDeBusca.cega.BuscaCega;
import estrategiasDeBusca.cega.BuscaEmProfundidade;

public class Profundidade {
	
	public void profundidade() {

//		char[] cfgIni = {' ','2','3','1','4','6','7','5','8'}; // extoura memoria
		char[] cfgIni = {'1','2', '3','4','5','6','7','8',' '};
		
		char[] cfgFim = {'1', '2', '3', '4', '5','6',' ', '7','8'};
		
		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( cfgFim );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
				
		BuscaCega bp = new BuscaEmProfundidade();
		
		bp.setInicio(puzzleInicial);
		bp.setObjetivo(puzzleFinal);
		bp.buscar();

		if(bp.getCaminhoSolucao().isEmpty())
			System.out.println("Nao foi achada uma solucao!");

		for(Estado e: bp.getCaminhoSolucao()) {
			System.out.println(e);
		}
	}
}
