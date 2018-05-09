package action;

import Controller.Action;
import Model.Professor;
import Model.Prova;
import Model.Turma;
import Persistence.ProfessorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarProfessorAction implements Action {

    public EditarProfessorAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Professor pessoa = new Professor(
                Integer.parseInt(request.getParameter("txtNumeroFaltas")),
                request.getParameter("txtNivelEnsinoSuperior"),
                Integer.parseInt(request.getParameter("txtIdPessoa")),
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("txtIdadePessoa"))
        );

        try {

            ProfessorDAO.getInstancia().editar(pessoa);
            response.sendRedirect("FrontController?action=LerProfessor");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
