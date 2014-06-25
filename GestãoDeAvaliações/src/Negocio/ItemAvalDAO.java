package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 *
 */
public interface ItemAvalDAO {

    public List<ItemAval> buscarTodos();

    public ItemAval buscarPorId(int idItemAval);

    public void inserir(ItemAval item);

    public void addCategoria(int idItemAval, int cat);

    public List<Categoria> getCategorias(int idItemAval);

    public List<ItemAval> buscarPorCategoria(int cat);

}
