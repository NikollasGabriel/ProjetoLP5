package action;

import Controller.Action;
import Persistence.CoordenadorDAO;
import Persistence.DisciplinaDAO;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LerTurmaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            request.setAttribute("disciplinas", DisciplinaDAO.getInstancia().obterDisciplinas());
            request.setAttribute("coordenadores", CoordenadorDAO.getInstancia().obterCoordenadores());
            request.setAttribute("turmas", TurmaDAO.getInstancia().obterTurmas());

            RequestDispatcher view = request.getRequestDispatcher("Turma/ler.jsp");
            view.forward(request, response);

        } catch (SQLException | ClassNotFoundException | ServletException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }

}
