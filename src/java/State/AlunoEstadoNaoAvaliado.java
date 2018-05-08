package State;

import Model.Aluno;

public class AlunoEstadoNaoAvaliado implements AlunoEstado{

    @Override
    public String getEstado() {
        return "NaoAvaliado";
    }

    @Override
    public String reprovadoNota(Aluno a) {
        a.setSituacao(new AlunoEstadoReprovadoNota());
        return "Aluno reprovado por nota";
    }

    @Override
    public String reprovadoFrequencia(Aluno a) {
         a.setSituacao(new AlunoEstadoReprovadoFrequencia());
        return "Aluno reprovado por frequencia";
    }

    @Override
    public String aprovadoNota(Aluno a) {
        a.setSituacao(new AlunoEstadoAprovadoNota());
        return "Aluno aprovado por nota";
    }

    @Override
    public String aprovadoFrequencia(Aluno a) {
        a.setSituacao(new AlunoEstadoAprovadoFrequencia());
        return "Aluno aprovado por frequencia";
    }

    @Override
    public String naoAvaliado(Aluno a) {
        return "Aluno não foi avaliado";
    }
    
}
