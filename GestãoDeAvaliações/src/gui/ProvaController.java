/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.Categoria;
import Negocio.DAOException;
import Negocio.Prova;
import Negocio.SistemaFachada;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author lasaro
 */
public class ProvaController {

    SistemaFachada sis;

    public ProvaController() {
        sis = new SistemaFachada();
    }

    public TableModel getAvaliacoesAbertas() {
        try {
            List<Prova> provasAbertas = sis.buscarProvasAbertas();
            ProvaTableModel pTM = new ProvaTableModel(provasAbertas);
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
}
