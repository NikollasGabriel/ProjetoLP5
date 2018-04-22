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
public class AlunoEstadoMatriculado implements AlunoEstado {

    @Override
    public String getEstado() {
        return "Matriculado";
    }

    @Override
    public String matricular(Aluno a) {
        return "Matrícula não efetuada pois o aluno já está matriculado";
    }

    @Override
    public String formar(Aluno a) {
        a.setEstado(new AlunoEstadoFormado());
        return "Aluno pode formar";
    }

    @Override
    public String trancar(Aluno a ) {
        a.setEstado(new AlunoEstadoTrancado());
        return "Aluno pode trancar";
    }

    @Override
    public String suspender(Aluno a) {
        a.setEstado(new AlunoEstadoTrancado());
        return "Aluno pode ser suspenso";
    }

    @Override
    public String jubilar(Aluno a) {
        a.setEstado(new AlunoEstadoJubilado());
        return "Aluno pode ser jubilado";
    }

    @Override
    public String evadir(Aluno a) {
        a.setEstado(new AlunoEstadoEvadido());
        return "Aluno pode evadir";
    }
    
}
