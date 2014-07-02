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
import gui.CadastroCategoria;
import gui.CadastroItemAval;
import gui.SelecaoProva;
import gui.Usuario;
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
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        //break;//set as defult, but the objective is "Windows"
                    }
                    if ("Windows".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            /*
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Usuario().setVisible(true);
                }
            });
            //*/
            // TODO code application logic here
            //InicializadorBancoDados.criarBd();//já criado :D
            //new CadastrarProva().setVisible(true);
            //new SelecaoProva().setVisible(true);
            //new CadastroCategoria().setVisible(true);
            //new CadastroItemAval().setVisible(true);
            new Usuario();
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
