/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Professor;
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
public class ProfessorDAO {

    private static ProfessorDAO instancia = new ProfessorDAO();

    public ProfessorDAO() {

    }

    public static ProfessorDAO getInstancia() {
        return instancia;
    }

    public void save(Professor professor) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO professor (nomeProfessor, idade, numeroFaltas, nivelEnsinoSuperior) VALUES (?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, professor.getNomePessoa());
            pstm.setInt(2, professor.getIdadePessoa());
            pstm.setInt(4, professor.getNumeroFaltas());
            pstm.setString(5, professor.getNivelEnsinoSuperior());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public void delete(Professor professor) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "DELETE FROM professor WHERE idPessoa = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, professor.getIdPessoa());
            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public Professor obter(Integer idPessoa) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        Professor professor = null;

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM professor WHERE idPessoa =" + idPessoa);
            rs.first();

            professor = new Professor(
                        rs.getInt("numeroFaltas"),
                        rs.getString("nivelEnsinoSuperior"),
                        rs.getInt("idPessoa"),
                        rs.getString("nomeProfessor"),
                        rs.getInt("idade")
                );

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return professor;
    }

    public List<Professor> obterProfessores() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<Professor> professors = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM professor");

            while (rs.next()) {

                Professor professor = new Professor(
                        rs.getInt("numeroFaltas"),
                        rs.getString("nivelEnsinoSuperior"),
                        rs.getInt("idPessoa"),
                        rs.getString("nomeProfessor"),
                        rs.getInt("idade")
                );

                professors.add(professor);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return professors;
    }

    public void editar(Professor professor) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE professor AS p SET"
                    + " nomeProfessor = ?, idade = ?, numeroFaltas = ?, mediaNotas = ? WHERE p.idPessoa = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, professor.getNomePessoa());
            pstm.setInt(2, professor.getIdadePessoa());
            pstm.setInt(4, professor.getNumeroFaltas());
            pstm.setString(5, professor.getNivelEnsinoSuperior());
            pstm.setInt(6, professor.getIdPessoa());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }
}
