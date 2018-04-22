/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Professores;

import Model.Professores.ProfessorEstado;
import Model.Professores.ProfessorEstadoContratado;
import Model.Pessoa;

/**
 *
 * @author rwspa
 */
public class Professor extends Pessoa{
    private ProfessorEstado estado;
    
    
    public Professor(){
        this.estado = new ProfessorEstadoContratado();
    }

    public String getEstado() {
        return estado.getEstado();
    }

    public void setEstado(ProfessorEstado estado) {
        this.estado = estado;
    }
    
    
    public String contratado(){
        return estado.contratado(this);
    }
    public String efetivar(){
        return estado.efetivar(this);
    }
    public String demitido(){
        return estado.demitido(this);
    }
    public String demissao(){
        return estado.demissao(this);
    }
}
