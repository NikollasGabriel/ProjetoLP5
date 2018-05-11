package Model;

public class ViceCoordenador extends Funcionario {

    public ViceCoordenador(float salarioBase, int idPessoa, String nomePessoa, int idadePessoa, Coordenador coordenador) {
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
        return 500;
    }

}
