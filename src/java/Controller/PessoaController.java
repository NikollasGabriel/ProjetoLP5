package Controller;

import Model.Pessoa;
import Persistence.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rwspa
 */
public class PessoaController {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
        String nome = request.getParameter("textNome");
        int idade = Integer.parseInt(request.getParameter("textIdade"));
        
        if(nome.equals("") || idade==0) {
            response.sendRedirect("index.jsp");
        } else {
            try{
                Pessoa pessoa = new Pessoa(0,nome, idade);
                PessoaDAO.getInstancia().save(pessoa);
                response.sendRedirect("sucesso.jsp");
            }catch(SQLException ex){
                response.sendRedirect("erro.jsp");
                ex.printStackTrace();
            }
            
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            processRequest(request,response);
        }catch(ServletException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            processRequest(request,response);
        }catch(ServletException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
