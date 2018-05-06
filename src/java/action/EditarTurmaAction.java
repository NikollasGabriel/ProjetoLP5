/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.Disciplina;
import Model.Turma;
import Model.Pessoa;
import Model.Prova;
import Persistence.TurmaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus note
 */
public class EditarTurmaAction implements Action {

    public EditarTurmaAction() {
    }

    @Override
    public void execute(HttpServletRequest request,
        HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String periodo = request.getParameter("txtPeriodo");
        int tamanho = Integer.parseInt(request.getParameter("txtTamanho"));
        Pessoa pessoa = new Pessoa(Integer.parseInt(request.getParameter("txtPessoa")));
        Disciplina disciplina = new Disciplina(Integer.parseInt(request.getParameter("txtTurma")));
        
        if (periodo.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                TurmaDAO turmaDAO = new TurmaDAO();
                Turma turma = new Turma();
                turma = turmaDAO.obter(id);
                turmaDAO.editar(turma, periodo, tamanho, pessoa.getIdPessoa(),disciplina.getIdDisciplina());
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
