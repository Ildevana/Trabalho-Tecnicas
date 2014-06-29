package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 *
 */
public interface ProvaDAO {

    public void inserir(Prova prova) throws DAOException;

    public void addCategoria(int idProva, int cat) throws DAOException;

    public Prova buscarPorId(int idProva) throws DAOException;

    public Prova buscarPorHash(String hashProva) throws DAOException;

    public List<Prova> buscarAbertas() throws DAOException;

}
