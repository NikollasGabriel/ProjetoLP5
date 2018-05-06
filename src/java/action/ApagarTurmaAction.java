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

        String id = request.getParameter("");

        if (id.equals("")) {
            response.sendRedirect("");
        } else {

            Turma turma = new Turma(Integer.parseInt(id));

            try {
                TurmaDAO.getInstancia().delete(turma);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            }
        }
    }

}
