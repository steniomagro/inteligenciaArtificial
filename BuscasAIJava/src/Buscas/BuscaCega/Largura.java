package Buscas.BuscaCega;

import espacoDeEstados.Estado;
import espacoDeEstados.Puzzle8;
import estrategiasDeBusca.cega.BuscaCega;
import estrategiasDeBusca.cega.BuscaEmLargura;

public class Largura {
	
	public void largura() {

		// char[] cfgIni = {' ','2','3','1','4','6','7','5','8'}; // no menor
		// char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'}; 
		//char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

		char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
		
		char[] cfgFim = {'1', '2', '3', '4', '5','6', '7','8' ,' '};
		
		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( cfgFim );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
				
		BuscaCega l = new BuscaEmLargura();
		
		l.setInicio(puzzleInicial);
		l.setObjetivo(puzzleFinal);
		l.buscar();

		if(l.getCaminhoSolucao().isEmpty())
			System.out.println("Nao foi achada uma solucao!");
						
		for(Estado e: l.getCaminhoSolucao()) {
			System.out.println(e);
		}
	}
}
