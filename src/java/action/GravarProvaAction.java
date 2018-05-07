package action;

import Controller.Action;
import Model.Disciplina;
import Model.Prova;
import Persistence.ProvaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarProvaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Prova prova = new Prova(
                Float.parseFloat(request.getParameter("txtValor")),
                request.getParameter("txtAluno"),
                new Disciplina(Integer.parseInt(request.getParameter("txtIdDisciplina"))));

        try {

            ProvaDAO.getInstancia().save(prova);
            response.sendRedirect("FrontController?action=LerProva");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
