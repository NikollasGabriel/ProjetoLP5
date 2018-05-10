/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Coordenador;
import java.util.ArrayList;

/**
 *
 * @author asus note
 */
public class CoordenadorDAO {
    static ArrayList<Coordenador> listaCoordenadores = new ArrayList<>();
    Coordenador coordenador;
    
    public CoordenadorDAO(){
    }
    
    public void gravar(int id, String nome, int idade, float Salario){
        coordenador = new Coordenador(Salario,id,nome,idade);
        listaCoordenadores.add(coordenador);
    }
    
    public void editar(int id, String nome, int idade, float Salario){
        coordenador = new Coordenador(Salario,id,nome,idade);
        selecionaApagaCoordenador(id);
        listaCoordenadores.add(coordenador);
    }
    
    public ArrayList<Coordenador> obterCoordenadores(){
        return listaCoordenadores;
    }
    
    public Coordenador obter(int id){
        for(Coordenador c : listaCoordenadores){
            if(c.getIdPessoa()==id){
                coordenador = c;
                break;
            }
        }
        return coordenador;
    }
    
    private void selecionaApagaCoordenador(int id){
        for(Coordenador c : listaCoordenadores){
            if(c.getIdPessoa()==id){
                listaCoordenadores.remove(c);
                break;
            }
        }
    }
}
