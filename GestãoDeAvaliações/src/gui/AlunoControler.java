/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import Negocio.SistemaFachada;
import javax.swing.JComboBox;

/**
 *
 * @author Ildevana
 */
public class AlunoControler {
    private SistemaFachada fachada;
    private ListaAlunoModel listaAluno;
    
    public AlunoControler(){
        fachada = new SistemaFachada();
        //listaAluno = new ListaAlunoModel(toListString(fachada.buscarAlunoPorId(idAluno));
        //fachada.addCadastroListener(listaAluno);
    }

    
}
