package Model;


public class Coordenador extends Funcionario{

    private ViceCoordenador viceCoordenador;

    @Override
    public float getBonificacao() {
        return 1000;
    }

    public Coordenador(ViceCoordenador viceCoordenador, float salarioBase, float salarioFinal, int idPessoa, String nomePessoa, int idadePessoa) {
        super(salarioBase, idPessoa, nomePessoa, idadePessoa);
        this.viceCoordenador = viceCoordenador;
    }
    
    public Coordenador(ViceCoordenador viceCoordenador, float salarioBase, int idPessoa, String nomePessoa, int idadePessoa) {
        super(salarioBase, idPessoa, nomePessoa, idadePessoa);
        this.viceCoordenador = viceCoordenador;
    }

    public Coordenador(ViceCoordenador viceCoordenador, float salarioBase, String nomePessoa, int idadePessoa) {
        super(salarioBase, nomePessoa, idadePessoa);
        this.viceCoordenador = viceCoordenador;
    }

    public Coordenador(int idPessoa) {
        super(idPessoa);
    }

    /**
     * @return the viceCoordenador
     */
    public ViceCoordenador getViceCoordenador() {
        return viceCoordenador;
    }

    /**
     * @param viceCoordenador the viceCoordenador to set
     */
    public void setViceCoordenador(ViceCoordenador viceCoordenador) {
        this.viceCoordenador = viceCoordenador;
    }
        
}
