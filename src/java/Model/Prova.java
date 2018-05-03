/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Memento.ProvaMemento;
import Model.Alunos.Aluno;
import java.util.Observable;

/**
 *
 * @author rwspa
 */
public class Prova extends Observable{
    private float Valor;
    private Aluno aluno;
    private Disciplina disciplina;

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
        setChanged();
        notifyObservers();
    }
    
    public ProvaMemento saveToMemento() {
        return new ProvaMemento(this);
    }

    public void restoreFromMemento(ProvaMemento memento) {
        this.Valor = memento.getProvaSalva().getValor();
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
