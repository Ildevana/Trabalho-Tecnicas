/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.Aluno;
import Negocio.AlunoDAO;
import Negocio.SistemaFachada;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Ildevana
 */
class ListaAlunoModel implements ComboBoxModel {

    List<Aluno> lista;
    Aluno selec;

    ListaAlunoModel(List<Aluno> alunos) {
        if (alunos != null) {
            lista = new ArrayList<>(alunos.size());
            lista.addAll(alunos);
        } else {
            lista = new ArrayList<>(1);
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selec = (Aluno) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selec;
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        System.out.println("Add data listener:  " + l.toString());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        System.out.println("Remove data listener:  " + l.toString());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
