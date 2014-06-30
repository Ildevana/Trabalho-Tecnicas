/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import Negocio.DAOException;
import Negocio.Resposta;
import Negocio.RespostaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RespostaDAODerby implements RespostaDAO {

    @Override
    public void inserir(Resposta resposta) throws DAOException {
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "INSERT INTO RESPOSTAS (ID_PROVA, ID_ITEMAVAL,ALTERNATIVA_MARCADA,ID_ALUNO) VALUES (?,?,?,?)";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, resposta.getIdProva());
            sta.setInt(2, resposta.getIdItemAval());
            sta.setInt(3, resposta.getAlternativaMarcada());
            sta.setInt(4, resposta.getIdAluno());
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
    public List<Resposta> buscarPorProva(int idProva) throws DAOException {
        List<Resposta> resps = null;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_PROVA, ID_ITEMAVAL,ALTERNATIVA_MARCADA,ID_ALUNO FROM RESPOSTAS WHERE ID_PROVA = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, idProva);
            ResultSet res = sta.executeQuery();
            while (res.next()) {
                resps.add(new Resposta(res.getInt("ID_ITEMAVAL"), res.getInt("ID_PROVA"), res.getInt("ALTERNATIVA_MARCADA"), res.getInt("ID_ALUNO")));
            }
            res.close();
            con.close();
            return resps;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

}
