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
        public abstract List<Prova> buscarTodas() throws DAOException;
	public abstract Prova buscarPorId(int idProva) throws DAOException;
	public abstract void inserir(Prova prova) throws DAOException;
	public abstract void alterar(Prova prova) throws DAOException;
        public abstract List<ItemAval> getItens(int idProva) throws DAOException;
}
