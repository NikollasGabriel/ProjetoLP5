/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Persistence.ViceCoordenadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus note
 */
public class LerViceCoordenadorAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            request.setAttribute("viceCoordenadores", ViceCoordenadorDAO.getInstancia().obterViceCoordenadores());

            RequestDispatcher view = request.getRequestDispatcher("ViceCoordenador/ler.jsp");
            view.forward(request, response);

        } catch (SQLException | ClassNotFoundException | ServletException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
