package Negocio;

import java.util.List;

/**
 * 
 *  @author Ildevana
 * 
 */
public abstract class ProvaDAO {

	public abstract List<Prova> buscarTodas();

	public abstract Prova buscarPorId(int idProva);

	public abstract void inserir(Prova prova);

	public abstract void alterar(Prova prova);

	public abstract List<ItemAval> getItens(int idProva);

	public abstract Prova buscarPorHash(String hashProva);

}
