/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaodeavaliacoes;

import Negocio.Categoria;
import Negocio.DAOException;
import Negocio.ItemAval;
import Negocio.Prova;
import Negocio.SistemaFachada;
import dados.GerenciadorBancoDados;
import gui.CadastrarProva;
import gui.CadastroItemAval;
import java.sql.SQLException;
import java.util.List;
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
            new CadastrarProva().setVisible(true);
            //new SelecaoProva().setVisible(true);
            //new CadastroCategoria().setVisible(true);
            //new CadastroItemAval().setVisible(true);
            listarTudo();
        } catch (Exception ex) {
            Logger.getLogger(GestaoDeAvaliacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void listarTudo() {
        try {
            SistemaFachada sis = new SistemaFachada();
            List<ItemAval> itens = sis.buscarTodosItens();
            System.out.println("Itens==============");
            for (ItemAval i : itens) {
                System.out.println(i);
            }
            List<Prova> provas = sis.buscarProvasAbertas();
            System.out.println("Provas abertas==============");
            for (Prova p : provas) {
                System.out.println(p);
                List<Categoria> cats = sis.buscarCategoriasProva(p.getIdProva());
                for (Categoria c : cats) {
                    System.out.println(c);
                }
            }
            //GerenciadorBancoDados.limparBD();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
