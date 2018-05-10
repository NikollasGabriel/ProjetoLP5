package Model;


public class Coordenador extends Funcionario{

    
    @Override
    public float getBonificacao() {
        return 1000;
    }

    public Coordenador(float salarioFinal, int idPessoa, String nomePessoa, int idadePessoa) {
        super(salarioFinal, idPessoa, nomePessoa, idadePessoa);
    }

    public Coordenador(float salarioFinal, String nomePessoa, int idadePessoa) {
        super(salarioFinal, nomePessoa, idadePessoa);
    }

    public Coordenador(int idPessoa) {
        super(idPessoa);
    }
        
}
