package Negocio;

import java.util.List;

/**
 * 
 *  @author Ildevana
 * 
 */
public interface ItemAvalDAO {

	public abstract List<ItemAval> buscarTodos();

	public abstract ItemAval buscarPorId(int idItemAval);

	public abstract void inserir(ItemAval item);

	public abstract void alterar(ItemAval item);

	public abstract void addCategoria(int idItemAval, int cat);

	public abstract List<Categoria> getCategorias(int idItemAval);

	public abstract List<ItemAval> buscarPorCategoria(int cat);

}
