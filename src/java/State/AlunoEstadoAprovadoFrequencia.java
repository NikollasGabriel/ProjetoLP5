package State;

import Model.Aluno;

public class AlunoEstadoAprovadoFrequencia implements AlunoEstado {

    @Override
    public String getEstado() {
        return "AprovadoFrequencia";
    }

    @Override
    public String reprovadoNota(Aluno a) {
        a.setSituacao(new AlunoEstadoReprovadoNota());
        return "Aluno foi reprovado por nota";
    }

    @Override
    public String reprovadoFrequencia(Aluno a) {
        return "Aluno já foi aprovado por frequencia";
    }

    @Override
    public String aprovadoNota(Aluno a) {
        a.setSituacao(new AlunoEstadoAprovadoNota());
        return "Aluno foi aprovado por nota";
    }

    @Override
    public String aprovadoFrequencia(Aluno a) {
        return "Aluno já foi aprovado por frequencia";
    }

    @Override
    public String naoAvaliado(Aluno a) {
        return "Aluno já foi aprovado por frequencia";
    }

}
