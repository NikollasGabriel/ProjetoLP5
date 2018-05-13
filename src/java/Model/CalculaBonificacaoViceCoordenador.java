package Model;

public class CalculaBonificacaoViceCoordenador implements CalculaBonificacao {

    @Override
    public float calculaSalarioComBonificacao(Funcionario funcionario) {
        return (float) (funcionario.getSalarioBase() * (funcionario.getTempoServico() * 0.07));
    }

}
