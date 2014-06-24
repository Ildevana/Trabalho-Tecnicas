package Negocio;

import java.util.List;

/**
 * 
 *  @author Ildevana
 * 
 */
public abstract class CategoriaDAO {

	public abstract void inserir(Categoria cat);

	public abstract void alterar(Categoria cat);

	public abstract void excluir(Categoria cat);

	public abstract Categoria buscarPorId(int cat);

	public abstract List<Categoria> buscarTodas();

}
