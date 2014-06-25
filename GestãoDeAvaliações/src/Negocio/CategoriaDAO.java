package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 *
 */
public interface CategoriaDAO {

    public void inserir(Categoria cat);

    public void alterar(Categoria cat);

    public void excluir(Categoria cat);

    public Categoria buscarPorId(int cat);

    public List<Categoria> buscarTodas();

}
