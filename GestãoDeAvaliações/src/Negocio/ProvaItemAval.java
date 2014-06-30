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

   
    private Prova idProva;
    private ItemAval item;
    private String enumenciado;
    
     public ProvaItemAval(Prova idProva, ItemAval item, String enumenciado) {
        this.idProva = idProva;
        this.item = item;
        this.enumenciado = enumenciado;
    }

    public Prova getIdProva() {
        return idProva;
    }

    public ItemAval getItem() {
        return item;
    }

    public String getEnumenciado() {
        return enumenciado;
    }

    public void setIdProva(Prova idProva) {
        this.idProva = idProva;
    }

    public void setItem(ItemAval item) {
        this.item = item;
    }

    public void setEnumenciado(String enumenciado) {
        this.enumenciado = enumenciado;
    }
     
     
    
    
}
