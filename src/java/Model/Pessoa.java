package Model;

public abstract class Pessoa {

    private int idPessoa;
    private String nomePessoa;
    private int idadePessoa;
    private Turma turma;

    public Pessoa() {
    }

    public Pessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoa(String nomePessoa, int idadePessoa, Turma turma) {
        this.nomePessoa = nomePessoa;
        this.idadePessoa = idadePessoa;
        this.turma = turma;
    }

    public Pessoa(int idPessoa, String nomePessoa, int idadePessoa, Turma turma) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.idadePessoa = idadePessoa;
        this.turma = turma;
    }
        
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public int getIdadePessoa() {
        return idadePessoa;
    }

    public void setIdadePessoa(int idadePessoa) {
        this.idadePessoa = idadePessoa;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
