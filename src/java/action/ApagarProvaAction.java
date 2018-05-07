package action;

import Controller.Action;
import Model.Prova;
import Persistence.ProvaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApagarProvaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Prova prova = new Prova(Integer.parseInt(request.getParameter("txtIdProva")));

        try {

            ProvaDAO.getInstancia().delete(prova);
            response.sendRedirect("FrontController?action=LerProva");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
