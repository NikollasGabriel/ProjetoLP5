package action;

import Controller.Action;
import Persistence.ProfessorDAO;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LerProfessorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            request.setAttribute("turmas", TurmaDAO.getInstancia().obterTurmas());
            request.setAttribute("pessoas", ProfessorDAO.getInstancia().obterProfessores());

            RequestDispatcher view = request.getRequestDispatcher("Professor/ler.jsp");
            view.forward(request, response);

        } catch (SQLException | ClassNotFoundException | ServletException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }

}
