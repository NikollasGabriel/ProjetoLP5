/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Alunos;

import Model.Alunos.AlunoEstado;
import Model.Alunos.AlunoEstadoMatriculado;
import Model.Pessoa;
/**
 *
 * @author Aluno
 */
public class Aluno extends Pessoa{
    private AlunoEstado estado;
    
    
    public Aluno(){
        this.estado = new AlunoEstadoMatriculado();
    }

    public String getEstado() {
        return estado.getEstado();
    }

    public void setEstado(AlunoEstado estado) {
        this.estado = estado;
    }

    
    
    public String matricular(){
        return estado.matricular(this);
    }
    public String trancar(){
        return estado.trancar(this);
    }
    public String formar(){
        return estado.formar(this);
    }
    public String suspender(){
        return estado.suspender(this);
    }
    public String evadir(){
        return estado.evadir(this);
    }
    public String jubilar(){
        return estado.jubilar(this);
    }
}
