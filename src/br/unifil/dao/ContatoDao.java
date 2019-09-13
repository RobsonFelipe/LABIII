package br.unifil.dao;

import br.unifil.model.Contato;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.Statement;

public class ContatoDao {
    public String addContatoDao(@NotNull Contato contato){
        /*private int id_contato;
        private String first_name;
        private String last_name;
        private String email;
        private int group;*/
        String addQuerie;
        addQuerie = "INSERT INTO agenda(id_contato, first_name, last_name, email, group) VALUES(" +
                     contato.getId_contato() + ","+ contato.getFirst_name() +"," + contato.getLast_name() +"," +
                    contato.getEmail()+ ","+ contato.getGroup() +");";
        return addQuerie;
    }
    public String delContatoDao(@NotNull Contato contato){
        String remQuerie = "";
        remQuerie = "DELETE FROM agenda  a WHERE a.id_contato=" +contato.getId_contato()+";";
        return remQuerie;

    }
    public String updateContatoDao(@org.jetbrains.annotations.NotNull Contato contato){
        String updateQuerie = "UPDATE agenda a " +
                              "SET first_name = "       + contato.getFirst_name() +
                                    ", last_name = "    + contato.getLast_name() +
                                    ", email = "        + contato.getEmail() +
                                    ", group = "        + contato.getGroup() +
                                "WHERE a.id_contato = " + contato.getId_contato();
        return updateQuerie;
    }
    public Contato getContatoDao(){

        return null;
    }
}
