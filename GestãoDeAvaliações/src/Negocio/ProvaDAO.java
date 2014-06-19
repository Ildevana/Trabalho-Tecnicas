/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.util.List;

/**
 *
 * @author Ildevana
 */
public abstract class ProvaDAO {
        abstract List<Prova> buscarTodas() throws DAOException;
	abstract Prova buscarPorId(int idProva) throws DAOException;
	abstract void inserir(Prova prova) throws DAOException;
	abstract void alterar(Prova prova) throws DAOException;
        abstract List<ItemAval> getItens(int idProva) throws DAOException;
}
