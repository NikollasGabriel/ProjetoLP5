/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Alunos;

/**
 *
 * @author Aluno
 */
public class AlunoEstadoTrancado implements AlunoEstado {

    @Override
    public String getEstado() {
        return "Trancado";
    }

    @Override
    public String matricular(Aluno a) {
        a.setEstado(new AlunoEstadoMatriculado());
        return "Aluno pode se matricular";
    }

    @Override
    public String formar(Aluno a) {
        return "Aluno não pode se formar se for trancado";
    }

    @Override
    public String trancar(Aluno a) {
        return "Aluno não pode trancar se for trancado";
    }

    @Override
    public String suspender(Aluno a) {
        return "Aluno não pode ser suspenso se for trancado";
    }

    @Override
    public String jubilar(Aluno a) {
        a.setEstado(new AlunoEstadoJubilado());
        return "Aluno pode ser jubilado";
    }

    @Override
    public String evadir(Aluno a) {
        a.setEstado(new AlunoEstadoEvadido());
        return "Aluno pode evadir.";
    }
    
}
