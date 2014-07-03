package Negocio;

import dados.AlternativaDAODerby;
import dados.AlunoDAODerby;
import dados.CategoriaDAODerby;
import dados.GerenciadorBancoDados;
import dados.ItemAvalDAODerby;
import dados.ProvaDAODerby;
import dados.RespostaDAODerby;
import dados.TabelaSequencia;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

        Prova p = new Prova(id, aberta, nomeProf, qtQuestoes, gerarHash(id, aberta, nomeProf));

        provaDAO.inserir(p);

        for (Categoria cat : categorias) {
            provaDAO.addCategoria(id, cat.getCat());
        }

        return p.getHash();
    }

    public Queue<ItemAval> getFilaQuestoes(Prova prova) throws Exception {
        return (new GeradorFilaQuestoes()).gerarFilaProva(prova);
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

    private String gerarHash(int id, boolean aberta, Object nomeProf) {

        int hash = 5;
        hash = 47 * hash + id;
        hash = 25 * hash + (aberta ? 1 : 0);
        hash = 32 * hash + Objects.hashCode(nomeProf);
        return "" + hash;
    }

    public void inserirAlternativa(int idItemAval, String texto, boolean correta) throws DAOException {
        int sq = itemDAO.gerarNovaSeqAlternativa(idItemAval);
        Alternativa alt = new Alternativa(idItemAval, sq, texto, correta);
        altDAO.inserir(alt);
    }

    public List<Alternativa> buscarTodasAlternativasDoItem(int item) throws DAOException {
        return altDAO.buscarTodasDoItem(item);
    }

    public Alternativa buscarAlternativaCorretaDoItem(int item) throws DAOException {
        return altDAO.buscarCorretaDoItem(item);
    }

    public void inserirAluno(String nome) throws DAOException {
        int idAluno = GerenciadorBancoDados.getSequenciaTabela(TabelaSequencia.Aluno);
        Aluno a = new Aluno(idAluno, nome);
        aluDAO.inserir(a);
    }

    public Aluno buscarAlunoPorId(int idAluno) throws DAOException {
        return aluDAO.buscarPorId(idAluno);
    }

    public List<Aluno> buscarTodosAlunos() throws DAOException {
        return aluDAO.buscarTodos();
    }

    public void inserirCategoria(String nome) throws DAOException {
        int id = GerenciadorBancoDados.getSequenciaTabela(TabelaSequencia.Categoria);
        Categoria cat = new Categoria(id, nome);
        catDAO.inserir(cat);
    }

    public void alterarCategoria(Categoria cat) throws DAOException {
        catDAO.alterar(cat);
    }

    public Categoria buscarCategoriaPorId(int cat) throws DAOException {
        return catDAO.buscarPorId(cat);
    }

    public List<Categoria> buscarTodasCategorias() throws DAOException {
        return catDAO.buscarTodas();
    }

    public List<ItemAval> buscarTodosItens() throws DAOException {
        return itemDAO.buscarTodos();
    }

    public ItemAval buscarItemPorId(int idItemAval) throws DAOException {
        return itemDAO.buscarPorId(idItemAval);
    }

    public ItemAval inserirItem(String enumciado, String comentario) throws DAOException {
        int idItemAval = GerenciadorBancoDados.getSequenciaTabela(TabelaSequencia.ItemAval);
        ItemAval item = new ItemAval(idItemAval, enumciado, comentario);
        itemDAO.inserir(item);
        return item;
    }

    public void addCategoriaItem(int idItemAval, int cat) throws DAOException {
        itemDAO.addCategoria(idItemAval, cat);
    }

    public List<Categoria> getCategoriasDoItem(int idItemAval) throws DAOException {
        return itemDAO.getCategorias(idItemAval);
    }

    public List<ItemAval> buscarItemPorCategoria(int cat) throws DAOException {
        return itemDAO.buscarPorCategoria(cat);
    }

    public List<ItemAval> buscarItensPorIdCategorias(List<Integer> cat) throws DAOException {
        return itemDAO.buscarPorCategorias(cat);
    }

    public List<ItemAval> buscarItensPorCategorias(List<Categoria> cats) throws DAOException {
        List<Integer> catIDs = new ArrayList<>();
        for (Categoria cat : cats) {
            catIDs.add(cat.getCat());
        }
        return buscarItensPorIdCategorias(catIDs);
    }

    public Prova buscarProvaPorId(int idProva) throws DAOException {
        return provaDAO.buscarPorId(idProva);
    }

    public Prova buscarProvaPorHash(String hashProva) throws DAOException {
        return provaDAO.buscarPorHash(hashProva);
    }

    public List<Prova> buscarProvasAbertas() throws DAOException {
        return provaDAO.buscarAbertas();
    }

    public void inserirResposta(int idItemAval, int idProva, int alternativaMarcada, int idAluno) throws DAOException {
        Resposta resposta = new Resposta(idItemAval, idProva, alternativaMarcada, idAluno);
        respDAO.inserir(resposta);
    }

    public List<Resposta> buscarRespostasPorProva(int idProva) throws DAOException {
        return respDAO.buscarPorProva(idProva);
    }

    public List<Categoria> buscarCategoriasProva(int idProva) throws DAOException {
        return catDAO.buscarPorProva(idProva);
    }

    public List<Prova> buscarProvasPorCategorias(List<Categoria> cats) throws DAOException {
        return provaDAO.buscarProvasAbertasPorCategorias(cats);
    }
}
