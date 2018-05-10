/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.Coordenador;
import Persistence.CoordenadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus note
 */
public class LerCoordenadorAction implements Action{
    CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
    ArrayList<Coordenador> lista;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            lista = coordenadorDAO.obterCoordenadores();
            request.setAttribute("coordenadores", lista);

            RequestDispatcher view = request.getRequestDispatcher("Coordenador/ler.jsp");
            view.forward(request, response);

        } catch (ServletException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
