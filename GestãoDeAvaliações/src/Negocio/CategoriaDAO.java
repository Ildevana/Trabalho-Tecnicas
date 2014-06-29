package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 *
 */
public interface CategoriaDAO {

    public void inserir(Categoria cat) throws DAOException;

    public void alterar(Categoria cat) throws DAOException;

    public Categoria buscarPorId(int cat) throws DAOException;

    public List<Categoria> buscarTodas() throws DAOException;
}
