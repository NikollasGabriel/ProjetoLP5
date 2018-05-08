/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import State.AlunoEstado;

/**
 *
 * @author asus note
 */
public class Aluno extends Pessoa {

    private int numeroFaltas;
    private float mediaNotas;
    private AlunoEstado situacao;
    
    public Aluno() {
    }

    public Aluno(int idPessoa) {
        super(idPessoa);
    }

    public Aluno(int numeroFaltas, float mediaNotas, String nomePessoa, int idadePessoa, Turma turma) {
        super(nomePessoa, idadePessoa, turma);
        this.numeroFaltas = numeroFaltas;
        this.mediaNotas = mediaNotas;
    }

    public Aluno(int numeroFaltas, float mediaNotas, int idPessoa, String nomePessoa, int idadePessoa, Turma turma) {
        super(idPessoa, nomePessoa, idadePessoa, turma);
        this.numeroFaltas = numeroFaltas;
        this.mediaNotas = mediaNotas;
    }

    public int getNumeroFaltas() {
        return numeroFaltas;
    }

    public void setNumeroFaltas(int numeroFaltas) {
        this.numeroFaltas = numeroFaltas;
    }

    public float getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(float mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    public AlunoEstado getSituacao() {
        return situacao;
    }

    public void setSituacao(AlunoEstado situacao) {
        this.situacao = situacao;
    }
        
}
