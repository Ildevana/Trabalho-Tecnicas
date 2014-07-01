/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.Prova;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author lasaro
 */
class ProvaTableModel {

    private DefaultTableModel model;

    ProvaTableModel(List<Prova> provas) {
        Object[][] data = new Object[provas.size()][];
        for (int i = 0; i < data.length; i++) {
            Object[] objects = new Object[3];
            final Prova p = provas.get(i);
            objects[0] = p.getIdProva();
            objects[1] = p.getNomeProf();
            objects[2] = p.getQtdQuestoes();
            data[i] = objects;
        }
        String[] header = new String[]{"ID", "Professor", "Qtd. Questões"};
        model = new DefaultTableModel(data, header);
    }

    public TableModel getTableModel() {
        return model;
    }
}
