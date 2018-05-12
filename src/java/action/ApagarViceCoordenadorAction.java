package action;

import Controller.Action;
import Model.ViceCoordenador;
import Persistence.ViceCoordenadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApagarViceCoordenadorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ViceCoordenador viceCoordenador = new ViceCoordenador(Integer.parseInt(request.getParameter("txtIdViceCoordenador")));

        try {

            ViceCoordenadorDAO.getInstancia().delete(viceCoordenador);
            response.sendRedirect("FrontController?action=LerViceCoordenador");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
