/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.Prova;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author lasaro
 */
class ProvaTableModel {

    private DefaultTableModel model;

    ProvaTableModel(List<Prova> provas) {
        Object[][] matriz = new Object[provas.size()][];
        for (int i = 0; i < matriz.length; i++) {
            Object[] objects = new Object[4];
            final Prova p = provas.get(i);
            objects[0] = p.getIdProva();
            objects[1] = p.getNomeProf();
            objects[2] = p.getIdProva();
            JButton b = new JButton();
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "ID prova: " + p.getIdProva(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            objects[3] = b;

            matriz[i] = objects;

        }
        model = new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "ID", "Professor", "Qtd. Questões", ""
                }
        );
    }

    public TableModel getTableModel() {
        return model;
    }
}
