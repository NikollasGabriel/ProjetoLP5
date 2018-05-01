package Model;

import Memento.NotaMemento;
import java.util.Observable;


public class Nota extends Observable{
    private float Valor;

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }
    
    public NotaMemento saveToMemento() {
        return new NotaMemento(this);
    }

    public void restoreFromMemento(NotaMemento memento) {
        this.Valor = memento.getNotaSalva().getValor();
    }
}
