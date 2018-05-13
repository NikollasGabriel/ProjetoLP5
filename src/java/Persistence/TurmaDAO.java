package Persistence;

import Model.Coordenador;
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

            String sql = "INSERT INTO turma (periodo, tamanho, Disciplina_idDisciplina, Coodenador_idCoordenador) VALUES (?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, turma.getPeriodoTurma());
            pstm.setInt(2, turma.getTamanhoTurma());
            pstm.setInt(3, turma.getDisciplina().getIdDisciplina());
            pstm.setInt(4, turma.getCoordenador().getIdPessoa());

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

            String sql = "DELETE FROM turma WHERE idturma = ?";
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

            ResultSet rs = st.executeQuery("SELECT * FROM turma join disciplina on disciplina.idDisciplina = turma.Disciplina_idDisciplina join coordenador on coordenador.idCoordenador = turma.Coordenador_idCoordenador WHERE idTurma =" + idTurma);
            rs.first();

            Disciplina disciplina = new Disciplina(
                    rs.getInt("idDisciplina"),
                    rs.getString("nomeDisciplina"),
                    rs.getInt("numerocreditos"),
                    rs.getInt("numerovagas"));
            
            Coordenador coordenador = new Coordenador(
                    null,
                    rs.getFloat("salarioBase"),
                    rs.getInt("idCoordenador"),
                    rs.getString("nome"),
                    rs.getInt("idade")
            );

            turma = new Turma(
                    rs.getInt("idTurma"),
                    rs.getString("periodo"),
                    rs.getInt("tamanho"),
                    disciplina,
                    coordenador
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

            ResultSet rs = st.executeQuery("SELECT * FROM turma join disciplina on disciplina.idDisciplina = turma.Disciplina_idDisciplina join coordenador on coordenador.idCoordenador = turma.Coordenador_idCoordenador");

            /*Disciplina disciplina = new Disciplina(
                    rs.getInt("idDisciplina"),
                    rs.getString("nome"),
                    rs.getInt("numeroCreditos"),
                    rs.getInt("numeroVagas"));*/
            while (rs.next()) {

                Disciplina disciplina = new Disciplina(
                        rs.getInt("idDisciplina"),
                        rs.getString("nomeDisciplina"),
                        rs.getInt("numeroCreditos"),
                        rs.getInt("numeroVagas"));
                
                Coordenador coordenador = new Coordenador(
                    null,
                    rs.getFloat("salarioBase"),
                    rs.getInt("idCoordenador"),
                    rs.getString("nome"),
                    rs.getInt("idade")
            );

                Turma turma = new Turma(
                    rs.getInt("idTurma"),
                    rs.getString("periodo"),
                    rs.getInt("tamanho"),
                    disciplina,
                    coordenador
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
                    + " Disciplina_idDisciplina =?, Coordenador_idCoordenador=? WHERE t.idTurma = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, turma.getPeriodoTurma());
            pstm.setInt(2, turma.getTamanhoTurma());
            pstm.setInt(3, turma.getDisciplina().getIdDisciplina());
            pstm.setInt(4, turma.getCoordenador().getIdPessoa());
            pstm.setInt(5, turma.getIdTurma());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }
}
