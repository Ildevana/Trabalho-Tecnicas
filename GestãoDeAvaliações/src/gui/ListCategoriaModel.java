/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author lasaro
 */
public class ListCategoriaModel extends AbstractListModel<String> {

    private List<Categoria> lista;

    public ListCategoriaModel() {
        super();
        this.lista = new ArrayList<>();
    }

    public ListCategoriaModel(List<Categoria> dados) {
        this.lista = new ArrayList<>();
        if (dados != null) {
            lista.addAll(dados);
        }
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public String getElementAt(int index) {
        return lista.get(index).toString();
    }

    public List<Categoria> getLista() {
        return lista;
    }

    public void add(Categoria cat) {
        if(lista.add(cat))
            fireContentsChanged(this, 0, getSize());
    }

    public void remove(Categoria cat) {
        if(lista.remove(cat))
            fireContentsChanged(this, 0, getSize());
    }
}
