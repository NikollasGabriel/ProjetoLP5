package action;

import Controller.Action;
import Model.Aluno;
import Model.Prova;
import Model.Turma;
import Persistence.AlunoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarAlunoAction implements Action {

    public EditarAlunoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Aluno pessoa = new Aluno(
                Integer.parseInt(request.getParameter("txtIdPessoa")),
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("txtIdadePessoa")),
                new Turma(Integer.parseInt(request.getParameter("txtIdTurma"))),
                Integer.parseInt(request.getParameter("txtNumeroFaltas")),
                Float.parseFloat(request.getParameter("txtMediaNotas")),
                request.getParameter("txtSituacao")
        );

        try {
            new AlunoMementoAction(AlunoDAO.getInstancia().obter(pessoa.getIdPessoa()));
        } catch (SQLException ex) {
            Logger.getLogger(EditarAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {

            AlunoDAO.getInstancia().editar(pessoa);
            response.sendRedirect("FrontController?action=LerAluno");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
