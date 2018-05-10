/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.Coordenador;
import Persistence.AlunoDAO;
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
    
    Coordenador coordenador;
    CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        coordenador = new Coordenador(
                Float.parseFloat(request.getParameter("txtSalarioCoordenador")),
                Integer.parseInt(request.getParameter("txtIdPessoa")),
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("txtIdadePessoa"))
                );

        coordenadorDAO.gravar(coordenador.getIdPessoa(), coordenador.getNomePessoa(), coordenador.getIdadePessoa(), coordenador.getSalarioBase());
        response.sendRedirect("FrontController?action=LerCoordenador");
    }
}
