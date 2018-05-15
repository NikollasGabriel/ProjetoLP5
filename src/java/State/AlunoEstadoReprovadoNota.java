package State;

import Model.Aluno;

public class AlunoEstadoReprovadoNota implements AlunoEstado {

    @Override
    public String getEstado() {
        return "Reprovado por Nota";
    }

    @Override
    public String reprovadoNota(Aluno a) {
        return "Aluno já foi reprovado por nota";
    }

    @Override
    public String reprovadoFrequencia(Aluno a) {
        a.setSituacao(new AlunoEstadoReprovadoFrequencia());
        return "Aluno reprovado por frequencia";
    }

    @Override
    public String aprovadoNota(Aluno a) {
        a.setSituacao(new AlunoEstadoAprovadoNota());
        return "Aluno já foi reprovado por nota";
    }

    @Override
    public String aprovadoFrequencia(Aluno a) {
        return "Aluno já foi reprovado por nota";
    }

    @Override
    public String naoAvaliado(Aluno a) {
        return "Aluno já foi reprovado por nota";
    }

}
