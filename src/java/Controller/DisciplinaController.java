/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Disciplina;
import Model.Prova;
import Persistence.DisciplinaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rwspa
 */
public class DisciplinaController {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
        String nome = request.getParameter("textNome");
        int numeroCreditos = Integer.parseInt(request.getParameter("textNumeroCreditos"));
        int numeroVagas = Integer.parseInt(request.getParameter("textNumeroVagas"));
        Prova prova = new Prova(Integer.parseInt(request.getParameter("textProva")));
        
        if(nome.equals("") || numeroCreditos==0||numeroVagas==0) {
            response.sendRedirect("index.jsp");
        } else {
            try{
                Disciplina disciplina = new Disciplina(0,nome, numeroCreditos,numeroVagas,prova);
                DisciplinaDAO.getInstancia().save(disciplina);
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
