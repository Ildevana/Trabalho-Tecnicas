/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author lasaro
 */
public class ItemAval_Categoria {
    private int id_ItemAval;
    private int id_Categoria;

    public ItemAval_Categoria(int id_ItemAval, int id_Categoria) {
        this.id_ItemAval = id_ItemAval;
        this.id_Categoria = id_Categoria;
    }

    /**
     * @return the id_ItemAval
     */
    public int getId_ItemAval() {
        return id_ItemAval;
    }

    /**
     * @param id_ItemAval the id_ItemAval to set
     */
    public void setId_ItemAval(int id_ItemAval) {
        this.id_ItemAval = id_ItemAval;
    }

    /**
     * @return the id_Categoria
     */
    public int getId_Categoria() {
        return id_Categoria;
    }

    /**
     * @param id_Categoria the id_Categoria to set
     */
    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }
    
    
}
