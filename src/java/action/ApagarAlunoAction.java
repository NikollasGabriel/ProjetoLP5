package action;

import Controller.Action;
import Model.Aluno;
import Persistence.AlunoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApagarAlunoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Aluno pessoa = new Aluno(Integer.parseInt(request.getParameter("txtIdPessoa")));

        try {

            AlunoDAO.getInstancia().delete(pessoa);
            response.sendRedirect("FrontController?action=LerAluno");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
