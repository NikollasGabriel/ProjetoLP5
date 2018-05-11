/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Coordenador;
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

/**
 *
 * @author asus note
 */
public class CoordenadorDAO {
    private static CoordenadorDAO instancia = new CoordenadorDAO();

    public CoordenadorDAO() {

    }

    public static CoordenadorDAO getInstancia() {
        return instancia;
    }

    public void save(Coordenador coordenador) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO coordenador (nome, idade, salarioBase, salarioFinal, ViceCoordenador_idViceCoordenador) VALUES (?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            coordenador.setRemuneracao();
            
            pstm.setString(1, coordenador.getNomePessoa());
            pstm.setInt(2, coordenador.getIdadePessoa());
            pstm.setFloat(3, coordenador.getSalarioBase());
            pstm.setFloat(4, coordenador.getSalarioFinal());
            pstm.setInt(5, coordenador.getViceCoordenador().getIdPessoa());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public void delete(Coordenador coordenador) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "DELETE FROM coordenador WHERE idPessoa = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, coordenador.getIdPessoa());
            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public Coordenador obter(Integer idPessoa) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        Coordenador coordenador = null;

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM coordenador join turma on coordenador.Turma_idTurma = turma.idTurma WHERE idPessoa =" + idPessoa);
            rs.first();

            Turma turma = new Turma(rs.getInt("idTurma"), rs.getString("periodo"), rs.getInt("tamanho"), null,null);
            coordenador = new Coordenador(
                    rs.getInt("idPessoa"),
                    rs.getString("nomeCoordenador"),
                    rs.getInt("idade"),
                    turma,
                    rs.getInt("numeroFaltas"),
                    rs.getFloat("mediaNotas"),
                    rs.getString("situacao"));

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return coordenador;
    }

    public List<Coordenador> obterCoordenadors() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<Coordenador> coordenadors = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM coordenador join turma on coordenador.Turma_idTurma = turma.idTurma");

            while (rs.next()) {

                Turma turma = new Turma(rs.getInt("idTurma"), rs.getString("periodo"), rs.getInt("tamanho"), null,null);

                Coordenador coordenador = new Coordenador(
                        rs.getInt("idPessoa"),
                        rs.getString("nomeCoordenador"),
                        rs.getInt("idade"),
                        turma,
                        rs.getInt("numeroFaltas"),
                        rs.getFloat("mediaNotas"),
                        rs.getString("situacao"));

                coordenadors.add(coordenador);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return coordenadors;
    }

    public void editar(Coordenador coordenador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE coordenador AS p SET"
                    + " nomeCoordenador = ?, idade = ?, Turma_idTurma = ?, numeroFaltas = ?, mediaNotas = ?, situacao = ? WHERE p.idPessoa = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, coordenador.getNomePessoa());
            pstm.setInt(2, coordenador.getIdadePessoa());
            pstm.setInt(3, coordenador.getTurma().getIdTurma());
            pstm.setInt(4, coordenador.getNumeroFaltas());
            pstm.setFloat(5, coordenador.getMediaNotas());
            pstm.setString(6, coordenador.getSituacao().getEstado());
            pstm.setInt(7, coordenador.getIdPessoa());

            pstm.execute();

        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }
}
