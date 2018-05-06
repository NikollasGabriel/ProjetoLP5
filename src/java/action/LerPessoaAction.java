/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.Pessoa;
import Persistence.PessoaDAO;
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
public class LerPessoaAction implements Action {

    @Override
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
            try{
                List<Pessoa> pessoas = new ArrayList<Pessoa>();
                pessoas = PessoaDAO.getInstancia().obterPessoas();
                request.setAttribute("pessoas", pessoas);
                RequestDispatcher view = request.getRequestDispatcher("pessoaConsulta.jsp");
                view.forward(request, response);
            } catch(SQLException ex)
            {
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(LerPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
