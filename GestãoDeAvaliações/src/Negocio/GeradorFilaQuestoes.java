package Negocio;

import java.util.Queue;

public class GeradorFilaQuestoes {

    private Queue<ItemAval> gerarFilaProvaFechada(Prova prova) {
        return null;
    }

    private Queue<ItemAval> gerarFilaProvaAberta(Prova prova) {
        return null;
    }

    public Queue<ItemAval> gerarFilaProva(Prova prova) {
        if(prova.isAberta())
            return gerarFilaProvaAberta(prova);
        return gerarFilaProvaFechada(prova);
    }

}
