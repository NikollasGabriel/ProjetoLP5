package action;

import Controller.Action;
import Model.Disciplina;
import Persistence.DisciplinaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApagarDisciplinaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("txtIdDisciplina"));

        Disciplina disciplina = new Disciplina(id);

        try {
            
            DisciplinaDAO.getInstancia().delete(disciplina);
            response.sendRedirect("FrontController?action=LerDisciplina");
            
        } catch (ClassNotFoundException | SQLException ex) {
            //response.sendRedirect("erro.jsp?erro=" + ex);
            ex.printStackTrace();
        }
    }
}
