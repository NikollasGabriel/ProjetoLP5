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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus note
 */
public class EditarProvaAction implements Action {

    public EditarProvaAction() {
    }

    @Override
    public void execute(HttpServletRequest request,
        HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String aluno = request.getParameter("txtAluno");
        int valor = Integer.parseInt(request.getParameter("txtValor"));
        
        
        if (aluno.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                ProvaDAO provaDAO = new ProvaDAO();
                Prova prova = new Prova();
                prova = provaDAO.obter(id);
                provaDAO.editar(prova, valor, aluno);
                response.sendRedirect("sucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

}
