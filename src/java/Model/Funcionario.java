package Model;

public abstract class Funcionario extends Pessoa {

    private float salarioBase;
    private float salarioFinal;
    private int tempoServico;
    private CalculaBonificacao estrategiaCalculoBonificacao;

    public Funcionario(String cargo, float salarioBase, int tempoServico, String nomePessoa, int idadePessoa) {
        super(nomePessoa, idadePessoa);
        this.salarioBase = salarioBase;
        this.tempoServico = tempoServico;

        switch (cargo) {
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
        
        this.setRemuneracao();

    }

    public Funcionario(String cargo, float salarioBase, int tempoServico, int idPessoa, String nomePessoa, int idadePessoa) {
        super(nomePessoa, idadePessoa);
        this.salarioBase = salarioBase;
        this.tempoServico = tempoServico;

        switch (cargo) {
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
        
        this.setRemuneracao();
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
