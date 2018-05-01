package Memento;

import Model.Nota;

public class NotaMemento {

    private Nota estado;

    public NotaMemento(Nota notaSalvar) {
        estado = notaSalvar;
    }

    public Nota getNotaSalva() {
        return estado;
    }

    @Override
    public String toString() {
        return ("" + estado.getValor());
    }

}
