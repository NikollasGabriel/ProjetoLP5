/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author asus note
 */
public abstract class Funcionario extends Pessoa{

    private float salarioBase;
    private float salarioFinal;

    public abstract float getBonificacao();

    public void setRemuneracao() {
        this.salarioFinal = this.salarioBase + this.getBonificacao();
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getSalarioFinal() {
        return salarioFinal;
    }

    public void setSalarioFinal(float salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    public Funcionario(float salarioFinal, float salarioBase, int idPessoa, String nomePessoa, int idadePessoa) {
        super(idPessoa, nomePessoa, idadePessoa);
        this.salarioBase = salarioBase;
        this.salarioFinal = salarioFinal;
    }
    
    public Funcionario(float salarioBase, int idPessoa, String nomePessoa, int idadePessoa) {
        super(idPessoa, nomePessoa, idadePessoa);
        this.salarioBase = salarioBase;
    }

    public Funcionario(float salarioBase, String nomePessoa, int idadePessoa) {
        super(nomePessoa, idadePessoa);
        this.salarioBase = salarioBase;
    }

    public Funcionario(int idPessoa) {
        super(idPessoa);
    }
            
}
