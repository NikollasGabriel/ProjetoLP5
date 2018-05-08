package action;

import Controller.Action;
import Persistence.PessoaDAO;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LerPessoaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            request.setAttribute("turmas", TurmaDAO.getInstancia().obterTurmas());
            request.setAttribute("pessoas", PessoaDAO.getInstancia().obterPessoas());

            RequestDispatcher view = request.getRequestDispatcher("Pessoa/ler.jsp");
            view.forward(request, response);

        } catch (SQLException | ClassNotFoundException | ServletException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }

}
