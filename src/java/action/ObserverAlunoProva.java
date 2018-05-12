package action;

import Model.Aluno;
import Model.Disciplina;
import Model.Professor;
import Model.Prova;
import Persistence.AlunoDAO;
import Persistence.DatabaseLocator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ObserverAlunoProva implements Observer {

    private Observable instanciaEdita;

    ObserverAlunoProva(Observable instanciaEdita) {
        this.instanciaEdita = instanciaEdita;
        instanciaEdita.addObserver(this);
    }

    public void setInstanciaEdita(Observable instanciaEdita) {
        this.instanciaEdita = instanciaEdita;
        instanciaEdita.addObserver(this);
    }

    @Override
    public void update(Observable instanciaEdita, Object arg) {

        if (instanciaEdita instanceof GravarProvaAction) {

            GravarProvaAction observable = (GravarProvaAction) instanciaEdita;
            int idAluno = observable.prova.getAluno().getIdPessoa();
            float media = 0;

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

                if (provas.size() == 3) {

                    for (Prova p : provas) {
                        media = media + p.getValor();
                    }

                    media = media / 3;

                    Aluno aluno = AlunoDAO.getInstancia().obter(idAluno);

                    if (media >= 60) {
                        aluno.getSituacao().aprovadoNota(aluno); // Mudança de estado condicional

                    } else {
                        aluno.getSituacao().reprovadoNota(aluno); // Mudança de estado condicional
                    }

                    conn = connector.getConnection();

                    String sql = "UPDATE Aluno AS p SET"
                            + " mediaNotas = ?, situacao = ? WHERE p.idPessoa = ?";

                    pstm = conn.prepareStatement(sql);
                    pstm.setFloat(1, media);
                    pstm.setString(2, aluno.getSituacao().getEstado());
                    pstm.setInt(3, idAluno);
                    pstm.execute();

                    connector.closeConnection(conn, st);

                }
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        } else {

            EditarAlunoAction observable = (EditarAlunoAction) instanciaEdita;

            int numeroFaltas = observable.numeroFaltas;
            int idAluno = observable.idPessoa;

            Connection conn = null;
            PreparedStatement pstm = null;
            Statement st = null;
            DatabaseLocator connector = DatabaseLocator.getInstance();

            try {

                Aluno aluno = AlunoDAO.getInstancia().obter(idAluno);

                if (numeroFaltas > 12) {

                    aluno.getSituacao().reprovadoFrequencia(aluno);

                } else {

                    aluno.getSituacao().aprovadoFrequencia(aluno);
                }

                conn = connector.getConnection();

                String sql = "UPDATE Aluno AS p SET"
                        + " situacao = ? WHERE p.idPessoa = ?";

                pstm = conn.prepareStatement(sql);
                pstm.setString(1, aluno.getSituacao().getEstado());
                pstm.setInt(2, idAluno);
                pstm.execute();

                connector.closeConnection(conn, st);

            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
