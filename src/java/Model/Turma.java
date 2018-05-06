package Model;

public class Turma {

    private Integer idTurma;
    private String periodoTurma;
    private Integer tamanhoTurma;
    private Pessoa pessoa;
    private Disciplina disciplina;

    public Turma() {
    }

    public Turma(Integer idTurma, String periodoTurma, Integer tamanhoTurma, Pessoa pessoa, Disciplina disciplina) {
        this.idTurma = idTurma;
        this.periodoTurma = periodoTurma;
        this.tamanhoTurma = tamanhoTurma;
        this.pessoa = pessoa;
        this.disciplina = disciplina;
    }
    
    public Turma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getPeriodoTurma() {
        return periodoTurma;
    }

    public void setPeriodoTurma(String nomeTurma) {
        this.periodoTurma = nomeTurma;
    }

    public Integer getTamanhoTurma() {
        return tamanhoTurma;
    }

    public void setTamanhoTurma(Integer tamanhoTurma) {
        this.tamanhoTurma = tamanhoTurma;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
