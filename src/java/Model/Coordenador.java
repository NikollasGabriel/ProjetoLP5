package Model;


public class Coordenador extends Funcionario{

    private ViceCoordenador viceCoordenador;

    @Override
    public float getBonificacao() {
        return this.getEstrategiaCalculoBonificacao().calculaSalarioComBonificacao(this);
    }

    public Coordenador(ViceCoordenador viceCoordenador, float salarioBase, int tempoServico, int idPessoa, String nomePessoa, int idadePessoa) {
        super("Coordenador", salarioBase, tempoServico, idPessoa, nomePessoa, idadePessoa);
        this.viceCoordenador = viceCoordenador;
    }
    
    public Coordenador(ViceCoordenador viceCoordenador, float salarioBase, int tempoServico, String nomePessoa, int idadePessoa) {
        super("Coordenador", salarioBase, tempoServico, nomePessoa, idadePessoa);
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
