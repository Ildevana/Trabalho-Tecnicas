package Negocio;

import java.util.List;

public interface AlunoDAO {

	public void inserir(Aluno a);

	public Aluno buscarPorId(int idAluno);

	public List<Aluno> buscarTodos();

}
