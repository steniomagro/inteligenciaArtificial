package estrategiasDeBusca.cega;

import java.util.ArrayList;
import java.util.List;

import espacoDeEstados.Estado;

/**
 * Esta classe modela os aspectos fundamentais de uma estrat�gia de busca cega,
 * sendo respons�vel por explorar o espa�o de estados a partir de um estado
 * inicial e construir uma �rvore busca atrav�s da expans�o de seus nodos. A
 * forma como a explora��o do espa�o acontece � peculiar a cada tipo de busca,
 * assim busca � uma especializa��o desta classe e deve implementar sua estrat�gia.
 * 
 * @author Leandro Fernandes
 *
 */
public abstract class BuscaCega {
	
	protected String nomeDaEstrategia;	// nome da estrat�gia de busca utilizada
	protected Estado<?> eInicial;		// representa o estado inicial da busca
	protected Estado<?> eObjetivo;		// representa um estado do problema que contenha os objetivos ou seja, em si mesmo, a meta para a busca.
	protected List<Estado<?>> caminho; // cont�m o caminho da solu��o desde a raiz (inicio) 
	
	/**
	 * Construtor padr�o.
	 */
	public BuscaCega() {
		this(null,null);
	}
	
	public BuscaCega(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		this.nomeDaEstrategia = "Busca cega";
		eInicial = estadoInicial;
		eObjetivo = estadoMeta;
		caminho = new ArrayList<Estado<?>>();
	}

	/**
	 * Recupera o nome da estrat�gia de busca.
	 * @return nome da estrat�gia de busca
	 */
	public String getNomeDaEstrategia() {
		return nomeDaEstrategia;
	}
	
	/**
	 * Define o estado inicial da busca, isto �, o ponto de partida do processo
	 * @param estadoInicial um dos estados poss�veis do problema
	 */
	public void setInicio(Estado<?> estadoInicial) {
		this.eInicial = estadoInicial;
	}
	
	/**
	 * Define o estado objetivo para o processo de busca, sendo por dado por um
	 * estado que apresente os objetivos desejados ou que seja, em si mesmo, um
	 * estado meta. 
	 * @param estadoMeta um estado poss�vel do problema que atende os objetivos
	 */
	public void setObjetivo(Estado<?> estadoMeta) {
		this.eObjetivo = estadoMeta;
	}
	
	/**
	 * Recupera o estado considerado como meta para a busca, aquele que cont�m
	 * ou atende os objetivos estabelecidos para o processo de busca.
	 * @return um estado solu��o para o problema apresentado.
	 */
	public Estado<?> getObjetivo() {
		return eObjetivo;
	}
	
	/**
	 * M�todo que realiza a explora��o do espa�o de busca, tomando como partida
	 * o estado inicial e seguindo, estado ap�s estado, na constru��o do caminho
	 * que leva a um estado solu��o (objetivo).
	 */
	public abstract void buscar();
	
	/**
	 * Recupera o caminho correspondente a solu��o encontrada pela busca.
	 * @return
	 */
	public List<Estado<?>> getCaminhoSolucao() {
		return caminho;
	}
	
}