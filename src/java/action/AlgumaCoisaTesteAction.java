package action;

import Controller.Action;
import Model.Aluno;
import Model.Disciplina;
import Model.Professor;
import Model.Prova;
import Persistence.DatabaseLocator;
import State.AlunoEstadoAprovadoNota;
import State.AlunoEstadoReprovadoNota;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlgumaCoisaTesteAction implements Action, Observer {

    private Observable instanciaEdita;

    AlgumaCoisaTesteAction(Observable instanciaEdita) {
        this.instanciaEdita = instanciaEdita;
        instanciaEdita.addObserver(this);
    }

    public void setInstanciaEdita(Observable instanciaEdita) {
        this.instanciaEdita = instanciaEdita;
        instanciaEdita.addObserver(this);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void update(Observable instanciaEdita, Object arg) {

        if (instanciaEdita instanceof GravarProvaAction) {

            GravarProvaAction observable = (GravarProvaAction) instanciaEdita;
            int idAluno = observable.prova.getAluno().getIdPessoa();
            float media = 0;
            String estado;
            Aluno aluno = new Aluno();

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
                try {
                    connector.closeConnection(conn, st);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            if (provas.size() == 3) {

                for (Prova p : provas) {
                    media = media + p.getValor();
                }

                media = media / 3;

                if (media >= 60) {

                    aluno.setSituacao(new AlunoEstadoAprovadoNota());
                    estado = aluno.getSituacao().getEstado();

                } else {

                    aluno.setSituacao(new AlunoEstadoReprovadoNota());
                    estado = aluno.getSituacao().getEstado();
                }

                try {
                    conn = connector.getConnection();

                    String sql = "UPDATE Aluno AS p SET"
                            + " mediaNotas = ?, situacao = ? WHERE p.idPessoa = ?";

                    pstm = conn.prepareStatement(sql);

                    pstm.setFloat(1, media);
                    pstm.setString(2, estado);
                    pstm.setInt(3, idAluno);

                    pstm.execute();

                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        connector.closeConnection(conn, st);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

    }

}
