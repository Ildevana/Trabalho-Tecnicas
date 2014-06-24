package Negocio;

import java.util.List;

/**
 * 
 *  @author Ildevana
 * 
 */
public abstract class RespostaDAO {

	public abstract List<Resposta> buscarPorProva(int idProva);

	public abstract void inserir(Resposta resposta);

}
