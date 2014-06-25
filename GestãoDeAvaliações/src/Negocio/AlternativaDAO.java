package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 *
 */
public interface AlternativaDAO {

    public void inserir(Alternativa alt);

    public List<Alternativa> buscarTodasDoItem(int item);

    public Alternativa buscarCorretaDoItem(int item);

}
