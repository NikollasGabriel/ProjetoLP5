package Model;

import Memento.NotaMemento;
import Model.Alunos.Aluno;
import java.util.Observable;


public class Nota extends Observable{
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
    
    public NotaMemento saveToMemento() {
        return new NotaMemento(this);
    }

    public void restoreFromMemento(NotaMemento memento) {
        this.Valor = memento.getNotaSalva().getValor();
    }
}
