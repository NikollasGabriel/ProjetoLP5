package Persistence;

import Model.Aluno;
import Model.Disciplina;
import Model.Professor;
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

            String sql = "INSERT INTO prova (valor, Aluno_idAluno, Professor_idProfessor, Disciplina_idDisciplina) VALUES (?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setFloat(1, prova.getValor());
            pstm.setInt(2, prova.getAluno().getIdPessoa());
            pstm.setInt(2, prova.getProfessor().getIdPessoa());
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

            String sql = "DELETE FROM prova WHERE idProva = ?";
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

            ResultSet rs = st.executeQuery("select * from Prova join Disciplina on Disciplina.idDisciplina = Prova.Disciplina_idDisciplina join Aluno on Aluno.idPessoa = Prova.Aluno_idPessoa join Professor on Professor.idPessoa = Prova.Professor_idPessoa where idProva =" + idProva);
            rs.first();

            Disciplina disciplina = new Disciplina(
                    rs.getInt("idDisciplina"),
                    rs.getString("nome"),
                    rs.getInt("numeroCreditos"),
                    rs.getInt("numeroVagas"));

            Aluno pessoa = new Aluno(
                    rs.getInt("idPessoa"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    null,
                    rs.getInt("numeroFaltas"),
                    rs.getFloat("mediaNotas"),
                    rs.getString("situacao"));
            
            Professor pessoaProfessor = new Professor(
                    rs.getInt("numeroFaltas"),
                    rs.getString("nivelEnsinoSuperior"),
                    rs.getInt("idPessoa"),
                    rs.getString("nome"),
                    rs.getInt("idade")
                    );
            
            prova = new Prova(
                        rs.getInt("idProva"),
                        rs.getInt("valor"),
                        pessoa,
                        pessoaProfessor,
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

            ResultSet rs = st.executeQuery("select * from prova join disciplina on disciplina.idDisciplina = prova.Disciplina_idDisciplina join aluno on Aluno.idPessoa = prova.Pessoa_idPessoa");

            while (rs.next()) {

                Disciplina disciplina = new Disciplina(
                        rs.getInt("idDisciplina"),
                        rs.getString("nome"),
                        rs.getInt("numeroCreditos"),
                        rs.getInt("numeroVagas"));

                Aluno pessoa = new Aluno(
                    rs.getInt("idPessoa"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    null,
                    rs.getInt("numeroFaltas"),
                    rs.getFloat("mediaNotas"),
                    rs.getString("situacao"));
                
                Professor pessoaProfessor = new Professor(
                    rs.getInt("numeroFaltas"),
                    rs.getString("nivelEnsinoSuperior"),
                    rs.getInt("idPessoa"),
                    rs.getString("nome"),
                    rs.getInt("idade")
                    );
                
                Prova prova = new Prova(
                        rs.getInt("idProva"),
                        rs.getInt("valor"),
                        pessoa,
                        pessoaProfessor,
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

            String sql = "UPDATE prova AS p SET"
                    + " valor = ?, Aluno_idPessoa = ?, Professor_idPessoa,"
                    + " Disciplina_idDisciplina = ? WHERE p.idProva = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setFloat(1, prova.getValor());
            pstm.setInt(2, prova.getAluno().getIdPessoa());
            pstm.setInt(2, prova.getProfessor().getIdPessoa());
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
