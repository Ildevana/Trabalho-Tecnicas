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
public class ProvaDAO {
        List<Prova> buscarTodas() throws DAOProvaException;
	Prova buscarPorId(int idProva) throws DAOProExcevaption;
	void inserir(Prova prova) throws DAOProvaException;
	void alterar(Prova prova) throws DAOProvaException;
    
}
