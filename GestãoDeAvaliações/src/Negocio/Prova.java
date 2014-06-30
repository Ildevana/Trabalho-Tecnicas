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
    private boolean aberta;
    private String nomeProf;
    private int qtdProva;
    private String hash;

    public Prova(int idProva, boolean aberta, String nomeProf, int qtdProva, String hash) {
        this.idProva = idProva;
        this.aberta = aberta;
        this.nomeProf = nomeProf;
        this.qtdProva = qtdProva;
        this.hash = hash;
    }

    public int getIdProva() {
        return idProva;
    }

    public String getNomeProf() {
        return nomeProf;
    }

    public int getQtdProva() {
        return qtdProva;
    }

    private void setId_Prova(int id_Prova) {
        this.idProva = id_Prova;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    public void setQtdProva(int qtdProva) {
        this.qtdProva = qtdProva;
    }

    /**
     * @return the aberta
     */
    public boolean isAberta() {
        return aberta;
    }

    /**
     * @param aberta the aberta to set
     */
    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

}
