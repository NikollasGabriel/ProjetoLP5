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
public class LerDisciplinaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("textId");
        Disciplina departamentoResponse = new Disciplina();

        if (id.equals("")) {
            response.sendRedirect("lerDepartamento.jsp");
        } else {
            Disciplina disciplina = new Disciplina(Integer.parseInt(id));
            try {
                departamentoResponse = DisciplinaDAO.getInstancia().obter(Integer.parseInt(id));
               // response.sendRedirect("Departamento/ler.jsp?id=" + departamentoResponse.getId() + "&nome=" + departamentoResponse.getNome());
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            }
        }

    }

}
