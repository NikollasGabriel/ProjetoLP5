/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Disciplina;
import Model.Pessoa;
import Model.Prova;
import Model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rwspa
 */
public class TurmaDAO {
    private static TurmaDAO instancia = new TurmaDAO();

    public TurmaDAO() {

    }

    public static TurmaDAO getInstancia() {
        return instancia;
    }

    public void save(Turma turma) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO Turma (periodo, tamanho, idpessoa, iddisciplina) VALUES (?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, turma.getPeriodoTurma());
            pstm.setInt(2, turma.getTamanhoTurma());
            pstm.setInt(3, turma.getPessoa().getIdPessoa());
            pstm.setInt(3, turma.getDisciplina().getIdDisciplina());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public void delete(Turma turma) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "DELETE FROM Turma WHERE idturma = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, turma.getIdTurma());
            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public Turma obter(Integer idTurma) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        Turma turma = null;

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Turma join Pessoa on Pessoa.idpessoa = Turma.idpessoa join Disciplina on Disciplina.iddisciplina = Turma.iddisciplina WHERE idturma =" + idTurma);
            rs.first();
            Pessoa pessoa = new Pessoa(rs.getInt("idpessoa"),rs.getString("nome"),0);
            Prova prova = new Prova(rs.getInt("idprova"),0,null);
            Disciplina disciplina = new Disciplina(rs.getInt("iddisciplina"),null,0,0,prova);
            
            turma = new Turma(
                    rs.getInt("idturma"),
                    rs.getString("periodo"),
                    rs.getInt("tamanho"),
                    pessoa,
                    disciplina
            );

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return turma;
    }

    public List<Turma> obterTurmas() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<Turma> turmas = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT = FROM Turma");

            Pessoa pessoa = new Pessoa(rs.getInt("idpessoa"),rs.getString("nome"),0);
            Prova prova = new Prova(rs.getInt("idprova"),0,null);
            Disciplina disciplina = new Disciplina(rs.getInt("iddisciplina"),null,0,0,prova);
            
            while (rs.next()) {

                Turma turma = new Turma(
                    rs.getInt("idturma"),
                    rs.getString("periodo"),
                    rs.getInt("tamanho"),
                    pessoa,
                    disciplina
            );

                turmas.add(turma);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return turmas;
    }

    public void editar(Turma turma, String periodo, int tamanho, int idpessoa, int iddisciplina) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE Turma AS t SET"
                    + " periodo = ?, tamanho = ?,"
                    +" idpessoa =?, iddisciplina =? WHERE t.idturma = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, periodo);
            pstm.setInt(2, tamanho);
            pstm.setInt(3, idpessoa);
            pstm.setInt(4, iddisciplina);
            pstm.setInt(5, turma.getIdTurma());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }
}
