/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.ViceCoordenador;
import Persistence.ViceCoordenadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus note
 */
public class GravarViceCoordenadorAction implements Action{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ViceCoordenador viceCoordenador = new ViceCoordenador(
                Float.parseFloat(request.getParameter("txtSalarioBase")),
                request.getParameter("txtNome"),
                Integer.parseInt(request.getParameter("txtIdade"))
        );

        try {

            ViceCoordenadorDAO.getInstancia().save(viceCoordenador);
            response.sendRedirect("FrontController?action=LerViceCoordenador");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
