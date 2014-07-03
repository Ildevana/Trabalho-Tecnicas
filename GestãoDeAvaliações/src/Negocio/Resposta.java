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
    private int idAluno;

    public Resposta(int idItemAval, int idProva, int alternativaMarcada, int idAluno) {
        this.idItemAval = idItemAval;
        this.idProva = idProva;
        this.alternativaMarcada = alternativaMarcada;
        this.idAluno = idAluno;
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

    /**
     * @return the idAluno
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * @param idAluno the idAluno to set
     */
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public String toString() {
        return "ID Item: " + idItemAval + " ID Prova: " + idProva + " Alt.Marcada: " + alternativaMarcada + " ID Aluno: " + idAluno;
    }

}
