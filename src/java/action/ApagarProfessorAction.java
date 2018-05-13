package action;

import Controller.Action;
import Model.Professor;
import Persistence.ProfessorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApagarProfessorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Professor pessoa = new Professor(Integer.parseInt(request.getParameter("txtIdPessoa")));

        try {

            ProfessorDAO.getInstancia().delete(pessoa);
            response.sendRedirect("FrontController?action=LerProfessor");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
