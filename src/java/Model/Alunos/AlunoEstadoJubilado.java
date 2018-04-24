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
public class AlunoEstadoJubilado implements AlunoEstado {

    @Override
    public String getEstado() {
        return "Jubilado";
    }

    @Override
    public String matricular(Aluno a) {
        return "Aluno não pode se matricular se for jubilado";
    }

    @Override
    public String formar(Aluno a) {
        return "Aluno não pode se formar se for jubilado";
    }

    @Override
    public String trancar(Aluno a) {
        return "Aluno não pode se trancar se for jubilado";
    }

    @Override
    public String suspender(Aluno a) {
        return "Aluno não pode ser suspenso se for jubilado";
    }

    @Override
    public String jubilar(Aluno a) {
        return "Aluno não pode ser jubilado se for jubilado";
    }

    @Override
    public String evadir(Aluno a) {
        return "Aluno não pode evadir se for jubilado";
    }
    
}
