/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Professores;

import Model.Professores.ProfessorEstado;

/**
 *
 * @author rwspa
 */
public class ProfessorEstadoContratado implements ProfessorEstado{

    @Override
    public String getEstado() {
        return "Contratado";
    }

    @Override
    public String contratado(Professor a) {
        return "Professor não pode ser contratado se for contratado";
    }

    @Override
    public String efetivar(Professor a) {
        return "Professor pode ser efetivado se for contratado";
    }

    @Override
    public String demitido(Professor a) {
        return "Professor pode ser demitido se for contratado";
    }

    @Override
    public String demissao(Professor a) {
        return "Professor pode pedir demissão se for contratado";
    }
    
}
