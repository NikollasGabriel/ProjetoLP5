/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Controller.Action;
import Model.Aluno;
import Model.AlunoMemento;
import Model.Turma;
import Persistence.AlunoDAO;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author rwspa
 */
public class AlunoMementoAction implements Action{
    AlunoMemento alunoMemento;
    Aluno alunoSelect;
    public AlunoMementoAction() {
    }

    public AlunoMemento setAlunoMementoAction(HttpServletRequest request) {
        
        //Dando null aqui
        //tem que dar um jeito de pegar essas informações do request para criar o objeto e completar o memento
        alunoSelect = new Aluno(
                Integer.parseInt(request.getParameter("txtIdPessoa")),
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("idadePessoa")),
                new Turma(Integer.parseInt(request.getParameter("txtIdTurma"))),
                Integer.parseInt(request.getParameter("txtNumeroFaltas")),
                Float.parseFloat(request.getParameter("txtMediaNotas")),
                request.getParameter("txtSituacao")
        );
        return alunoMemento = new AlunoMemento(alunoSelect);
    }
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.setAttribute("aluno", AlunoDAO.getInstancia().obter(Integer.parseInt(request.getParameter("txtIdPessoa"))));
            request.setAttribute("turmas", TurmaDAO.getInstancia().obterTurmas());
            
            alunoSelect.restoreFromMemento(this.setAlunoMementoAction(request));
            request.setAttribute("aluno", alunoSelect);
            
            RequestDispatcher view = request.getRequestDispatcher("Aluno/editar.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(AlunoMementoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoMementoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoMementoAction.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
