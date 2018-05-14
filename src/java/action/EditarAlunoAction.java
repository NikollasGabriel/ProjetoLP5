package action;

import Controller.Action;
import Model.Aluno;
import Model.Turma;
import Persistence.AlunoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarAlunoAction extends Observable implements Action {

    public int numeroFaltas;
    public int idPessoa;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        idPessoa = Integer.parseInt(request.getParameter("txtIdPessoa"));
        numeroFaltas = Integer.parseInt(request.getParameter("txtNumeroFaltas"));

        Aluno pessoa = new Aluno(
                idPessoa,
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("txtIdadePessoa")),
                new Turma(Integer.parseInt(request.getParameter("txtIdTurma"))),
                numeroFaltas,
                Float.parseFloat(request.getParameter("txtMediaNotas")),
                request.getParameter("txtSituacao")
        );

        try {
            new AlunoMementoAction(AlunoDAO.getInstancia().obter(pessoa.getIdPessoa()));
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        try {

            AlunoDAO.getInstancia().editar(pessoa);

            ObserverAlunoProva observer = new ObserverAlunoProva(this);
            setChanged();
            notifyObservers();

            response.sendRedirect("FrontController?action=LerAluno");

        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }

}
