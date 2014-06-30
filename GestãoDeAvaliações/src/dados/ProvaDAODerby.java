package dados;

import Negocio.CategoriaDAO;
import Negocio.DAOException;
import Negocio.Prova;
import Negocio.ProvaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProvaDAODerby implements ProvaDAO {

    @Override
    public void inserir(Prova prova) throws DAOException {
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "INSERT INTO PROVA (ID_PROVA, ABERTA, NOME_PROF, QT_QUESTOES, HASH) VALUES (?,?,?,?,?)";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, prova.getIdProva());
            sta.setInt(2, (prova.isAberta() ? 1 : 0));
            sta.setString(3, prova.getNomeProf());
            sta.setInt(4, prova.getQtdProva());
            sta.setString(5, prova.getHash());
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
    public Prova buscarPorId(int idProva) throws DAOException {
        Prova prova = null;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_PROVA, ABERTA, NOME_PROF, QT_QUESTOES, HASH FROM PROVA WHERE ID_PROVA = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, idProva);
            ResultSet res = sta.executeQuery();
            if (res.next()) {
                prova = new Prova(idProva,
                        (res.getInt("ABERTA") == 1),
                        res.getString("NOME_PROF"),
                        res.getInt("QT_QUESTOES"),
                        res.getString("HASH"));
            }
            res.close();
            con.close();
            return prova;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public Prova buscarPorHash(String hashProva) throws DAOException {
        Prova prova = null;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_PROVA, ABERTA, NOME_PROF, QT_QUESTOES, HASH FROM PROVA WHERE HASH = ?";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setString(1, hashProva);
            ResultSet res = sta.executeQuery();
            if (res.next()) {
                prova = new Prova(res.getInt("ID_PROVA"),
                        (res.getInt("ABERTA") == 1),
                        res.getString("NOME_PROF"),
                        res.getInt("QT_QUESTOES"),
                        hashProva);
            }
            res.close();
            con.close();
            return prova;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public List<Prova> buscarAbertas() throws DAOException {
        List<Prova> provas = null;
        try {
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "SELECT ID_PROVA, ABERTA, NOME_PROF, QT_QUESTOES, HASH FROM PROVA WHERE ABERTA = 1";
            PreparedStatement sta = con.prepareStatement(sql);
            ResultSet res = sta.executeQuery();
            while (res.next()) {
                provas.add(new Prova(res.getInt("ID_PROVA"),
                        (res.getInt("ABERTA") == 1),
                        res.getString("NOME_PROF"),
                        res.getInt("QT_QUESTOES"),
                        res.getString("HASH")));
            }
            res.close();
            con.close();
            return provas;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }

    @Override
    public void addCategoria(int idProva, int cat) throws DAOException {
        CategoriaDAO cDAO = new CategoriaDAODerby();
        try {
            if (cDAO.buscarPorId(cat) == null) {
                throw new Exception("Categoria " + cat + " não encontrada.");
            }
            if (buscarPorId(idProva) == null) {
                throw new Exception("Prova " + idProva + " não encontrada.");
            }
            Connection con = GerenciadorBancoDados.conectarBd();
            String sql = "INSERT INTO PROVA_CATEGORIA (ID_PROVA, ID_CATEGORIA) VALUES (?,?)";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setInt(1, idProva);
            sta.setInt(2, cat);
            sta.executeUpdate();
            sta.close();
            con.close();
        } catch (Exception ex) {
            throw new DAOException("Falha ao inserir. " + ex.getMessage());
        }
    }

}
