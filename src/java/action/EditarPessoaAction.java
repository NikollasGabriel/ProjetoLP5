package action;

import Controller.Action;
import Model.Pessoa;
import Model.Prova;
import Model.Turma;
import Persistence.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarPessoaAction implements Action {

    public EditarPessoaAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Pessoa pessoa = new Pessoa(
                Integer.parseInt(request.getParameter("txtIdPessoa")),
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("txtIdadePessoa")),
                new Turma(Integer.parseInt(request.getParameter("txtIdTurma"))));

        try {

            PessoaDAO.getInstancia().editar(pessoa);
            response.sendRedirect("FrontController?action=LerPessoa");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
