/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.Disciplina;
import Persistence.DisciplinaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus note
 */
public class GravarDisciplinaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nome = request.getParameter("textNome");

        if (nome.equals("")) {
            response.sendRedirect("Departamento/gravar.jsp");
        } else {

            Disciplina disciplina = new Disciplina();

            try {
                DisciplinaDAO.getInstancia().save(disciplina);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("../erro.jsp?erro=" + ex);
                ex.printStackTrace();
            }
        }
    }

}
