/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author rwspa
 */
public class Prova{
    private int idProva;
    private float Valor;
    private String aluno;
    private Disciplina disciplina;

    public Prova(int idProva, float Valor, String aluno, Disciplina disciplina) {
        this.idProva = idProva;
        this.Valor = Valor;
        this.aluno = aluno;
        this.disciplina = disciplina;
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
     * @return the Valor
     */
    public float getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    /**
     * @return the aluno
     */
    public String getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the idProva
     */
    public int getIdProva() {
        return idProva;
    }

    /**
     * @param idProva the idProva to set
     */
    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }
}
