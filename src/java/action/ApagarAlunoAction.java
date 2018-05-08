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

        Pessoa pessoa = new Pessoa(Integer.parseInt(request.getParameter("txtIdPessoa")));

        try {

            PessoaDAO.getInstancia().delete(pessoa);
            response.sendRedirect("FrontController?action=LerPessoa");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
