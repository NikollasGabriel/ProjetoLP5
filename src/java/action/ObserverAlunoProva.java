package action;

import Model.Aluno;
import Model.Prova;
import Persistence.AlunoDAO;
import Persistence.ObserverAlunoProvaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ObserverAlunoProva implements Observer {

    private Observable instanciaEdita;

    ObserverAlunoProva(Observable instanciaEdita) {
        this.instanciaEdita = instanciaEdita;
        instanciaEdita.addObserver(this);
    }

    public void setInstanciaEdita(Observable instanciaEdita) {
        this.instanciaEdita = instanciaEdita;
        instanciaEdita.addObserver(this);
    }

    @Override
    public void update(Observable instanciaEdita, Object arg) {

        if (instanciaEdita instanceof GravarProvaAction) {

            GravarProvaAction observable = (GravarProvaAction) instanciaEdita;
            int idAluno = observable.prova.getAluno().getIdPessoa();
            float media = 0;
            ObserverAlunoProvaDAO observerDAO = ObserverAlunoProvaDAO.getInstancia();

            List<Prova> provas = new ArrayList<>();

            try {

                provas = observerDAO.obterProvasOfAluno(idAluno);

                if (provas.size() == 3) {

                    for (Prova p : provas) {
                        media = media + p.getValor();
                    }

                    media = media / 3;

                    Aluno aluno = AlunoDAO.getInstancia().obter(idAluno);

                    if (media >= 60) {
                        aluno.getSituacao().aprovadoNota(aluno); // Mudança de estado condicional

                    } else {
                        aluno.getSituacao().reprovadoNota(aluno); // Mudança de estado condicional
                    }

                    observerDAO.editaSituacaoAluno(aluno);
                    observerDAO.editaNotapublic(aluno);

                }
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        } else {

            EditarAlunoAction observable = (EditarAlunoAction) instanciaEdita;

            int numeroFaltas = observable.numeroFaltas;
            int idAluno = observable.idPessoa;
            ObserverAlunoProvaDAO observerDAO = ObserverAlunoProvaDAO.getInstancia();

            try {

                Aluno aluno = AlunoDAO.getInstancia().obter(idAluno);

                if (numeroFaltas > 12) {

                    aluno.getSituacao().reprovadoFrequencia(aluno);

                } else {

                    aluno.getSituacao().aprovadoFrequencia(aluno);
                }

                observerDAO.editaSituacaoAluno(aluno);

            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
