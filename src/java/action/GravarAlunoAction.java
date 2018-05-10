package action;

import Controller.Action;
import Model.Aluno;
import Model.Turma;
import Persistence.AlunoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarAlunoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Aluno pessoa = new Aluno(
                0,
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("txtIdadePessoa")),
                new Turma(Integer.parseInt(request.getParameter("txtIdTurma"))),
                Integer.parseInt(request.getParameter("txtNumeroFaltas")),
                0,
                "Nao Avaliado");

        try {

            AlunoDAO.getInstancia().save(pessoa);
            response.sendRedirect("FrontController?action=LerAluno");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
