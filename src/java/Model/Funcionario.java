package Model;

public abstract class Funcionario extends Pessoa {

    private float salarioBase;
    private float salarioFinal;
    private int tempoServico;
    private CalculaBonificacao estrategiaCalculoBonificacao;

    public Funcionario(float salarioBase, float salarioFinal, String Cargo, int tempoServico, String nomePessoa, int idadePessoa) {
        super(nomePessoa, idadePessoa);
        this.salarioBase = salarioBase;
        this.salarioFinal = salarioFinal;
        this.tempoServico = tempoServico;

        switch (Cargo) {
            case "Professor":
                this.estrategiaCalculoBonificacao = new CalculaBonificacaoProfessor();
                break;

            case "ViceCoordenador":
                this.estrategiaCalculoBonificacao = new CalculaBonificacaoViceCoordenador();
                break;

            case "Coordenador":
                this.estrategiaCalculoBonificacao = new CalculaBonificacaoCoordenador();
                break;
        }

    }

    public Funcionario(String nomePessoa, int idadePessoa) {
        super(nomePessoa, idadePessoa);
    }

    public Funcionario(float salarioFinal, float salarioBase, int idPessoa, String nomePessoa, int idadePessoa) {
        super(nomePessoa, idadePessoa);
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

    public Funcionario() {
    }

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

    public int getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }

    public CalculaBonificacao getEstrategiaCalculoBonificacao() {
        return estrategiaCalculoBonificacao;
    }

    public void setEstrategiaCalculoBonificacao(CalculaBonificacao estrategiaCalculoBonificacao) {
        this.estrategiaCalculoBonificacao = estrategiaCalculoBonificacao;
    }

}
