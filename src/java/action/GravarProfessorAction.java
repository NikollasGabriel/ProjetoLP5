package action;

import Controller.Action;
import Model.Professor;
import Model.Turma;
import Persistence.ProfessorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarProfessorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Professor pessoa = new Professor(
                Integer.parseInt(request.getParameter("txtNumeroFaltas")),
                request.getParameter("txtNivelEnsinoSuperior"),
                Float.parseFloat(request.getParameter("txtSalarioBase")),
                Integer.parseInt(request.getParameter("txtTempoServico")),
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("txtIdadePessoa"))
        );

        try {

            ProfessorDAO.getInstancia().save(pessoa);
            response.sendRedirect("FrontController?action=LerProfessor");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
