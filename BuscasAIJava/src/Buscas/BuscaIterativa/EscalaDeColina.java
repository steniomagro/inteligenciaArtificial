package Buscas.BuscaIterativa;

import espacoDeEstados.*;
import estrategiasDeBusca.heuristica.*;
import Buscas.BuscaIterativa.EscalaDeColina;

public class EscalaDeColina {
    
    public void escalaDeColina(){

		// char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
		char[] cfgIni = {' ','2','3','1','4','6','7','5','8'}; 
        
		char[] cfgFim = {'1', '2', '3', '4', '5','6','7', '8',' '};
		
		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( cfgFim );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
	
		BuscaInformada ec = new HillClimbing();

		ec.setInicio(puzzleInicial);
		ec.setObjetivo(puzzleFinal);
		ec.buscar();
						
		if(ec.getCaminhoSolucao().isEmpty())	
			System.out.println("Nao foi achada uma solucao!");

		for(Estado e: ec.getCaminhoSolucao()) {
			System.out.println(e);
		}
    }
}
