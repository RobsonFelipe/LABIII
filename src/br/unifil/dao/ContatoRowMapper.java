package br.unifil.dao;

import br.unifil.model.Contato;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContatoRowMapper implements RowMapper<Contato> {

    @Override
    public Contato mapRow(ResultSet rs, int rowNum) throws SQLException {
        //id_contato, first_name, last_name, email, group
        Contato cnt = new Contato();
        cnt.setId_contato((int) rs.getLong("id_contato"));
        cnt.setFirst_name(rs.getString("first_name"));
        cnt.setLast_name(rs.getString("last_name"));
        cnt.setEmail(rs.getString("email"));
        cnt.setGroup(rs.getInt("group"));
        return cnt;
    }
}
