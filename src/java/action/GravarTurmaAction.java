package action;

import Controller.Action;
import Model.Disciplina;
import Model.Turma;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarTurmaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Turma turma = new Turma(
                request.getParameter("txtPeriodoTurma"),
                Integer.parseInt(request.getParameter("txtTamanhoTurma")),
                new Disciplina(Integer.parseInt(request.getParameter("txtIdDisciplina"))));

        try {

            TurmaDAO.getInstancia().save(turma);
            response.sendRedirect("FrontController?action=LerTurma");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
