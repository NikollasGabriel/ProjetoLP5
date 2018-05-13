package State;

import Model.Aluno;

public class AlunoEstadoReprovadoFrequencia implements AlunoEstado {

    @Override
    public String getEstado() {
        return "Reprovado por Frequencia";
    }

    @Override
    public String reprovadoNota(Aluno a) {
        a.setSituacao(new AlunoEstadoReprovadoNota());
        return "Aluno reprovado por nota";
    }

    @Override
    public String reprovadoFrequencia(Aluno a) {
        return "Aluno já reprovado por frequencia";
    }

    @Override
    public String aprovadoNota(Aluno a) {
        return "Aluno já reprovado por frequencia";
    }

    @Override
    public String aprovadoFrequencia(Aluno a) {
        return "Aluno já reprovado por frequencia";
    }

    @Override
    public String naoAvaliado(Aluno a) {
        return "Aluno já reprovado por frequencia";
    }
}
