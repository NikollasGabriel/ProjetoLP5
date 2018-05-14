package Model;

public class Professor extends Funcionario {

    private int numeroFaltas;
    private String nivelEnsinoSuperior;

    public Professor() {
    }

    public Professor(int idPessoa) {
        super(idPessoa);
    }

    public Professor(int numeroFaltas, String nivelEnsinoSuperior, float salarioBase, int tempoServico, String nomePessoa, int idadePessoa) {
        super("Professor",salarioBase, tempoServico, nomePessoa, idadePessoa);
        this.numeroFaltas = numeroFaltas;
        this.nivelEnsinoSuperior = nivelEnsinoSuperior;
    }

    public Professor(int numeroFaltas, String nivelEnsinoSuperior, float salarioBase, int tempoServico, int idPessoa, String nomePessoa, int idadePessoa) {
        super("Professor",salarioBase, tempoServico, idPessoa, nomePessoa, idadePessoa);
        this.numeroFaltas = numeroFaltas;
        this.nivelEnsinoSuperior = nivelEnsinoSuperior;
    }

    public int getNumeroFaltas() {
        return numeroFaltas;
    }

    public void setNumeroFaltas(int numeroFaltas) {
        this.numeroFaltas = numeroFaltas;
    }

    public String getNivelEnsinoSuperior() {
        return nivelEnsinoSuperior;
    }

    public void setNivelEnsinoSuperior(String nivelEnsinoSuperior) {
        this.nivelEnsinoSuperior = nivelEnsinoSuperior;
    }

    @Override
    public float getBonificacao() {
        return this.getEstrategiaCalculoBonificacao().calculaSalarioComBonificacao(this);
    }

}
