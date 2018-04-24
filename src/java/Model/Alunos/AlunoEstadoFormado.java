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
public class AlunoEstadoFormado implements AlunoEstado {

    @Override
    public String getEstado() {
        return "Formado";
    }

    @Override
    public String matricular(Aluno a) {
        return "Aluno não pode se matricular se for formado";
    }

    @Override
    public String formar(Aluno a) {
        return "Aluno não pode se formar se for formado";
    }

    @Override
    public String trancar(Aluno a) {
        return "Aluno não pode trancar se for formado";
    }

    @Override
    public String suspender(Aluno a) {
        return "Aluno não pode ser suspenso se for formado";
    }

    @Override
    public String jubilar(Aluno a) {
        return "Aluno não pode ser jubilado se for formado";
    }

    @Override
    public String evadir(Aluno a) {
        return "Aluno não pode evadir se for formado";
    }
    
}
