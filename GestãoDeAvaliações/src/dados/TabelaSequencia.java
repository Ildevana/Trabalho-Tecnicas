/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author lasaro
 */
public enum TabelaSequencia {

    ItemAval("ITEMAVAL", "ID_ITEMAVAL"),
    Alternativa("ALTERNATIVAS", "ID_ITEMAVAL"),
    Aluno("ALUNOS", "ID_ALUNO"),
    Categoria("CATEGORIA", "ID_CATEGORIA"),
    Prova("PROVA", "ID_PROVA");
    String tab;
    String camp;

    private TabelaSequencia(String tabela, String campo) {
        tab = tabela;
    }

    public String getSQLTable() {
        return tab;
    }

    public String getSQLField() {
        return camp;
    }

    public String getTable() {
        return "";
    }
}
