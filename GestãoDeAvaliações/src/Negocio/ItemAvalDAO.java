package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 *
 */
public interface ItemAvalDAO {

    public List<ItemAval> buscarTodos() throws DAOException;

    public ItemAval buscarPorId(int idItemAval) throws DAOException;

    public void inserir(ItemAval item) throws DAOException;

    public void addCategoria(int idItemAval, int cat) throws DAOException;

    public List<Categoria> getCategorias(int idItemAval) throws DAOException;

    public List<ItemAval> buscarPorCategoria(int cat) throws DAOException;

    public List<ItemAval> buscarPorCategorias(List<Integer> cat) throws DAOException;

    public int gerarNovaSeqAlternativa(int idItemAval) throws DAOException;
}
