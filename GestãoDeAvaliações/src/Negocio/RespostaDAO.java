package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 *
 */
public interface RespostaDAO {

    public List<Resposta> buscarPorProva(int idProva);

    public void inserir(Resposta resposta);

}
