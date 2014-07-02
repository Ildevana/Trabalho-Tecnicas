/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import Negocio.Aluno;
import Negocio.DAOException;
import Negocio.SistemaFachada;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

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

    public ComboBoxModel getComboBoxModel(){
        try {
            List<Aluno> alunos = fachada.buscarTodosAlunos();
            return new ListaAlunoModel(alunos);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void inserirAluno(String text) throws DAOException {
        fachada.inserirAluno(text);
    }
}
