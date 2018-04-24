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
public class AlunoEstadoEvadido implements AlunoEstado{

    @Override
    public String getEstado() {
        return "Evadido";
    }

    @Override
    public String matricular(Aluno a) {
        return "Aluno não pode se matricular se for evadido";
    }

    @Override
    public String formar(Aluno a) {
        return "Aluno não pode se formar se for evadido";
    }

    @Override
    public String trancar(Aluno a) {
        return "Aluno não pode se trancar se for evadido";
    }

    @Override
    public String suspender(Aluno a) {
        return "Aluno não pode ser suspenso se for evadido";
    }

    @Override
    public String jubilar(Aluno a) {
        return "Aluno não pode ser jubilado se for evadido";
    }

    @Override
    public String evadir(Aluno a) {
        return "Aluno não pode evadir se for evadido";
    }
    
}
