package Model;

public class Turma {

    private int idTurma;
    private String periodoTurma;
    private int tamanhoTurma;
    private Disciplina disciplina;
    private Coordenador coordenador;

    public Turma() {
    }

    public Turma(int idTurma, String periodoTurma, int tamanhoTurma, Disciplina disciplina, Coordenador coordenador) {
        this.idTurma = idTurma;
        this.periodoTurma = periodoTurma;
        this.tamanhoTurma = tamanhoTurma;
        this.disciplina = disciplina;
        this.coordenador = coordenador;
    }

    public Turma(String periodoTurma, int tamanhoTurma, Disciplina disciplina, Coordenador coordenador) {
        this.periodoTurma = periodoTurma;
        this.tamanhoTurma = tamanhoTurma;
        this.disciplina = disciplina;
        this.coordenador = coordenador;
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

    /**
     * @return the coordenador
     */
    public Coordenador getCoordenador() {
        return coordenador;
    }

    /**
     * @param coordenador the coordenador to set
     */
    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

}
