/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import State.AlunoEstado;
import State.AlunoEstadoAprovadoFrequencia;
import State.AlunoEstadoAprovadoNota;
import State.AlunoEstadoNaoAvaliado;
import State.AlunoEstadoReprovadoFrequencia;
import State.AlunoEstadoReprovadoNota;

/**
 *
 * @author asus note
 */
public class Aluno extends Pessoa {

    private int numeroFaltas;
    private float mediaNotas;
    private AlunoEstado situacao;
    private Turma turma;

    public Aluno() {
    }

    public Aluno(int idPessoa) {
        super(idPessoa);
    }

    public Aluno(int numeroFaltas, float mediaNotas, String nomePessoa, int idadePessoa, Turma turma) {
        super(nomePessoa, idadePessoa);
        this.numeroFaltas = numeroFaltas;
        this.mediaNotas = mediaNotas;
        this.turma = turma;
    }

    public Aluno(int numeroFaltas, float mediaNotas, int idPessoa, String nomePessoa, int idadePessoa, Turma turma) {
        super(idPessoa, nomePessoa, idadePessoa);
        this.numeroFaltas = numeroFaltas;
        this.mediaNotas = mediaNotas;
        this.turma = turma;
    }

    public Aluno(int idPessoa, String nomePessoa, int idadePessoa, Turma turma, int numeroFaltas, float mediaNotas, String situacao) {
        super(idPessoa, nomePessoa, idadePessoa);
        this.numeroFaltas = numeroFaltas;
        this.mediaNotas = mediaNotas;
        this.turma = turma;
        switch (situacao) {
            case "Aprovado Frequencia":
                this.situacao = new AlunoEstadoAprovadoFrequencia();
                break;
            case "Aprovado Nota":
                this.situacao = new AlunoEstadoAprovadoNota();
                break;
            case "Reprovado Frequencia":
                this.situacao = new AlunoEstadoReprovadoFrequencia();
                break;
            case "Reprovado Nota":
                this.situacao = new AlunoEstadoReprovadoNota();
                break;
            case "Nao Avaliado":
                this.situacao = new AlunoEstadoNaoAvaliado();
                break;
        }
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

    /**
     * @return the turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
