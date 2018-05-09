package action;

import Controller.Action;
import Model.Aluno;
import Model.Disciplina;
import Model.Professor;
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
                new Aluno(Integer.parseInt(request.getParameter("txtAluno"))),
                new Professor(Integer.parseInt(request.getParameter("txtIdProfessor"))),
                new Disciplina(Integer.parseInt(request.getParameter("txtIdDisciplina"))));

        try {

            ProvaDAO.getInstancia().save(prova);
            response.sendRedirect("FrontController?action=LerProva");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
