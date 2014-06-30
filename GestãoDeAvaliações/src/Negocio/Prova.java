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
public class Prova {
    private int idProva;
    private String tipo;
    private String nomeProf;
    private int qtdProva;
    
     public Prova(int idProva, String tipo, String nomeProf, int qtdProva) {
        this.idProva = idProva;
        this.tipo = tipo;
        this.nomeProf = nomeProf;
        this.qtdProva = qtdProva;
    }

    public int getIdProva() {
        return idProva;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNomeProf() {
        return nomeProf;
    }

    public int getQtdProva() {
        return qtdProva;
    }

    public void setId_Prova(int id_Prova) {
        this.id_Prova = id_Prova;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    public void setQtdProva(int qtdProva) {
        this.qtdProva = qtdProva;
    }
     
     
}
