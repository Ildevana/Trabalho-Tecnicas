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

    public void inserirAlternativa(int idItemAval,String texto,boolean correta) throws DAOException{
        int sq= itemDAO.gerarNovaSeqAlternativa(idItemAval);
        Alternativa alt = new Alternativa(idItemAval, sq, texto, correta);
        altDAO.inserir(alt);
    }

    public List<Alternativa> buscarTodasAlternativasDoItem(int item) throws DAOException{
        return altDAO.buscarTodasDoItem(item);
    }

    public Alternativa buscarAlternativaCorretaDoItem(int item) throws DAOException{
        return altDAO.buscarCorretaDoItem(item);
    }

    public void inserirAluno(String nome) throws DAOException{
        int idAluno =  GerenciadorBancoDados.getSequenciaTabela(TabelaSequencia.Aluno);
        Aluno a= new Aluno(idAluno, nome);
        aluDAO.inserir(a);
    }

    public Aluno buscarAlunoPorId(int idAluno) throws DAOException{
        return aluDAO.buscarPorId(idAluno);
    }

    public List<Aluno> buscarTodosAlunos() throws DAOException{
        return aluDAO.buscarTodos();
    }

    public void inserirCategoria(String nome) throws DAOException{
        int id =  GerenciadorBancoDados.getSequenciaTabela(TabelaSequencia.Categoria);
        Categoria cat = new Categoria(id, nome);
        catDAO.inserir(cat);
    }

    public void alterarCategoria(Categoria cat) throws DAOException{
        catDAO.alterar(cat);
    }

    public Categoria buscarCategoriaPorId(int cat) throws DAOException{
        return catDAO.buscarPorId(cat);
    }

    public List<Categoria> buscarTodasCategorias() throws DAOException{
        return catDAO.buscarTodas();
    }

    public List<ItemAval> buscarTodosItens() throws DAOException{
        return itemDAO.buscarTodos();
    }

    public ItemAval buscarItemPorId(int idItemAval) throws DAOException{
        return itemDAO.buscarPorId(idItemAval);
    }

    public void inserirItem(String enumciado,String comentario) throws DAOException{
        int idItemAval = GerenciadorBancoDados.getSequenciaTabela(TabelaSequencia.ItemAval);
        ItemAval item=new ItemAval(idItemAval, enumciado, comentario);
        itemDAO.inserir(item);
    }

    public void addCategoriaItem(int idItemAval, int cat) throws DAOException{
        
    }

    public List<Categoria> getCategorias(int idItemAval) throws DAOException{
        return null;
    }

    public List<ItemAval> buscarItemPorCategoria(int cat) throws DAOException{
        return null;
    }

    public void inserirProva(Prova prova) throws DAOException{
        
    }

    public void addCategoriaProva(int idProva, int cat) throws DAOException{
        
    }

    public Prova buscarProvaPorId(int idProva) throws DAOException{
        return null;
    }

    public Prova buscarProvaPorHash(String hashProva) throws DAOException{
        return null;
    }

    public List<Prova> buscarProvasAbertas() throws DAOException{
        return null;
    }

    public List<ItemAval> buscarItensPorCategorias(List<Integer> cat) throws DAOException{
        return null;
    }

    public void inserirResposta(Resposta resposta) throws DAOException{
        
    }

    public List<Resposta> buscarRespostasPorProva(int idProva) throws DAOException{
        return null;
    }
}
