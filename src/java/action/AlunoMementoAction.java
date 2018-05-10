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
import java.util.ArrayList;
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
    ArrayList<AlunoMemento> alunoList = new ArrayList<>();
    
    public AlunoMementoAction() {
    }

    public AlunoMementoAction(Aluno a) {
        alunoSelect = a;
        alunoMemento = new AlunoMemento(alunoSelect);
        alunoList.add(alunoMemento);
    }
    
    public void selecionaAluno(int id){
        for(AlunoMemento aluno : alunoList){
            if(aluno.getAlunoSalvo().getIdPessoa()==id){
                alunoMemento = aluno;
                break;
            }
        }
    }
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            this.selecionaAluno(Integer.parseInt(request.getParameter("txtIdPessoa")));
            alunoSelect.restoreFromMemento(alunoMemento);
            request.setAttribute("aluno", alunoSelect);
            
            RequestDispatcher view = request.getRequestDispatcher("Aluno/editar.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(AlunoMementoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
