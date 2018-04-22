/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Professores;

import Model.Professores.Professor;

/**
 *
 * @author rwspa
 */
public interface ProfessorEstado {
    public String getEstado();
    public String contratado(Professor a);
    public String efetivar(Professor a);
    public String demitido(Professor a);
    public String demissao(Professor a);
}
