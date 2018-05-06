/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.Turma;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus note
 */
public class LerTurmaAction implements Action {

    @Override
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
            try{
                List<Turma> turmas = new ArrayList<Turma>();
                turmas = TurmaDAO.getInstancia().obterTurmas();
                request.setAttribute("turmas", turmas);
                RequestDispatcher view = request.getRequestDispatcher("turmaConsulta.jsp");
                view.forward(request, response);
            } catch(SQLException ex)
            {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(LerTurmaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
