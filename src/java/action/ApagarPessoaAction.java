package action;

import Controller.Action;
import Model.Pessoa;
import Persistence.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApagarPessoaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("");

        if (id.equals("")) {
            response.sendRedirect("");
        } else {

            Pessoa pessoa = new Pessoa(Integer.parseInt(id));

            try {
                PessoaDAO.getInstancia().delete(pessoa);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            }
        }
    }

}
