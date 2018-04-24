package Model;

public class Turma {

    private Integer idTurma;
    private String nomeTurma;
    private Integer tamanhoTurma;

    public Turma() {
    }

    public Turma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Turma(Integer idTurma, String nomeTurma, Integer tamanhoTurma) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.tamanhoTurma = tamanhoTurma;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Integer getTamanhoTurma() {
        return tamanhoTurma;
    }

    public void setTamanhoTurma(Integer tamanhoTurma) {
        this.tamanhoTurma = tamanhoTurma;
    }

}
