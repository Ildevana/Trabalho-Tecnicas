/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import Negocio.Aluno;
import Negocio.AlunoDAO;
import Negocio.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlunoDAODerby implements AlunoDAO {

    @Override
    public void inserir(Aluno a) throws DAOException {
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "INSERT INTO ALUNOS (ID_ALUNO, NOME_ALUNO) VALUES (?,?)";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, a.getIdAluno());
            sta.setString(2, a.getNome());
            sta.executeUpdate();
            sta.close();
            con.close();
        } catch (SQLException ex) {
            throw new DAOException("Falha ao inserir. " + ex.getMessage());
        } catch (Exception ex) {
            throw new DAOException("Falha ao inserir. " + ex.getMessage());
        }
    }

    @Override
    public Aluno buscarPorId(int idAluno) throws DAOException {
        Aluno aluno = null;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_ALUNO, NOME_ALUNO FROM ALUNOS WHERE ID_ALUNO = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, idAluno);
            ResultSet res = sta.executeQuery();
            if (res.next()) {
                aluno = new Aluno(idAluno, res.getString("NOME_ALUNO"));
            }
            res.close();
            con.close();
            return aluno;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public List<Aluno> buscarTodos() throws DAOException {
        List<Aluno> alunos = null;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_ALUNO, NOME_ALUNO FROM ALUNOS";
            PreparedStatement sta = con.prepareStatement(sql);
            ResultSet res = sta.executeQuery();
            while (res.next()) {
                alunos.add(new Aluno(res.getInt("ID_ALUNO"), res.getString("NOME_ALUNO")));
            }
            res.close();
            con.close();
            return alunos;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

}
