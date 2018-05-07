package Persistence;

import Model.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {

    private static DisciplinaDAO instancia = new DisciplinaDAO();

    public DisciplinaDAO() {

    }

    public static DisciplinaDAO getInstancia() {
        return instancia;
    }

    public void save(Disciplina disciplina) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO Disciplina (nome, numeroCreditos, numeroVagas) VALUES (?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, disciplina.getNomeDisciplina());
            pstm.setInt(2, disciplina.getNumeroCreditos());
            pstm.setInt(3, disciplina.getNumeroVagas());            

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public void delete(Disciplina disciplina) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "DELETE FROM Disciplina WHERE idDisciplina = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, disciplina.getIdDisciplina());
            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public Disciplina obter(Integer idDisciplina) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        Disciplina disciplina = null;

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Disciplina WHERE idDisciplina =" + idDisciplina);
            rs.first();

            
            disciplina = new Disciplina(
                    rs.getInt("iddisciplina"),
                    rs.getString("nome"),
                    rs.getInt("numerocreditos"),
                    rs.getInt("numerovagas"));

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return disciplina;
    }

    public List<Disciplina> obterDisciplinas() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<Disciplina> disciplinas = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM disciplina");

            while (rs.next()) {

                Disciplina disciplina = new Disciplina(
                    rs.getInt("idDisciplina"),
                    rs.getString("nome"),
                    rs.getInt("numeroCreditos"),
                    rs.getInt("numeroVagas"));

                disciplinas.add(disciplina);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return disciplinas;
    }

    public void editar(Disciplina disciplina) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE Disciplina AS d SET"
                    + " nome = ?, numerocreditos = ?,"
                    + " numerovagas = ? WHERE d.iddisciplina = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, disciplina.getNomeDisciplina());
            pstm.setInt(2, disciplina.getNumeroCreditos());
            pstm.setInt(3, disciplina.getNumeroVagas());
            pstm.setInt(4, disciplina.getIdDisciplina());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

}
