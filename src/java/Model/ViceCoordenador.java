package Model;

public class ViceCoordenador extends Funcionario {

    public ViceCoordenador(float salarioBase, int tempoServico, int idPessoa, String nomePessoa, int idadePessoa) {
        super("ViceCoordenador", salarioBase, tempoServico, idPessoa, nomePessoa, idadePessoa);
    }

    public ViceCoordenador(float salarioBase, int tempoServico, String nomePessoa, int idadePessoa) {
       super("ViceCoordenador", salarioBase, tempoServico, nomePessoa, idadePessoa);
    }

    public ViceCoordenador(int idPessoa) {
        super(idPessoa);
    }

    @Override
    public float getBonificacao() {
        return this.getEstrategiaCalculoBonificacao().calculaSalarioComBonificacao(this);
    }

}
