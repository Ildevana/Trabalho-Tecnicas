package Negocio;

import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class GeradorFilaQuestoes {

    private Queue<ItemAval> gerarFilaProvaFechada(Prova prova) throws DAOException, Exception {
        SistemaFachada sis = new SistemaFachada();
        List<Categoria> cats = sis.buscarCategoriasProva(prova.getIdProva());
        List<ItemAval> itens = sis.buscarItensPorCategorias(cats);
        if (itens.size() < prova.getQtdProva()) {
            throw new Exception("Quantidade de itens para a prova insuficiente");
        }

        Queue<ItemAval> filaItens = new ArrayBlockingQueue<>(prova.getQtdProva());

        Collections.shuffle(itens);
        for (int i = 0; i < prova.getQtdProva(); i++) {
            ItemAval item = itens.get(i);
            item.setOrdemAlternativasAleatoria();
            filaItens.add(item);
        }
        
        return filaItens;
    }

    private Queue<ItemAval> gerarFilaProvaAberta(Prova prova) throws DAOException, Exception {
        SistemaFachada sis = new SistemaFachada();
        List<Categoria> cats = sis.buscarCategoriasProva(prova.getIdProva());
        List<ItemAval> itens = sis.buscarItensPorCategorias(cats);
        if (itens.size() < prova.getQtdProva()) {
            throw new Exception("Quantidade de itens para a prova insuficiente");
        }

        Queue<ItemAval> filaItens = new ArrayBlockingQueue<>(prova.getQtdProva());

        Collections.shuffle(itens);
        for (int i = 0; i < prova.getQtdProva(); i++) {
            ItemAval item = itens.get(i);
            item.setOrdemAlternativasTexto();
            filaItens.add(item);
        }
        
        return filaItens;
    }

    public Queue<ItemAval> gerarFilaProva(Prova prova) throws DAOException, Exception {
        if (prova.isAberta()) {
            return gerarFilaProvaAberta(prova);
        }
        return gerarFilaProvaFechada(prova);
    }

}
