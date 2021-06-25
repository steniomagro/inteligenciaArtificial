package Buscas.BuscaCega;

import espacoDeEstados.Estado;
import espacoDeEstados.Puzzle8;
import estrategiasDeBusca.cega.BuscaEmProfundidadeLimitada;

public class ProfundidadeLimitada {
	
	public void profundidadeLimitada() {
		
		//char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'};
		// char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
		char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
		
		char[] cfgFim = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
		
		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( cfgFim );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
				
		BuscaEmProfundidadeLimitada bpl = new BuscaEmProfundidadeLimitada();
				
		bpl.setInicio(puzzleInicial);
		bpl.setObjetivo(puzzleFinal);
		bpl.setLimite(9);
		bpl.buscar();
					
		if(bpl.getCaminhoSolucao().isEmpty())
			System.out.println("Nao foi achada uma solucao!");

		for(Estado e: bpl.getCaminhoSolucao()) {
			System.out.println(e);
		}
	}
}
