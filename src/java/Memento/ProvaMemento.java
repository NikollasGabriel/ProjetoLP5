package Memento;

import Model.Prova;

public class ProvaMemento {

    private Prova estado;

    public ProvaMemento(Prova notaSalvar) {
        estado = notaSalvar;
    }

    public Prova getProvaSalva() {
        return estado;
    }

    @Override
    public String toString() {
        return ("" + estado.getValor());
    }

}
