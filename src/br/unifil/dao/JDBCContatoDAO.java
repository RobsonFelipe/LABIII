package br.unifil.dao;

import br.unifil.model.Contato;
import org.jetbrains.annotations.NotNull;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCContatoDAO implements ContatoDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void addContatoDao(@NotNull Contato contato){

        String addQuerie;
        addQuerie = "INSERT INTO agenda(id_contato, first_name, last_name, email, group) VALUES(" +
                contato.getId_contato() + ","+ contato.getFirst_name() +"," + contato.getLast_name() +"," +
                contato.getEmail()+ ","+ contato.getGroup() +");";

    }
    public void delContatoDao(@NotNull Contato contato){
        String remQuerie = "";
        remQuerie = "DELETE FROM agenda  a WHERE a.id_contato=" +contato.getId_contato()+";";


    }
    public void updateContatoDao(@NotNull Contato contato){
        String updateQuerie = "UPDATE agenda a " +
                "SET first_name = "       + contato.getFirst_name() +
                ", last_name = "    + contato.getLast_name() +
                ", email = "        + contato.getEmail() +
                ", group = "        + contato.getGroup() +
                "WHERE a.id_contato = " + contato.getId_contato();
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(updateQuerie);
            /*
            ps.setInt(1, contato.getCustId());
            ps.setString(2, contato.getName());
            ps.setInt(3, contato.getAge());
            ps.executeUpdate();
            ps.close();
            */
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
    public void getContatoDao(ResultSet result) {

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
