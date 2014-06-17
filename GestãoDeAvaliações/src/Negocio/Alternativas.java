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
public class Alternativas {
    private int idAlternativas;
    private ItemAval idItem;
    private String resCorreta;

    public Alternativas(int idAlternativas, ItemAval idItem, String resCorreta) {
        this.idAlternativas = idAlternativas;
        this.idItem = idItem;
        this.resCorreta = resCorreta;
    }

    public int getIdAlternativas() {
        return idAlternativas;
    }

    public ItemAval getIdItem() {
        return idItem;
    }

    public String getResCorreta() {
        return resCorreta;
    }

    public void setIdAlternativas(int idAlternativas) {
        this.idAlternativas = idAlternativas;
    }

    public void setIdItem(ItemAval idItem) {
        this.idItem = idItem;
    }

    public void setResCorreta(String resCorreta) {
        this.resCorreta = resCorreta;
    }
    
    
}
