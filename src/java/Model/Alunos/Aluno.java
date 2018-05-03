/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Alunos;

import Model.Alunos.AlunoEstado;
import Model.Alunos.AlunoEstadoMatriculado;
import Model.Prova;
import java.util.Observable;
import java.util.Observer;
import Model.Pessoa;
/**
 *
 * @author Aluno
 */
public class Aluno extends Pessoa implements Observer{
    private AlunoEstado estado;
    
    private Observable prova;
    private float novaProva;
    
    public Aluno(){
        this.estado = new AlunoEstadoMatriculado();
    }
    
    public Aluno(Observable prova){
        this.prova = prova;
        prova.addObserver(this);
    }

    
    //A intenção aqui seria avisar essa nova prova para o aluno, mas seria interessante vincular com disciplina
    //por isso dei uma modificada nas classes
    //tenta dar uma arrumada
    //poderiamos usar essa logica de estar matriculado e tals para receber o aviso ou não
    @Override
    public void update(Observable provaSubject, Object arg1) {
        if(provaSubject instanceof Prova){
            Prova prova = (Prova) provaSubject;
            setNovaProva(prova.getValor());
            
        }
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

    /**
     * @return the prova
     */
    public Observable getProva() {
        return prova;
    }

    /**
     * @param prova the prova to set
     */
    public void setProva(Observable prova) {
        this.prova = prova;
    }

    /**
     * @return the novaProva
     */
    public float getNovaProva() {
        return novaProva;
    }

    /**
     * @param novaProva the novaProva to set
     */
    public void setNovaProva(float novaProva) {
        this.novaProva = novaProva;
    }
}
