package Negocio;

import java.util.List;

/**
 * 
 *  @author Ildevana
 * 
 */
public abstract class AlternativaDAO {

	public abstract void inserir(Alternativa alt);

	public abstract void alterar(Alternativa alt);

	public abstract List<Alternativa> buscarTodasDoItem(int item);

	public abstract Alternativa buscarCorretaDoItem(int item);

}
