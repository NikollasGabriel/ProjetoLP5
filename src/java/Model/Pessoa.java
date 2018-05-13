package Model;

public abstract class Pessoa {

    private int idPessoa;
    private String nomePessoa;
    private int idadePessoa;

    public Pessoa() {
    }

    public Pessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoa(String nomePessoa, int idadePessoa) {
        this.nomePessoa = nomePessoa;
        this.idadePessoa = idadePessoa;
    }

    public Pessoa(int idPessoa, String nomePessoa, int idadePessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.idadePessoa = idadePessoa;
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

    
}
