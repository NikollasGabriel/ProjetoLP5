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
public interface AlunoEstado {
    public String getEstado(); 
    public String matricular(Aluno a);
    public String formar(Aluno a);
    public String trancar(Aluno a);
    public String suspender(Aluno a);
    public String jubilar(Aluno a);
    public String evadir(Aluno a);
    
}
