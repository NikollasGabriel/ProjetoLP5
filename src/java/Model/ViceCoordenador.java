package Model;

public class ViceCoordenador extends Funcionario {

    private Coordenador coordenador;

    public ViceCoordenador(float salarioFinal, int idPessoa, String nomePessoa, int idadePessoa, Coordenador coordenador) {
        super(salarioFinal, idPessoa, nomePessoa, idadePessoa);
        this.coordenador = coordenador;
    }

    public ViceCoordenador(Coordenador coordenador, float salarioFinal, String nomePessoa, int idadePessoa) {
        super(salarioFinal, nomePessoa, idadePessoa);
        this.coordenador = coordenador;
    }

    public ViceCoordenador(Coordenador coordenador, int idPessoa) {
        super(idPessoa);
        this.coordenador = coordenador;
    }

    @Override
    public float getBonificacao() {
        return 500;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

}
