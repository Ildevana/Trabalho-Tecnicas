/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Ildevana
 */
public class ItemAval {

    private int idItemAval;
    private String enumuciado;
    private String comentario;
    private Queue<Alternativa> alternativas;

    public ItemAval(int idItemAval, String enumuciado, String comentario) {
        this.idItemAval = idItemAval;
        this.enumuciado = enumuciado;
        this.comentario = comentario;
        this.alternativas = null;
    }

    /**
     * @return the ID_ItemAval
     */
    public int getIdItemAval() {
        return idItemAval;
    }

    /**
     * @param ID_ItemAval the ID_ItemAval to set
     */
    private void setIdItemAval(int ID_ItemAval) {
        this.idItemAval = ID_ItemAval;
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

    public Queue<Alternativa> getAlternativas() throws DAOException {
        List<Alternativa> alts;
        if (alternativas == null) {
            alts = (new SistemaFachada()).buscarTodasAlternativasDoItem(idItemAval);

            Collections.sort(alts, new Comparator<Alternativa>() {

                @Override
                public int compare(Alternativa o1, Alternativa o2) {
                    /*Compares its two arguments for order.  Returns a negative integer,
                     * zero, or a positive integer as the first argument is less than, equal
                     * to, or greater than the second.*/
                    if (o1.getSq_alternativa() < o2.getSq_alternativa()) {
                        return -1;
                    } else if (o1.getSq_alternativa() > o2.getSq_alternativa()) {
                        return 1;
                    }

                    return 0;
                }
            });

            alternativas = new ArrayBlockingQueue<>(6);

            for (int i = 0; i < alts.size(); i++) {
                Alternativa alternativa = alts.get(i);
                alternativas.add(alternativa);
            }
        }

        return alternativas;
    }

    public void setOrdemAlternativasAleatoria() throws DAOException {
        List<Alternativa> alts = (new SistemaFachada()).buscarTodasAlternativasDoItem(idItemAval);

        Collections.shuffle(alts);

        alternativas = new ArrayBlockingQueue<>(6);

        for (int i = 0; i < alts.size(); i++) {
            Alternativa alternativa = alts.get(i);
            alternativas.add(alternativa);
        }
    }

    public void setOrdemAlternativasTexto() throws DAOException {
        List<Alternativa> alts = (new SistemaFachada()).buscarTodasAlternativasDoItem(idItemAval);

        Collections.sort(alts, new Comparator<Alternativa>() {

            @Override
            public int compare(Alternativa o1, Alternativa o2) {
                /*Compares its two arguments for order.  Returns a negative integer,
                 * zero, or a positive integer as the first argument is less than, equal
                 * to, or greater than the second.*/
                if (o1.getTexto().length() < o2.getTexto().length()) {
                    return -1;
                } else if (o1.getTexto().length() > o2.getTexto().length()) {
                    return 1;
                }

                return 0;
            }
        });

        alternativas = new ArrayBlockingQueue<>(6);

        for (int i = 0; i < alts.size(); i++) {
            Alternativa alternativa = alts.get(i);
            alternativas.add(alternativa);
        }
    }
}
