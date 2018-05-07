package action;

import Controller.Action;
import Model.Disciplina;
import Persistence.DisciplinaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarDisciplinaAction implements Action {

    public EditarDisciplinaAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("txtIdDisciplina"));
        String nome = request.getParameter("txtNomeDisciplina");
        int numerocreditos = Integer.parseInt(request.getParameter("txtNumeroCreditos"));
        int numerovagas = Integer.parseInt(request.getParameter("txtNumeroVagas"));

        if (nome.equals("")) {
            response.sendRedirect("FrontController?action=LerDisciplina");
        } else {
            try {

                Disciplina disciplina = new Disciplina(id, nome, numerocreditos, numerovagas);
                DisciplinaDAO.getInstancia().editar(disciplina);
                response.sendRedirect("FrontController?action=LerDisciplina");

            } catch (SQLException | ClassNotFoundException ex) {
                //response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            }
        }
    }

}
