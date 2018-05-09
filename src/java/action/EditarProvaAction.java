package action;

import Controller.Action;
import Model.Aluno;
import Model.Disciplina;
import Model.Prova;
import Persistence.ProvaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarProvaAction implements Action {

    public EditarProvaAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Prova prova = new Prova(
                Integer.parseInt(request.getParameter("txtIdProva")),
                Float.parseFloat(request.getParameter("txtValor")),
                new Aluno(Integer.parseInt(request.getParameter("txtIdAluno"))),
                new Disciplina(Integer.parseInt(request.getParameter("txtIdDisciplina"))));

        try {

            ProvaDAO.getInstancia().editar(prova);
            response.sendRedirect("FrontController?action=LerProva");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
