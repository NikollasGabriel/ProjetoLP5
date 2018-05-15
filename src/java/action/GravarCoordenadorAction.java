/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.Coordenador;
import Model.Coordenador;
import Model.Turma;
import Model.ViceCoordenador;
import Persistence.CoordenadorDAO;
import Persistence.CoordenadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus note
 */
public class GravarCoordenadorAction implements Action{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Coordenador coordenador = new Coordenador(
                new ViceCoordenador(Integer.parseInt(request.getParameter("txtIdViceCoordenador"))),
                Float.parseFloat(request.getParameter("txtSalarioBase")),
                Integer.parseInt(request.getParameter("txtTempoServico")),
                request.getParameter("txtNomeCoordenador"),
                Integer.parseInt(request.getParameter("txtIdadeCoordenador"))
        );

        try {

            CoordenadorDAO.getInstancia().save(coordenador);
            response.sendRedirect("FrontController?action=LerCoordenador");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
