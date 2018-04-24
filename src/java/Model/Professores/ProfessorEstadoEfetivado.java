/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Professores;

/**
 *
 * @author matheus.fregulia
 */
public class ProfessorEstadoEfetivado implements ProfessorEstado{
    
    @Override
    public String getEstado() {
        return "Efetivado";
    }

    @Override
    public String contratado(Professor a) {
        return "Professor não pode ser contratado se for efetivado";
    }

    @Override
    public String efetivar(Professor a) {
        return "Professor pode ser efetivado se for efetivado";
    }

    @Override
    public String demitido(Professor a) {
        return "Professor pode ser demitido se for efetivado";    
    }

    @Override
    public String demissao(Professor a) {
        return "Professor pode pedir demissão se for efetivado";
    }
    
}
