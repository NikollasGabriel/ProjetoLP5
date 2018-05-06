package Persistence;

import Model.Disciplina;
import Model.Prova;
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

            String sql = "INSERT INTO Disciplina (nome, numerocreditos, numerovagas, idprova) VALUES (?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, disciplina.getNomeDisciplina());
            pstm.setInt(2, disciplina.getNumeroCreditos());
            pstm.setInt(3, disciplina.getNumeroVagas());
            pstm.setInt(4, disciplina.getP1().getIdProva());

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

            String sql = "DELETE FROM Disciplina WHERE iddisciplina = ?";
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

            ResultSet rs = st.executeQuery("SELECT * FROM Disciplina join Prova on Prova.idprova=Disciplina.idprova WHERE iddisciplina =" + idDisciplina);
            rs.first();

            Prova prova = new Prova(rs.getInt("idprova"),rs.getInt("valor"),rs.getString("aluno"));
            
            disciplina = new Disciplina(
                    rs.getInt("iddisciplina"),
                    rs.getString("nome"),
                    rs.getInt("numerocreditos"),
                    rs.getInt("numerovagas"),
                    prova);

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return disciplina;
    }

    public List<Disciplina> obter() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<Disciplina> disciplinas = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT = FROM Disciplina");
            Prova prova = new Prova(rs.getInt("idprova"),rs.getInt("valor"),rs.getString("aluno"));

            while (rs.next()) {

                Disciplina disciplina = new Disciplina(
                    rs.getInt("iddisciplina"),
                    rs.getString("nome"),
                    rs.getInt("numerocreditos"),
                    rs.getInt("numerovagas"),
                    prova
                );

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

            String sql = "UPDATE Disciplina AS c SET iddisciplina = ?,"
                    + " nome = ?, numerocreditos = ?,"
                    + " numerovagas = ?, idprova = ? WHERE c.iddisciplina = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, disciplina.getIdDisciplina());
            pstm.setString(2, disciplina.getNomeDisciplina());
            pstm.setInt(3, disciplina.getNumeroCreditos());
            pstm.setInt(4, disciplina.getNumeroVagas());
            pstm.setInt(5, disciplina.getP1().getIdProva());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

}
