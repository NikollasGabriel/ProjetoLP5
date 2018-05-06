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

        String id = request.getParameter("");

        if (id.equals("")) {
            response.sendRedirect("");
        } else {

            Prova prova = new Prova(Integer.parseInt(id));

            try {
                ProvaDAO.getInstancia().delete(prova);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            }
        }
    }

}
