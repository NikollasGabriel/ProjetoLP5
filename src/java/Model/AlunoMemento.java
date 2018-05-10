/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import State.AlunoEstado;

/**
 *
 * @author rwspa
 */
public class AlunoMemento {
    private Aluno aluno;
    
    public AlunoMemento(Aluno alunoSalvar){
        aluno = alunoSalvar;
    }
    
    public Aluno getAlunoSalvo(){
        return aluno;
    }
    
    public String toStringNomeAluno(){
        return aluno.getNomePessoa();
    }
}
