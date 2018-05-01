/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Alunos;

import Model.Alunos.AlunoEstado;
import Model.Alunos.AlunoEstadoMatriculado;
import Model.Nota;
import java.util.Observable;
import java.util.Observer;
import Model.Pessoa;
/**
 *
 * @author Aluno
 */
public class Aluno extends Pessoa implements Observer{
    private AlunoEstado estado;
    
    private Observable nota;
    private float novaNota;
    
    public Aluno(){
        this.estado = new AlunoEstadoMatriculado();
    }
    
    public Aluno(Observable nota){
        this.nota = nota;
        nota.addObserver(this);
    }

    
    //A intenção aqui seria avisar essa nova nota para o aluno, mas seria interessante vincular com disciplina
    //por isso dei uma modificada nas classes
    //tenta dar uma arrumada
    //poderiamos usar essa logica de estar matriculado e tals para receber o aviso ou não
    @Override
    public void update(Observable notaSubject, Object arg1) {
        if(notaSubject instanceof Nota){
            Nota nota = (Nota) notaSubject;
            setNovaNota(nota.getValor());
            
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
     * @return the nota
     */
    public Observable getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(Observable nota) {
        this.nota = nota;
    }

    /**
     * @return the novaNota
     */
    public float getNovaNota() {
        return novaNota;
    }

    /**
     * @param novaNota the novaNota to set
     */
    public void setNovaNota(float novaNota) {
        this.novaNota = novaNota;
    }
}
