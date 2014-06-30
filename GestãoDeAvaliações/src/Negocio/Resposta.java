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
    private int idResposta;
    private Prova idProva;
    private ItemAval item;
    private String respMarcada;
    private String comentário;

    public Resposta(int idResposta, Prova idProva, ItemAval item, String respMarcada, String comentário) {
        this.idResposta = idResposta;
        this.idProva = idProva;
        this.item = item;
        this.respMarcada = respMarcada;
        this.comentário = comentário;
    }

    public int getIdResposta() {
        return idResposta;
    }

    public Prova getIdProva() {
        return idProva;
    }

    public ItemAval getItem() {
        return item;
    }

    
    public String getRespMarcada() {
        return respMarcada;
    }

    public String getComentário() {
        return comentário;
    }
    
    
    
    
    
}
