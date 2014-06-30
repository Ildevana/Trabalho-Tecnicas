package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 *
 */
public interface RespostaDAO {

    public void inserir(Resposta resposta) throws DAOException;

    public List<Resposta> buscarPorProva(int idProva) throws DAOException;

}
