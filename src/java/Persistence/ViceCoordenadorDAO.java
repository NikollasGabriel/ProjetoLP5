/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.ViceCoordenador;
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
public class ViceCoordenadorDAO {
    private static ViceCoordenadorDAO instancia = new ViceCoordenadorDAO();

    public ViceCoordenadorDAO() {

    }

    public static ViceCoordenadorDAO getInstancia() {
        return instancia;
    }

    public void save(ViceCoordenador viceCoordenador) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO vicecoordenador (nome, idade, salarioBase, salarioFinal) VALUES (?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, viceCoordenador.getNomePessoa());
            pstm.setInt(2, viceCoordenador.getIdadePessoa());
            pstm.setFloat(3, viceCoordenador.getSalarioBase());
            pstm.setFloat(4, viceCoordenador.getSalarioFinal());

            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public void delete(ViceCoordenador viceCoordenador) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "DELETE FROM vicecoordenador WHERE idPessoa = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, viceCoordenador.getIdPessoa());
            pstm.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }

    public ViceCoordenador obter(Integer idPessoa) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        ViceCoordenador viceCoordenador = null;

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM vicecoordenador WHERE idViceCoordenador =" + idPessoa);
            rs.first();

            
            viceCoordenador = new ViceCoordenador(
                    rs.getFloat("salarioBase"),
                    rs.getFloat("salarioFinal"),
                    rs.getInt("idViceCoordenador"),
                    rs.getString("nome"),
                    rs.getInt("idade")
                    );

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return viceCoordenador;
    }

    public List<ViceCoordenador> obterViceCoordenadors() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();
        List<ViceCoordenador> viceCoordenadors = new ArrayList<>();

        try {
            conn = connector.getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM join vicevicecoordenador on viceviceCoordenador.idViceViceCoordenador = viceCoordenador.ViceViceCoordenador_idViceViceCoordenador");

            while (rs.next()) {

                ViceCoordenador viceCoordenador = new ViceCoordenador(
                    rs.getFloat("salarioBase"),
                    rs.getFloat("salarioFinal"),
                    rs.getInt("idViceCoordenador"),
                    rs.getString("nome"),
                    rs.getInt("idade")
                    );

                viceCoordenadors.add(viceCoordenador);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            connector.closeConnection(conn, st);
        }

        return viceCoordenadors;
    }

    public void editar(ViceCoordenador viceCoordenador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        DatabaseLocator connector = DatabaseLocator.getInstance();

        try {
            conn = connector.getConnection();

            String sql = "UPDATE vicecoordenador AS p SET"
                    + " nome = ?, idade = ?, salarioBase=?, salarioFinal=? WHERE p.idViceCoordenador = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, viceCoordenador.getNomePessoa());
            pstm.setInt(2, viceCoordenador.getIdadePessoa());
            pstm.setFloat(3, viceCoordenador.getSalarioBase());
            pstm.setFloat(4, viceCoordenador.getSalarioFinal());
            pstm.setInt(6, viceCoordenador.getIdPessoa());

            pstm.execute();

        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        } finally {
            connector.closeConnection(conn, pstm);
        }
    }
}
