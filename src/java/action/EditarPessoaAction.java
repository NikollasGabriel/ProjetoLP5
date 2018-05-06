/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.Pessoa;
import Model.Prova;
import Persistence.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus note
 */
public class EditarPessoaAction implements Action {

    public EditarPessoaAction() {
    }

    @Override
    public void execute(HttpServletRequest request,
        HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String nome = request.getParameter("txtNome");
        int idade = Integer.parseInt(request.getParameter("txtIdade"));
        
        
        if (nome.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                PessoaDAO pessoaDAO = new PessoaDAO();
                Pessoa pessoa = new Pessoa();
                pessoa = pessoaDAO.obter(id);
                pessoaDAO.editar(pessoa, nome, idade);
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
