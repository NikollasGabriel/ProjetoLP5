package action;

import Controller.Action;
import Model.Turma;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApagarTurmaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Turma turma = new Turma(Integer.parseInt(request.getParameter("txtIdTurma")));

        try {

            TurmaDAO.getInstancia().delete(turma);
            response.sendRedirect("FrontController?action=LerTurma");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
