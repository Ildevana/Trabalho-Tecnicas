/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

/**
 *
 * @author Ildevana
 */
public class Professor extends javax.swing.JDialog {
    private java.awt.Frame parent;
    /**
     * Creates new form Professor
     * @param parent
     * @param modal
     */
    public Professor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCriarItem = new javax.swing.JButton();
        btnCriarProva = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCriarItem.setText("Criar Item Avaliacao");
        btnCriarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarItemActionPerformed(evt);
            }
        });
        getContentPane().add(btnCriarItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 17, -1, -1));

        btnCriarProva.setText("Criar Prova");
        btnCriarProva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarProvaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCriarProva, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 40, 129, -1));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarProvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarProvaActionPerformed
        CadastrarProva cp = new CadastrarProva(parent, true);
    }//GEN-LAST:event_btnCriarProvaActionPerformed

    private void btnCriarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarItemActionPerformed
        CadastroItemAval i = new CadastroItemAval(parent, true);
    }//GEN-LAST:event_btnCriarItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarItem;
    private javax.swing.JButton btnCriarProva;
    private javax.swing.Box.Filler filler1;
    // End of variables declaration//GEN-END:variables
}
