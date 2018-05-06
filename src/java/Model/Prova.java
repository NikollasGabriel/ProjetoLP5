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
    private int Valor;
    private String aluno;

    public Prova(){}
    
    public Prova(int idProva, int Valor, String aluno) {
        this.idProva = idProva;
        this.Valor = Valor;
        this.aluno = aluno;
    }
    
    public Prova(int Valor, String aluno) {
        this.idProva = idProva;
        this.Valor = Valor;
        this.aluno = aluno;
    }
    
    public Prova(int idProva) {
        this.idProva = idProva;
    }
//////////////////
    /**
     * @return the Valor
     */
    public int getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(int Valor) {
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
