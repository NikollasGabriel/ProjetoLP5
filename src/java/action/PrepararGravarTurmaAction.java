package action;

import Controller.Action;
import Persistence.CoordenadorDAO;
import Persistence.DisciplinaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararGravarTurmaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("disciplinas", DisciplinaDAO.getInstancia().obterDisciplinas());
            request.setAttribute("coordenadores", CoordenadorDAO.getInstancia().obterCoordenadores());

            RequestDispatcher view = request.getRequestDispatcher("Turma/gravar.jsp");

            view.forward(request, response);

        } catch (ServletException | IOException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
