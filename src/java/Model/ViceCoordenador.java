package Model;

public class ViceCoordenador extends Funcionario {

    public ViceCoordenador(float salarioBase, float salarioFinal, int idPessoa, String nomePessoa, int idadePessoa) {
        super(salarioBase, salarioFinal, idPessoa, nomePessoa, idadePessoa);
    }
    
    public ViceCoordenador(float salarioBase, int idPessoa, String nomePessoa, int idadePessoa) {
        super(salarioBase, idPessoa, nomePessoa, idadePessoa);
    }

    public ViceCoordenador(float salarioBase, String nomePessoa, int idadePessoa) {
        super(salarioBase, nomePessoa, idadePessoa);
    }

    public ViceCoordenador(int idPessoa) {
        super(idPessoa);
    }

    @Override
    public float getBonificacao() {
        return this.getEstrategiaCalculoBonificacao().calculaSalarioComBonificacao(this);
    }

}
