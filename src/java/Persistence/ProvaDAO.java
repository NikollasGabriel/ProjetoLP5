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

public class ProvaDAO {

    private static ProvaDAO instancia = new ProvaDAO();

    public ProvaDAO() {

    }

    public static ProvaDAO getInstancia() {
        return instancia;
    }

    public void save(Prova prova) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO Prova (valor, aluno, Disciplina_idDisciplina) VALUES (?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setFloat(1, prova.getValor());
            pstm.setString(2, prova.getAluno());
            pstm.setInt(3, prova.getDisciplina().getIdDisciplina());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public void delete(Prova prova) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "DELETE FROM Prova WHERE idprova = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, prova.getIdProva());
            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public Prova obter(Integer idProva) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        Prova prova = null;

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("select * from Prova join Disciplina on Disciplina.idDisciplina = Prova.Disciplina_idDisciplina where idprova =" + idProva);
            rs.first();

            Disciplina disciplina = new Disciplina(
                    rs.getInt("idDisciplina"),
                    rs.getString("nome"),
                    rs.getInt("numeroCreditos"),
                    rs.getInt("numeroVagas"));

            prova = new Prova(
                    rs.getInt("idProva"),
                    rs.getInt("valor"),
                    rs.getString("aluno"),
                    disciplina);

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return prova;
    }

    public List<Prova> obterProvas() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<Prova> provas = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("select * from Prova join Disciplina on Disciplina.idDisciplina = Prova.Disciplina_idDisciplina");

            while (rs.next()) {

                Disciplina disciplina = new Disciplina(
                        rs.getInt("idDisciplina"),
                        rs.getString("nome"),
                        rs.getInt("numeroCreditos"),
                        rs.getInt("numeroVagas"));

                Prova prova = new Prova(
                        rs.getInt("idProva"),
                        rs.getInt("valor"),
                        rs.getString("aluno"),
                        disciplina);

                provas.add(prova);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return provas;
    }

    public void editar(Prova prova) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE Prova AS p SET"
                    + " valor = ?, aluno = ?,"
                    + " Disciplina_idDisciplina = ? WHERE p.idprova = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setFloat(1, prova.getValor());
            pstm.setString(2, prova.getAluno());
            pstm.setInt(3, prova.getDisciplina().getIdDisciplina());
            pstm.setInt(4, prova.getIdProva());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }
}
