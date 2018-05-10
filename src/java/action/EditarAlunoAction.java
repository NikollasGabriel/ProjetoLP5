package action;

import Controller.Action;
import Model.Aluno;
import Model.Prova;
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

            AlunoDAO.getInstancia().editar(pessoa);

            AlgumaCoisaTesteAction observer = new AlgumaCoisaTesteAction(this);
            setChanged();
            notifyObservers();

            response.sendRedirect("FrontController?action=LerAluno");

        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }

}
