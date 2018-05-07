package action;

import Controller.Action;
import Model.Disciplina;
import Persistence.DisciplinaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararEditarDisciplinaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int idDisicplina = Integer.parseInt(request.getParameter("txtIdDisciplina"));
            
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            Disciplina disciplina = new Disciplina();
            disciplina = disciplinaDAO.obter(idDisicplina);
            
            request.setAttribute("disciplina", disciplina);
            RequestDispatcher view = request.getRequestDispatcher("Disciplina/editar.jsp");
            view.forward(request, response);
            
        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}
