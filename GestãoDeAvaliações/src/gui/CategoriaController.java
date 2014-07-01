/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.Categoria;
import Negocio.DAOException;
import Negocio.SistemaFachada;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author lasaro
 */
public class CategoriaController {

    SistemaFachada sis;

    public CategoriaController() {
        sis = new SistemaFachada();

    }

    public void inserir(String nome) throws DAOException {
        sis.inserirCategoria(nome);
    }

    public void alterarCategoria(int idCat, String nome) throws DAOException {
        sis.alterarCategoria(new Categoria(idCat, nome));
    }

    public Categoria buscarCategoriaPorId(int cat) throws DAOException {
        return sis.buscarCategoriaPorId(cat);
    }

    public List<Categoria> buscarTodas() throws DAOException {
        return sis.buscarTodasCategorias();
    }

    public ListCategoriaModel getListModel() {
        try {
            List<Categoria> cats = buscarTodas();
            return new ListCategoriaModel(cats);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public ListCategoriaModel getListModel(ListModel model, List<Integer> cats) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
