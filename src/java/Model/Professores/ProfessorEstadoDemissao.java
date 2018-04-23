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
public class ProfessorEstadoDemissao implements ProfessorEstado{
    
    @Override
    public String getEstado() {
        return "Demissão";
    }

    @Override
    public String contratado(Professor a) {
        return "Professor pode pedir demissão se for contratado";
    }

    @Override
    public String efetivar(Professor a) {
        return "Professor não pode ser efetivado se pedir demissão";
    }

    @Override
    public String demitido(Professor a) {
        return "Professor não pode ser demitido se pedir demissão"; 
    }

    @Override
    public String demissao(Professor a) {
        return "Professor não pode pedir demissão se ja estiver pedido demissão"; 
    }
    
}
