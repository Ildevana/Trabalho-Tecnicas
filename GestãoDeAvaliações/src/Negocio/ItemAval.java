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
public class ItemAval {
    private int itemAval;
    private String enumuciado;
    private Alternativas itemAlternativas;

    public ItemAval(int itemAval, String enumuciado, Alternativas itemAlternativas) {
        this.itemAval = itemAval;
        this.enumuciado = enumuciado;
        this.itemAlternativas = itemAlternativas;
    }

    public int getItemAval() {
        return itemAval;
    }

    public String getEnumuciado() {
        return enumuciado;
    }

    public Alternativas getItemAlternativas() {
        return itemAlternativas;
    }

    public void setItemAval(int itemAval) {
        this.itemAval = itemAval;
    }

    public void setEnumuciado(String enumuciado) {
        this.enumuciado = enumuciado;
    }

    public void setItemAlternativas(Alternativas itemAlternativas) {
        this.itemAlternativas = itemAlternativas;
    }
    
    
    
    
    
}
