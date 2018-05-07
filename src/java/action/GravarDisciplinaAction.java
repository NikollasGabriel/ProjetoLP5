package action;

import Controller.Action;
import Model.Disciplina;
import Persistence.DisciplinaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarDisciplinaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nome = request.getParameter("textNomeDisciplina");
        Integer creditos = Integer.parseInt(request.getParameter("textNumeroCreditos"));
        Integer vagas = Integer.parseInt(request.getParameter("textNumeroVagas"));

        if (nome.equals("")) {
            response.sendRedirect("Disciplina/gravar.jsp");
        } else {

            Disciplina disciplina = new Disciplina(nome, creditos, vagas);

            try {
                DisciplinaDAO.getInstancia().save(disciplina);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                //response.sendRedirect("../erro.jsp?erro=" + ex);
                ex.printStackTrace();
            }
            
            response.sendRedirect("FrontController?action=LerDisciplina");
            
            
        }
    }

}
