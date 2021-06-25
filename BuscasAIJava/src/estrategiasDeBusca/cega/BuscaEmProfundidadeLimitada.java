package estrategiasDeBusca.cega;

import java.util.Collections;
import java.util.List;

import espacoDeEstados.Estado;

/**
 * Esta classe implementa uma estrat�gia de busca cega conhecida como "Busca em
 * Profundidade", que � caracter�stica por explorar o espa�o se aprofundando no
 * ramo atual antes de faz�-lo noutra ramifica��o.
 * 
 * @author Leandro C. Fernandes
 *
 */
public class BuscaEmProfundidadeLimitada extends BuscaEmProfundidade {
	
	private int limite;

	/**
	 * Construtor padr�o.
	 */
	public BuscaEmProfundidadeLimitada() {
		this(null,null,10);
	}
	
	/**
	 * Cria uma nova inst�ncia de Busca em Profundidade, definindo os estados
	 * inicial e objetivo para o processo, al�m do limite de aprofundamento.
	 * @param estadoInicial estado inicial de busca.
	 * @param estadoMeta estado que cont�m os objetivos da busca.
	 * @param nivelLimite n�vel m�ximo de aprofundamento da �rvore.
	 */
	public BuscaEmProfundidadeLimitada(Estado<?> estadoInicial, Estado<?> estadoMeta, int nivelLimite) {
		super(estadoInicial,estadoMeta);
		super.nomeDaEstrategia = "Busca em Profundidade Limitada (at� " + limite + " n�veis)";
		this.limite = nivelLimite;
	}
	
	/**
	 * Retorna o n�vel m�ximo de aprofundamento definido para o processo de busca.
	 * @param limite n�vel m�ximo de aprofundamento da �rvore.
	 */
	public int getLimite() {
		return limite;
	}

	/**
	 * Define o n�vel m�ximo de aprofundamento que um ramo ser� explorado.
	 * @param limite n�vel m�ximo de aprofundamento da �rvore.
	 */
	public void setLimite(int limite) {
		this.limite = limite;
	}

	/**
	 * Implementa efetivamente a estrat�gia de busca, iniciando a explora��o do
	 * espa�o a partir do estado inicial e seguindo n�vel a n�vel no ramo atual
	 * at� alcan�ar um estado que atenda os objetivos ou n�o tenha sucessor.
	 * Ao t�rmino, o caminho correspondente a solu��o ter� sido armazenado no
	 * atributo caminho.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			if (eCorrente.getNivel() < limite)
				for (Estado<?> estado : (List<Estado<?>>) eCorrente.getSucessores())
					eAbertos.push(estado);
			eCorrente = eAbertos.pop();
		}
		
		// Se o la�o foi encerrado por um estado v�lido ...
		if (eCorrente != null) {
			// ent�o constru�mos o caminho da solu��o (da folha at� a raiz)
			caminho.add(eCorrente);
			while (eCorrente.getAncestral() != null) {
				eCorrente = eCorrente.getAncestral();
				caminho.add(eCorrente);
			}
			Collections.reverse(caminho);
		}
	}
	
}
