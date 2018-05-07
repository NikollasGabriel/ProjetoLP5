package action;

import Controller.Action;
import Model.Disciplina;
import Model.Turma;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarTurmaAction implements Action {

    public EditarTurmaAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Turma turma = new Turma(
                Integer.parseInt(request.getParameter("txtIdTurma")),
                request.getParameter("txtPeriodoTurma"),
                Integer.parseInt(request.getParameter("txtTamanhoTurma")),
                new Disciplina(Integer.parseInt(request.getParameter("txtIdDisciplina"))));

        try {
            
            TurmaDAO.getInstancia().editar(turma);
            response.sendRedirect("FrontController?action=LerTurma");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
