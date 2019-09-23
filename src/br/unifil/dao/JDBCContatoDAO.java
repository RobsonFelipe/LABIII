package br.unifil.dao;

import br.unifil.model.Contato;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCContatoDAO implements ContatoDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void addContatoDao(@NotNull Contato contato){

        String addQuerie;
        addQuerie = "INSERT INTO agenda(id_contato, first_name, last_name, email, group) VALUES(?,?,?,?,? );";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(addQuerie);
            ps.setInt(1, contato.getId_contato());
            ps.setString(2, contato.getFirst_name());
            ps.setString(3, contato.getLast_name());
            ps.setString(4, contato.getEmail());
            ps.setInt(5, contato.getGroup());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }

    }
    public void delContatoDao(@NotNull Contato contato){
        String remQuerie = "";
        remQuerie = "DELETE FROM agenda  a WHERE a.id_contato=?;";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(remQuerie);
            ps.setInt(1, contato.getId_contato());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }


    }
    public void updateContatoDao(@NotNull Contato contato){
        String updateQuerie = "UPDATE agenda a SET first_name = ?, last_name = ?, email = ?, group = ? WHERE a.id_contato = ?;" ;
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(updateQuerie);
            ps.setString(1, contato.getFirst_name());
            ps.setString(2, contato.getLast_name());
            ps.setString(3, contato.getEmail());
            ps.setInt(4, contato.getGroup());
            ps.setInt(5, contato.getId_contato());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public Contato getContatoDaoId(int id) {
        String sql = "SELECT * FROM CUSTOMER WHERE ID = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ContatoRowMapper());
    }

    @Override
    public Contato getContatoDaoEmail(String Email) {
        return null;
    }

    @Override
    public List<Contato> getContatoDaoGorup(int id) {
        return null;
    }

    public Contato getContatoDaoToContato( ResultSet result) throws SQLException {
        Contato cnt = new Contato();
        while (result.next()) {

            int id = result.getInt("ID_CONTATO");
            String first_name = result.getString("First_NAME");
            String last_name = result.getString("LAST_NAME");
            String email = result.getString("EMAIL");
            int group= Integer.parseInt( result.getString("GROUP"));


            cnt.setId_contato(id);
            cnt.setFirst_name(first_name);
            cnt.setLast_name(last_name);
            cnt.setEmail(email);
            cnt.setGroup(group);
        }
        return cnt;
    }
}
