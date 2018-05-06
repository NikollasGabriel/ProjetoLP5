/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Disciplina;
import Model.Pessoa;
import Model.Turma;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rwspa
 */
public class TurmaController {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
        String periodo = request.getParameter("textPeriodo");
        int tamanho = Integer.parseInt(request.getParameter("textTamanho"));
        Pessoa pessoa = new Pessoa(Integer.parseInt(request.getParameter("textPessoa")));
        Disciplina disciplina = new Disciplina(Integer.parseInt(request.getParameter("textDisciplina")));
        
        if(periodo.equals("") || tamanho==0||pessoa==null||disciplina==null) {
            response.sendRedirect("index.jsp");
        } else {
            try{
                Turma turma = new Turma(0,periodo, tamanho,pessoa,disciplina);
                TurmaDAO.getInstancia().save(turma);
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
