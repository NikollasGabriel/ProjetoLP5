/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author asus note
 */
public class Professor extends Pessoa {

    private int numeroFaltas;
    private String nivelEnsinoSuperior;

    public Professor() {
    }

    public Professor(int idPessoa) {
        super(idPessoa);
    }

    public Professor(int numeroFaltas, String nivelEnsinoSuperior, String nomePessoa, int idadePessoa, Turma turma) {
        super(nomePessoa, idadePessoa, turma);
        this.numeroFaltas = numeroFaltas;
        this.nivelEnsinoSuperior = nivelEnsinoSuperior;
    }

    public Professor(int numeroFaltas, String nivelEnsinoSuperior, int idPessoa, String nomePessoa, int idadePessoa, Turma turma) {
        super(idPessoa, nomePessoa, idadePessoa, turma);
        this.numeroFaltas = numeroFaltas;
        this.nivelEnsinoSuperior = nivelEnsinoSuperior;
    }

    public int getNumeroFaltas() {
        return numeroFaltas;
    }

    public void setNumeroFaltas(int numeroFaltas) {
        this.numeroFaltas = numeroFaltas;
    }

    public String getNivelEnsinoSuperior() {
        return nivelEnsinoSuperior;
    }

    public void setNivelEnsinoSuperior(String nivelEnsinoSuperior) {
        this.nivelEnsinoSuperior = nivelEnsinoSuperior;
    }

}
