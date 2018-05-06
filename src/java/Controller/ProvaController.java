/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Prova;
import Persistence.ProvaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rwspa
 */
public class ProvaController {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
        
        int valor = Integer.parseInt(request.getParameter("textValor"));
        String aluno = request.getParameter("textAluno");
        
        if(aluno.equals("") || valor==0) {
            response.sendRedirect("index.jsp");
        } else {
            try{
                Prova prova = new Prova(0,valor, aluno);
                ProvaDAO.getInstancia().save(prova);
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
