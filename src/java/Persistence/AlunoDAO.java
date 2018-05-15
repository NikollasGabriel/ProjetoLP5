/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Aluno;
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
public class AlunoDAO {

    private static AlunoDAO instancia = new AlunoDAO();

    public AlunoDAO() {

    }

    public static AlunoDAO getInstancia() {
        return instancia;
    }

    public void save(Aluno aluno) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO aluno (nomeAluno, idadeAluno, Turma_idTurma, numeroFaltas, mediaNotas, situacao) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, aluno.getNomePessoa());
            pstm.setInt(2, aluno.getIdadePessoa());
            pstm.setInt(3, aluno.getTurma().getIdTurma());
            pstm.setInt(4, aluno.getNumeroFaltas());
            pstm.setFloat(5, aluno.getMediaNotas());
            pstm.setString(6, aluno.getSituacao().getEstado());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public void delete(Aluno aluno) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "DELETE FROM aluno WHERE idPessoa = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, aluno.getIdPessoa());
            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public Aluno obter(Integer idPessoa) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        Aluno aluno = null;

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM aluno join turma on aluno.Turma_idTurma = turma.idTurma WHERE idPessoa =" + idPessoa);
            rs.first();

            Turma turma = new Turma(rs.getInt("idTurma"), rs.getString("periodo"), rs.getInt("tamanho"), null,null);
            aluno = new Aluno(
                    rs.getInt("idPessoa"),
                    rs.getString("nomeAluno"),
                    rs.getInt("idadeAluno"),
                    turma,
                    rs.getInt("numeroFaltas"),
                    rs.getFloat("mediaNotas"),
                    rs.getString("situacao"));

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return aluno;
    }

    public List<Aluno> obterAlunos() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<Aluno> alunos = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM aluno join turma on aluno.Turma_idTurma = turma.idTurma");

            while (rs.next()) {

                Turma turma = new Turma(rs.getInt("idTurma"), rs.getString("periodo"), rs.getInt("tamanho"), null,null);

                Aluno aluno = new Aluno(
                        rs.getInt("idPessoa"),
                        rs.getString("nomeAluno"),
                        rs.getInt("idadeAluno"),
                        turma,
                        rs.getInt("numeroFaltas"),
                        rs.getFloat("mediaNotas"),
                        rs.getString("situacao"));

                alunos.add(aluno);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return alunos;
    }

    public void editar(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE aluno AS p SET"
                    + " nomeAluno = ?, idadeAluno = ?, Turma_idTurma = ?, numeroFaltas = ?, mediaNotas = ?, situacao = ? WHERE p.idPessoa = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, aluno.getNomePessoa());
            pstm.setInt(2, aluno.getIdadePessoa());
            pstm.setInt(3, aluno.getTurma().getIdTurma());
            pstm.setInt(4, aluno.getNumeroFaltas());
            pstm.setFloat(5, aluno.getMediaNotas());
            pstm.setString(6, aluno.getSituacao().getEstado());
            pstm.setInt(7, aluno.getIdPessoa());

            pstm.execute();

        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }
}
