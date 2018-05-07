package Model;

public class Turma {

    private int idTurma;
    private String periodoTurma;
    private int tamanhoTurma;
    private Disciplina disciplina;

    public Turma() {
    }

    public Turma(int idTurma, String periodoTurma, int tamanhoTurma, Disciplina disciplina) {
        this.idTurma = idTurma;
        this.periodoTurma = periodoTurma;
        this.tamanhoTurma = tamanhoTurma;
        this.disciplina = disciplina;
    }

    public Turma(String periodoTurma, int tamanhoTurma, Disciplina disciplina) {
        this.periodoTurma = periodoTurma;
        this.tamanhoTurma = tamanhoTurma;
        this.disciplina = disciplina;
    }

    public Turma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getPeriodoTurma() {
        return periodoTurma;
    }

    public void setPeriodoTurma(String nomeTurma) {
        this.periodoTurma = nomeTurma;
    }

    public int getTamanhoTurma() {
        return tamanhoTurma;
    }

    public void setTamanhoTurma(int tamanhoTurma) {
        this.tamanhoTurma = tamanhoTurma;
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
