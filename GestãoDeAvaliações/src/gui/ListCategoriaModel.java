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

    private List<Object> texto;

    public ListCategoriaModel() {
        super();
        this.texto = new ArrayList<>();
    }

    public ListCategoriaModel(List<Categoria> dados) {
        this.texto = new ArrayList<>();
        if (dados != null) {
            texto.addAll(dados);
        }
    }

    @Override
    public int getSize() {
        return texto.size();
    }

    @Override
    public String getElementAt(int index) {
        return texto.get(index).toString();
    }

}
