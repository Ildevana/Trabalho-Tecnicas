package Negocio;

import dados.AlternativaDAODerby;
import dados.AlunoDAODerby;
import dados.CategoriaDAODerby;
import dados.GerenciadorBancoDados;
import dados.ItemAvalDAODerby;
import dados.ProvaDAODerby;
import dados.RespostaDAODerby;
import dados.TabelaSequencia;
import java.util.List;
import java.util.Queue;

public class SistemaFachada {

    AlternativaDAO altDAO;
    AlunoDAO aluDAO;
    CategoriaDAO catDAO;
    ItemAvalDAO itemDAO;
    ProvaDAO provaDAO;
    RespostaDAO respDAO;

    public SistemaFachada() {
        altDAO = new AlternativaDAODerby();
        aluDAO = new AlunoDAODerby();
        catDAO = new CategoriaDAODerby();
        itemDAO = new ItemAvalDAODerby();
        provaDAO = new ProvaDAODerby();
        respDAO = new RespostaDAODerby();
    }

    public void validarItemAvaliacao(ItemAval item) {

    }

    public void associarCategoriaItemAval(int idItem, int idCat) throws DAOException {
        itemDAO.addCategoria(idItem, idCat);
    }

    public String criarProva(List<Categoria> categorias, String nomeProf, int qtQuestoes, boolean aberta) throws DAOException {
        int id = GerenciadorBancoDados.getSequenciaTabela(TabelaSequencia.Prova);

        Prova p = new Prova(id, aberta, nomeProf, qtQuestoes, gerarHash(id));

        provaDAO.inserir(p);

        for (Categoria cat : categorias) {
            provaDAO.addCategoria(id, cat.getCat());
        }

        return p.getHash();
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

    public void gravarRespostas(List<Resposta> respostas, Aluno aluno) {

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

    private String gerarHash(int id) {
        return "" + (new Integer(id).hashCode());
    }

}
