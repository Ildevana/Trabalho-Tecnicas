package Negocio;

import dados.RespostaDAODerby;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Gerencia {

    public String relatorioUso() {
        return null;
    }

    public String resultadosAvaliacao(int idProva) throws DAOException {
        /*Resultados de uma avaliação:
        número de alunos que realizaram, 
        número médio de acertos, 
        distribuição de acertos por alternativa, 
        etc.*/
        
        RespostaDAO respDAO = new RespostaDAODerby();
        List<Resposta> respostas = respDAO.buscarPorProva(idProva);
        Map<Integer,List<Resposta>> respPorAluno = new LinkedHashMap<>();
        for (Resposta resp : respostas) {
            if(!respPorAluno.containsKey(resp.getIdAluno()))
                respPorAluno.put(resp.getIdAluno(), new LinkedList<Resposta>());
            respPorAluno.get(resp.getIdAluno()).add(resp);
        }
        
        for (Map.Entry<Integer, List<Resposta>> entry : respPorAluno.entrySet()) {
            Integer integer = entry.getKey();
            List<Resposta> list = entry.getValue();
            
        }
        return null;
    }

}
