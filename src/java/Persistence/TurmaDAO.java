package Persistence;

import Model.Disciplina;
import Model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

            String sql = "INSERT INTO turma (periodo, tamanho, Disciplina_idDisciplina) VALUES (?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, turma.getPeriodoTurma());
            pstm.setInt(2, turma.getTamanhoTurma());
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

            String sql = "DELETE FROM turma WHERE idTurma = ?";
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

            ResultSet rs = st.executeQuery("SELECT * FROM turma join disciplina on disciplina.idDisciplina = turma.Disciplina_idDisciplina WHERE idTurma =" + idTurma);
            rs.first();

            Disciplina disciplina = new Disciplina(
                    rs.getInt("idDisciplina"),
                    rs.getString("nome"),
                    rs.getInt("numerocreditos"),
                    rs.getInt("numerovagas"));

            turma = new Turma(
                    rs.getInt("idTurma"),
                    rs.getString("periodo"),
                    rs.getInt("tamanho"),
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

            ResultSet rs = st.executeQuery("SELECT * FROM turma join disciplina on disciplina.idDisciplina = turma.Disciplina_idDisciplina");

            /*Disciplina disciplina = new Disciplina(
                    rs.getInt("idDisciplina"),
                    rs.getString("nome"),
                    rs.getInt("numeroCreditos"),
                    rs.getInt("numeroVagas"));*/
            while (rs.next()) {

                Disciplina disciplina = new Disciplina(
                        rs.getInt("idDisciplina"),
                        rs.getString("nome"),
                        rs.getInt("numeroCreditos"),
                        rs.getInt("numeroVagas"));

                Turma turma = new Turma(
                        rs.getInt("idTurma"),
                        rs.getString("periodo"),
                        rs.getInt("tamanho"),
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

    public void editar(Turma turma) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE turma AS t SET"
                    + " periodo = ?, tamanho = ?,"
                    + " Disciplina_idDisciplina =? WHERE t.idTurma = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, turma.getPeriodoTurma());
            pstm.setInt(2, turma.getTamanhoTurma());
            pstm.setInt(3, turma.getDisciplina().getIdDisciplina());
            pstm.setInt(4, turma.getIdTurma());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }
}
