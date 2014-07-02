/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Negocio.Alternativa;
import Negocio.DAOException;
import Negocio.ItemAval;
import Negocio.SistemaFachada;
import java.util.List;

/**
 *
 * @author ildevana
 */
public class ItemAvaliacaoController {

    SistemaFachada sis;

    public ItemAvaliacaoController() {
        sis = new SistemaFachada();
    }

    public void inserirItem(String enunciado, String comentario,List<Alternativa> alts) throws DAOException {
        ItemAval item = sis.inserirItem(enunciado, comentario);
        int id = item.getIdItemAval();
        for (Alternativa a : alts) {
            sis.inserirAlternativa(id, a.getTexto(), a.isCorreta());
        }
    }
}
