/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import Negocio.Categoria;
import Negocio.CategoriaDAO;
import Negocio.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lasaro
 */
public class CategoriaDAODerby implements CategoriaDAO {

    @Override
    public void inserir(Categoria cat) throws DAOException {
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "INSERT INTO CATEGORIA (ID_CATEGORIA, NOME_CAT) VALUES (?,?)";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, cat.getCat());
            sta.setString(2, cat.getNome());
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
    public void alterar(Categoria cat) throws DAOException {
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "UPDATE CATEGORIA SET NOME_CAT=? WHERE ID_CATEGORIA = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setString(1, cat.getNome());
            sta.setInt(2, cat.getCat());
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
    public Categoria buscarPorId(int cat) throws DAOException {
        Categoria categoria = null;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_CATEGORIA, NOME_CAT FROM CATEGORIA WHERE ID_CATEGORIA = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, cat);
            ResultSet res = sta.executeQuery();
            if (res.next()) {
                categoria = new Categoria(cat, res.getString("NOME_CAT"));
            }
            res.close();
            con.close();
            return categoria;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public List<Categoria> buscarTodas() throws DAOException {
        List<Categoria> cats = null;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_CATEGORIA, NOME_CAT FROM CATEGORIA";
            PreparedStatement sta = con.prepareStatement(sql);
            ResultSet res = sta.executeQuery();
            while (res.next()) {
                cats.add(new Categoria(res.getInt("ID_CATEGORIA"), res.getString("NOME_CAT")));
            }
            res.close();
            con.close();
            return cats;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public List<Categoria> buscarPorProva(int idProva) throws DAOException {
        List<Categoria> cats = new LinkedList<>();;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT PROVACAT.ID_PROVA, PROVACAT.ID_CATEGORIA,CAT.NOME_CAT"
                    + " FROM PROVA_CATEGORIA PROVACAT"
                    + " LEFT JOIN CATEGORIA CAT"
                    + " ON CAT.ID_CATEGORIA = PROVACAT.ID_CATEGORIA"
                    + " WHERE PROVACAT.ID_PROVA = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, idProva);
            ResultSet res = sta.executeQuery();
            while (res.next()) {
                Categoria cat = new Categoria(res.getInt("ID_CATEGORIA"), res.getString("NOME_CAT"));
                cats.add(cat);
            }
            res.close();
            con.close();
            return cats;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

}
