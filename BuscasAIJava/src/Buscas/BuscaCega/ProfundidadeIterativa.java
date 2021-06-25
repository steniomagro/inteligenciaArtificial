package Buscas.BuscaCega;
import java.util.List;
import java.util.Scanner;

import espacoDeEstados.Estado;
import espacoDeEstados.Puzzle8;
import estrategiasDeBusca.cega.BuscaEmProfundidadeLimitada;

public class ProfundidadeIterativa {
    
    public void profundidadeIterativa(){

		Scanner sc = new Scanner(System.in);

		int depth_ini = 0;
		int depth_end = 0;

		// char[] cfgIni = {' ','2','3','1','4','6','7','5','8'}; 
		char[] cfgIni = {' ','2','3','1','4','6','7','5','8'}; 
		// char[] cfgIni = {'1', '2', '3', '4', '5','6','', '7',' '};

		char[] cfgFim = {'1', '2', '3', '4', '5','6','7', '8',' '};
		
		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( cfgFim );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
				
		BuscaEmProfundidadeLimitada bpi = new BuscaEmProfundidadeLimitada();
		
		List<Estado<?>> path;
				
		bpi.setInicio(puzzleInicial);
		bpi.setObjetivo(puzzleFinal);

		System.out.print("Digite o valor inicial: ");
		depth_ini = sc.nextInt();

		System.out.print("Digite o valor final: ");
		depth_end = sc.nextInt();
		
		// int depth_ini = 6;
		// int depth_end = 13

		// int depth_ini = 10;
		// int depth_end = 11;
		
		for(int i=depth_ini; i<depth_end; i++) {
			bpi.setLimite(i);
			bpi.buscar();
			System.out.println("Nivel: " + i);
			path = bpi.getCaminhoSolucao();
			if(path.isEmpty())
				System.out.println("Nao foi achada uma solucao");
			else {
				for(Estado e : path) {
					System.out.println(e);
				}
				path.clear();
			}
		}	
	}
}

