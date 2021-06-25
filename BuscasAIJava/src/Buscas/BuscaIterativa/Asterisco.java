package Buscas.BuscaIterativa;

import espacoDeEstados.*;
import estrategiasDeBusca.heuristica.*;

public class Asterisco {

    public void asterisco(){
		char[] cfgIni = {' ','2','3','1','4','6','7','5','8'}; 
		// char[] cfgIni = {' ','2','3','1','4','6','7','5','8'}; 
		// char[] cfgIni = {'1', '2', '3', '4', '5','6','8', '7',' '};

		char[] cfgFim = {'1', '2', '3', '4', '5','6','7', '8',' '}; 
		
		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( cfgFim );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
	
		BuscaInformada a = new AStar();

		a.setInicio(puzzleInicial);
		a.setObjetivo(puzzleFinal);
		a.buscar();

		// if(a.getCaminhoSolucao().isEmpty())	
		// 	System.out.println("Nao foi achada uma solucao!");
						
		for(Estado e: a.getCaminhoSolucao()) {
			System.out.println(e);
		}
    }
}
