package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 *
 */
public interface AlternativaDAO {

    public void inserir(Alternativa alt) throws DAOException;

    public List<Alternativa> buscarTodasDoItem(int item) throws DAOException;

    public Alternativa buscarCorretaDoItem(int item) throws DAOException;

}
