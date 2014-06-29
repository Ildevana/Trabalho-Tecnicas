/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import Negocio.Categoria;
import Negocio.CategoriaDAO;
import Negocio.DAOException;
import Negocio.ItemAval;
import Negocio.ItemAvalDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lasaro
 */
public class ItemAvalDAODerby implements ItemAvalDAO {

    @Override
    public void inserir(ItemAval item) throws DAOException {
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "INSERT INTO ITEMAVAL (ID_ITEMAVAL, ENUN, COMENTARIO) VALUES (?,?,?)";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, item.getIdItemAval());
            sta.setString(2, item.getEnumuciado());
            sta.setString(3, item.getComentario());
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
    public void addCategoria(int idItemAval, int cat) throws DAOException {
        CategoriaDAO cDAO = new CategoriaDAODerby();
        try {
            if (cDAO.buscarPorId(cat) == null) {
                throw new Exception("Categoria " + cat + " não encontrada.");
            }
            if (buscarPorId(idItemAval) == null) {
                throw new Exception("Item " + idItemAval + " não encontrado.");
            }
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "INSERT INTO ITEMAVAL_CATEGORIA (ID_ITEMAVAL, ID_CATEGORIA) VALUES (?,?)";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, idItemAval);
            sta.setInt(2, cat);
            sta.executeUpdate();
            sta.close();
            con.close();
        } catch (Exception ex) {
            throw new DAOException("Falha ao inserir. " + ex.getMessage());
        }
    }

    @Override
    public List<Categoria> getCategorias(int idItemAval) throws DAOException {
        List<Categoria> cats = new LinkedList<>();;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ITEMCAT.ID_ITEMAVAL, ITEMCAT.ID_CATEGORIA,CAT.NOME_CAT"
                    + " FROM ITEMAVAL_CATEGORIA ITEMCAT"
                    + " LEFT JOIN CATEGORIA CAT"
                    + " ON CAT.ID_CATEGORIA = ITEMCAT.ID_CATEGORIA"
                    + " WHERE ITEMCAT.ID_ITEMAVAL = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, idItemAval);
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

    @Override
    public List<ItemAval> buscarTodos() throws DAOException {
        List<ItemAval> itens = new LinkedList<>();
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_ITEMAVAL, ENUN, COMENTARIO FROM ITEMAVAL";
            PreparedStatement sta = con.prepareStatement(sql);
            ResultSet res = sta.executeQuery();
            while (res.next()) {
                itens.add(new ItemAval(res.getInt("ID_ITEMAVAL"), res.getString("ENUN"), res.getString("COMENTARIO")));
            }
            res.close();
            con.close();
            return itens;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public ItemAval buscarPorId(int idItemAval) throws DAOException {
        ItemAval item = null;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_ITEMAVAL, ENUN, COMENTARIO FROM ITEMAVAL WHERE ID_ITEMAVAL = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, idItemAval);
            ResultSet res = sta.executeQuery();
            if (res.next()) {
                item = new ItemAval(idItemAval, res.getString("ENUN"), res.getString("COMENTARIO"));
            }
            res.close();
            con.close();
            return item;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public List<ItemAval> buscarPorCategoria(int cat) throws DAOException {
        List<ItemAval> itens = new LinkedList<>();;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ITEMCAT.ID_ITEMAVAL, ITEMCAT.ID_CATEGORIA,ITEM.ENUN, ITEM.COMENTARIO"
                    + " FROM ITEMAVAL_CATEGORIA ITEMCAT"
                    + " LEFT JOIN ITEMAVAL ITEM"
                    + " ON ITEM.ID_ITEMAVAL = ITEMCAT.ID_ITEMAVAL"
                    + " WHERE ITEM.ID_CATEGORIA = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, cat);
            ResultSet res = sta.executeQuery();
            while (res.next()) {
                ItemAval item = new ItemAval(res.getInt("ID_ITEMAVAL"), res.getString("ENUN"), res.getString("COMENTARIO"));
                itens.add(item);
            }
            res.close();
            con.close();
            return itens;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public List<ItemAval> buscarPorCategorias(List<Integer> cats) throws DAOException {
        List<ItemAval> itens = new LinkedList<>();;
        try {
            if (cats.isEmpty()) {
                throw new Exception("Deve ser informado pelo menos uma categoria");
            }
            Connection con = GerenciadorBancoDados.conectarBd();
            String sIN = "";
            Iterator<Integer> it = cats.iterator();
            while (it.hasNext()) {
                Integer i = it.next();
                sIN += i;
                if (it.hasNext()) {
                    sIN += ",";
                }
            }
            String sql = "SELECT ITEMCAT.ID_ITEMAVAL, ITEMCAT.ID_CATEGORIA,ITEM.ENUN, ITEM.COMENTARIO"
                    + " FROM ITEMAVAL_CATEGORIA ITEMCAT"
                    + " LEFT JOIN ITEMAVAL ITEM"
                    + " ON ITEM.ID_ITEMAVAL = ITEMCAT.ID_ITEMAVAL"
                    + " WHERE ITEM.ID_CATEGORIA IN (" + sIN + ")";
            PreparedStatement sta = con.prepareStatement(sql);

            ResultSet res = sta.executeQuery();
            while (res.next()) {
                ItemAval item = new ItemAval(res.getInt("ID_ITEMAVAL"), res.getString("ENUN"), res.getString("COMENTARIO"));
                itens.add(item);
            }
            res.close();
            con.close();
            return itens;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }
}
