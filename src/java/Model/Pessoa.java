package Model;

public abstract class Pessoa {

    private Integer idPessoa;
    private String nomePessoa;
    private Integer idadePessoa;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoa(Integer idPessoa, String nomePessoa, Integer idadePessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.idadePessoa = idadePessoa;                        
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public Integer getIdadePessoa() {
        return idadePessoa;
    }

    public void setIdadePessoa(Integer idadePessoa) {
        this.idadePessoa = idadePessoa;
    }
}
