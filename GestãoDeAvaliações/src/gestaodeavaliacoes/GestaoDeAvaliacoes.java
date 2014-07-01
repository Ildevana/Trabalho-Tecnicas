/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaodeavaliacoes;

import Negocio.ItemAval;
import gui.CadastrarProva;
import gui.CadastroCategoria;
import gui.CadastroItemAval;
import gui.ItemAvaliacao;
import gui.SelecaoProva;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ildevana
 */
public class GestaoDeAvaliacoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            //InicializadorBancoDados.criarBd();//já criado :D
            //new CadastrarProva().setVisible(true);
            //new SelecaoProva().setVisible(true);
            //new CadastroCategoria().setVisible(true);
            new CadastroItemAval().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GestaoDeAvaliacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
