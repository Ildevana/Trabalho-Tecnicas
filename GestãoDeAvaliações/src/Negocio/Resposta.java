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
public class Resposta {
    private int idItemAval;
    private int idProva;
    private int alternativaMarcada;

    public Resposta(int idItemAval, int idProva, int alternativaMarcada) {
        this.idItemAval = idItemAval;
        this.idProva = idProva;
        this.alternativaMarcada = alternativaMarcada;
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
     * @return the alternativaMarcada
     */
    public int getAlternativaMarcada() {
        return alternativaMarcada;
    }

    /**
     * @param alternativaMarcada the alternativaMarcada to set
     */
    public void setAlternativaMarcada(int alternativaMarcada) {
        this.alternativaMarcada = alternativaMarcada;
    }
}
