/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

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

            String sql = "INSERT INTO Turma (periodoTurma, tamanhoTurma) VALUES (?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, turma.getPeriodoTurma());
            pstm.setInt(2, turma.getTamanhoTurma());

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

            String sql = "DELETE FROM Turma WHERE idTurma = ?";
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

            ResultSet rs = st.executeQuery("SELECT * FROM Turma WHERE idTurma =" + idTurma);
            rs.first();

            turma = new Turma(
                    rs.getInt("idTurma"),
                    rs.getString("periodoTurma"),
                    rs.getInt("tamanhoTurma"));

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return turma;
    }

    public List<Turma> obter() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<Turma> turmas = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT = FROM Turma");

            while (rs.next()) {

                Turma turma = new Turma(
                        rs.getInt("idTurma"),
                        rs.getString("periodoTurma"),
                        rs.getInt("tamanhoTurma"));

                turmas.add(turma);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return turmas;
    }

    public void editar(Turma turma) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE Turma AS c SET idTurma = ?,"
                    + " periodoTurma = ?, tamanhoTurma = ?,";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, turma.getIdTurma());
            pstm.setString(2, turma.getPeriodoTurma());
            pstm.setInt(3, turma.getTamanhoTurma());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }
}
