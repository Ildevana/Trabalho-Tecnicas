package Negocio;

public class Aluno {

    private int idAluno;
    private String nome;

    public Aluno(int idAluno, String nome) {
        this.idAluno = idAluno;
        this.nome = nome;
    }

    /**
     * @return the idAluno
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
