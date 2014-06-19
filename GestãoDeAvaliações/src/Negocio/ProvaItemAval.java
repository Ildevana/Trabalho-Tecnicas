/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author Ildevana
 */
public class ProvaItemAval {

    private int idProva;
    private int idItemAval;

    public ProvaItemAval(int idProva, int idItemAval) {
        this.idProva = idProva;
        this.idItemAval = idItemAval;
    }

    /**
     * @return the idProva
     */
    public int getIdProva() {
        return idProva;
    }

    /**
     * @param idProva the idProva to set
     */
    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    /**
     * @return the idItemAval
     */
    public int getIdItemAval() {
        return idItemAval;
    }

    /**
     * @param idItemAval the idItemAval to set
     */
    public void setIdItemAval(int idItemAval) {
        this.idItemAval = idItemAval;
    }
    
    
}
