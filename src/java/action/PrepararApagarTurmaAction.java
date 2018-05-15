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

public class PrepararApagarTurmaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("turma", TurmaDAO.getInstancia().obter(Integer.parseInt(request.getParameter("txtIdTurma"))));
            request.setAttribute("disciplinas", DisciplinaDAO.getInstancia().obterDisciplinas());
            request.setAttribute("coordenadores", CoordenadorDAO.getInstancia().obterCoordenadores());
            
            RequestDispatcher view = request.getRequestDispatcher("Turma/excluir.jsp");
            view.forward(request, response);

        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
