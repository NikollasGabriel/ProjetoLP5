package action;

import Controller.Action;
import Model.Coordenador;
import Persistence.CoordenadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApagarCoordenadorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Coordenador coordenador = new Coordenador(Integer.parseInt(request.getParameter("txtIdCoordenador")));

        try {

            CoordenadorDAO.getInstancia().delete(coordenador);
            response.sendRedirect("FrontController?action=LerCoordenador");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
