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

    private int ID_ItemAval;
    private String enumuciado;
    private String comentario;

    public ItemAval(int ID_ItemAval, String enumuciado, String comentario) {
        this.ID_ItemAval = ID_ItemAval;
        this.enumuciado = enumuciado;
        this.comentario = comentario;
    }

    /**
     * @return the ID_ItemAval
     */
    public int getID_ItemAval() {
        return ID_ItemAval;
    }

    /**
     * @param ID_ItemAval the ID_ItemAval to set
     */
    private void setID_ItemAval(int ID_ItemAval) {
        this.ID_ItemAval = ID_ItemAval;
    }

    /**
     * @return the enumuciado
     */
    public String getEnumuciado() {
        return enumuciado;
    }

    /**
     * @param enumuciado the enumuciado to set
     */
    public void setEnumuciado(String enumuciado) {
        this.enumuciado = enumuciado;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
