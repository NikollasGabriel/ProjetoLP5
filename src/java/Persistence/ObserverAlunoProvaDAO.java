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

public class ObserverAlunoProvaDAO {

    private static ObserverAlunoProvaDAO instancia = new ObserverAlunoProvaDAO();

    public ObserverAlunoProvaDAO() {
    }

    public static ObserverAlunoProvaDAO getInstancia() {
        return instancia;
    }

    public List<Prova> obterProvasOfAluno(int idAluno) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<Prova> provas = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("select * from prova where Pessoa_idPessoa =" + idAluno);

            while (rs.next()) {

                Prova prova = new Prova(
                        rs.getInt("idProva"),
                        rs.getInt("valor"),
                        new Aluno(rs.getInt("Pessoa_idPessoa")),
                        new Professor(rs.getInt("Professor_idPessoa")),
                        new Disciplina(rs.getInt("Disciplina_idDisciplina")));

                provas.add(prova);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            connector.closeConnection(conn, st);
        }

        return provas;
    }

    public void editaSituacaoAluno(Aluno aluno) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE Aluno AS p SET"
                    + " situacao = ? WHERE p.idPessoa = ?";

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, aluno.getSituacao().getEstado());
            pstm.setInt(2, aluno.getIdPessoa());
            pstm.execute();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            connector.closeConnection(conn, st);
        }

    }

    public void editaNotapublic(Aluno aluno) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE Aluno AS p SET"
                    + " mediaNotas = ? WHERE p.idPessoa = ?";

            pstm = conn.prepareStatement(sql);
            pstm.setFloat(1, aluno.getMediaNotas());
            pstm.setInt(2, aluno.getIdPessoa());
            pstm.execute();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            connector.closeConnection(conn, st);
        }

    }
}
