package action;

import Controller.Action;
import Model.Pessoa;
import Model.Turma;
import Persistence.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarPessoaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Pessoa pessoa = new Pessoa(
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("txtIdadePessoa")),
                new Turma(Integer.parseInt(request.getParameter("txtIdTurma"))));

        try {

            PessoaDAO.getInstancia().save(pessoa);
            response.sendRedirect("FrontController?action=LerPessoa");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
