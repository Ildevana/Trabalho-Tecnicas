package Negocio;

import java.util.List;

public interface AlunoDAO {

    public void inserir(Aluno a) throws DAOException;

    public Aluno buscarPorId(int idAluno) throws DAOException;

    public List<Aluno> buscarTodos() throws DAOException;

}
