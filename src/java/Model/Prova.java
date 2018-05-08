package Model;

public class Prova {

    private int idProva;
    private float valor;
    private Aluno aluno;
    private Disciplina disciplina;

    public Prova() {
    }

    public Prova(int idProva) {
        this.idProva = idProva;
    }

    public Prova(int idProva, float valor, Aluno aluno, Disciplina disciplina) {
        this.idProva = idProva;
        this.valor = valor;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Prova(float valor, Aluno aluno, Disciplina disciplina) {
        this.valor = valor;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public int getIdProva() {
        return idProva;
    }

    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
