/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Pessoa;
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
 * @author rwspa
 */
public class PessoaDAO {

    private static PessoaDAO instancia = new PessoaDAO();

    public PessoaDAO() {

    }

    public static PessoaDAO getInstancia() {
        return instancia;
    }

    public void save(Pessoa pessoa) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO pessoa (nome, idade, Turma_idTurma) VALUES (?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, pessoa.getNomePessoa());
            pstm.setInt(2, pessoa.getIdadePessoa());
            pstm.setInt(3, pessoa.getTurma().getIdTurma());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public void delete(Pessoa pessoa) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "DELETE FROM pessoa WHERE idPessoa = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, pessoa.getIdPessoa());
            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public Pessoa obter(Integer idPessoa) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        Pessoa pessoa = null;

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM pessoa join turma on pessoa.Turma_idTurma = turma.idTurma WHERE idPessoa =" + idPessoa);
            rs.first();

            Turma turma = new Turma(rs.getInt("idTurma"), rs.getString("periodo"), rs.getInt("tamanho"), null);
            pessoa = new Pessoa(
                    rs.getInt("idPessoa"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    turma);

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return pessoa;
    }

    public List<Pessoa> obterPessoas() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM pessoa join turma on pessoa.Turma_idTurma = turma.idTurma");

            while (rs.next()) {

                Turma turma = new Turma(rs.getInt("idTurma"), rs.getString("periodo"), rs.getInt("tamanho"), null);

                Pessoa pessoa = new Pessoa(
                        rs.getInt("idPessoa"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        turma);

                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return pessoas;
    }

    public void editar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE pessoa AS p SET"
                    + " nome = ?, idade = ?, Turma_idTurma = ? WHERE p.idPessoa = ?";
            
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, pessoa.getNomePessoa());
            pstm.setInt(2, pessoa.getIdadePessoa());
            pstm.setInt(3, pessoa.getTurma().getIdTurma());
            pstm.setInt(4, pessoa.getIdPessoa());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }
}
