package action;

import Controller.Action;
import Persistence.AlunoDAO;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepararEditarAlunoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("pessoa", AlunoDAO.getInstancia().obter(Integer.parseInt(request.getParameter("txtIdPessoa"))));
            request.setAttribute("turmas", TurmaDAO.getInstancia().obterTurmas());

            RequestDispatcher view = request.getRequestDispatcher("Aluno/editar.jsp");
            view.forward(request, response);

        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}
