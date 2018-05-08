package State;

import Model.Aluno;

public class AlunoEstadoAprovadoNota implements AlunoEstado {

    @Override
    public String getEstado() {
        return "AprovadoNota";
    }

    @Override
    public String reprovadoNota(Aluno a) {
        return "Aluno já foi aprovado por nota";
    }

    @Override
    public String reprovadoFrequencia(Aluno a) {
        a.setSituacao(new AlunoEstadoReprovadoFrequencia());
        return "Aluno foi reprovado por frequencia";
    }

    @Override
    public String aprovadoNota(Aluno a) {
        return "Aluno já foi aprovado por nota";
    }

    @Override
    public String aprovadoFrequencia(Aluno a) {
        a.setSituacao(new AlunoEstadoAprovadoFrequencia());
        return "Aluno foi aprovado por frequencia";
    }

    @Override
    public String naoAvaliado(Aluno a) {
        return "Aluno já foi aprovado por nota";
    }

}
