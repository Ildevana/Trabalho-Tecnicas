/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.Categoria;
import Negocio.DAOException;
import Negocio.ItemAval;
import Negocio.Prova;
import Negocio.SistemaFachada;
import java.util.List;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author lasaro
 */
public class ProvaController {

    private SistemaFachada sis;

    public ProvaController() {
        sis = new SistemaFachada();
    }

    public TableModel getAvaliacoesAbertas() {
        try {
            List<Prova> provasAbertas = sis.avaliacoesDisponiveis();
            ProvaTableModel pTM = new ProvaTableModel(provasAbertas);
            for (Prova prova : provasAbertas) {
                List<Categoria> cats = sis.buscarCategoriasProva(prova.getIdProva());
                for (Categoria c : cats) {
                    System.out.println("cat: " + c);
                }
                //break;
            }
            return pTM.getTableModel();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public String inserir(List<Categoria> cats, String nomeProf, int qtQuestoes, boolean aberta) throws DAOException {
        String hash = sis.criarProva(cats, nomeProf, qtQuestoes, aberta);
        return hash;
    }

    public TableModel getProvasPorCategorias(List<Categoria> cats) {
        try {
            List<Prova> provasAbertas = sis.avaliacoesDisponiveis(cats);
            ProvaTableModel pTM = new ProvaTableModel(provasAbertas);
            return pTM.getTableModel();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public Queue<ItemAval> getFilaQuestoes(Prova p) throws Exception {
        return sis.getFilaQuestoes(p);
    }

    public Prova buscarProvaPorId(int idProva) throws DAOException {
        return sis.buscarProvaPorId(idProva);
    }
}
