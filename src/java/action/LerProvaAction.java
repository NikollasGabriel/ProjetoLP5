/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.Prova;
import Persistence.ProvaDAO;
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
public class LerProvaAction implements Action {

    @Override
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
            try{
                List<Prova> provas = new ArrayList<Prova>();
                provas = ProvaDAO.getInstancia().obterProvas();
                request.setAttribute("provas", provas);
                RequestDispatcher view = request.getRequestDispatcher("provaConsulta.jsp");
                view.forward(request, response);
            } catch(SQLException ex)
            {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(LerProvaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
