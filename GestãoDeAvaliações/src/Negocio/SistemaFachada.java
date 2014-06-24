package Negocio;

import java.util.List;
import java.util.Queue;

public class SistemaFachada {

    public void validarItemAvaliacao(ItemAval item) {

    }

    public void associarCategoriaItemAval(int idItem, int idCat) {

    }

    public String criarProva(List<Categoria> categorias, int qtQuestoes, boolean aberta) {
        return null;
    }

    public Queue<ItemAval> getFilaQuestoes(Prova prova) {
        return null;
    }

    public List<Prova> avaliacoesDisponiveis() {
        return null;
    }

    public List<Prova> avaliacoesDisponiveis(List<Categoria> categorias) {
        return null;
    }

    public void gravarRespostas(List<Resposta> respostas) {

    }

    public Prova buscarProvaFechada(String hash) {
        return null;
    }

    public String relatorioUso() {
        return null;
    }

    public String resultadosAvaliacao(int idProva) {
        return null;
    }

}
