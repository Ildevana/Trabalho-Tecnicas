package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 *
 */
public interface ProvaDAO {

    public List<Prova> buscarTodas();

    public Prova buscarPorId(int idProva);

    public void inserir(Prova prova);

    public List<ItemAval> getItens(int idProva);

    public Prova buscarPorHash(String hashProva);

}
