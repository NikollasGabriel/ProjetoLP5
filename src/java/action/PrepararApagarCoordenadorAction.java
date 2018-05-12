package action;

import Controller.Action;
import Persistence.CoordenadorDAO;
import Persistence.ViceCoordenadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararApagarCoordenadorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("cordenador", CoordenadorDAO.getInstancia().obter(Integer.parseInt(request.getParameter("txtIdCoordenador"))));
            request.setAttribute("viceCoordenadores", ViceCoordenadorDAO.getInstancia().obterViceCoordenadors());

            RequestDispatcher view = request.getRequestDispatcher("Coordenador/excluir.jsp");
            view.forward(request, response);

        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}
