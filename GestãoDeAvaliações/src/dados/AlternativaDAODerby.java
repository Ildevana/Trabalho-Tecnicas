/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import Negocio.Alternativa;
import Negocio.AlternativaDAO;
import Negocio.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AlternativaDAODerby implements AlternativaDAO {

    @Override
    public void inserir(Alternativa alt) throws DAOException {
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "INSERT INTO ALTERNATIVAS (ID_ITEMAVAL, SQ_ALTERNATIVA,TEXTO,CORRETA) VALUES (?,?,?,?)";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, alt.getIdItemAval());
            sta.setInt(2, alt.getSq_alternativa());
            sta.setString(3, alt.getTexto());
            sta.setInt(4, (alt.isCorreta() ? 1 : 0));
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
    public List<Alternativa> buscarTodasDoItem(int item) throws DAOException {
        List<Alternativa> alts = new LinkedList<>();
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_ITEMAVAL, SQ_ALTERNATIVA,TEXTO,CORRETA FROM ALTERNATIVAS WHERE ID_ITEMAVAL = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, item);
            ResultSet res = sta.executeQuery();
            while (res.next()) {
                alts.add(new Alternativa(res.getInt("ID_ITEMAVAL"), res.getInt("SQ_ALTERNATIVA"), res.getString("TEXTO"), res.getInt("CORRETA") == 1));
            }
            res.close();
            con.close();
            return alts;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public Alternativa buscarCorretaDoItem(int item) throws DAOException {
        Alternativa alts = null;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_ITEMAVAL, SQ_ALTERNATIVA,TEXTO,CORRETA FROM ALTERNATIVAS WHERE ID_ITEMAVAL = ? AND CORRETA = 1";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, item);
            ResultSet res = sta.executeQuery();
            if (res.next()) {
                alts = new Alternativa(res.getInt("ID_ITEMAVAL"), res.getInt("SQ_ALTERNATIVA"), res.getString("TEXTO"), res.getInt("CORRETA") == 1);
            }
            res.close();
            con.close();
            return alts;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

}
