package br.unifil.dao;

import br.unifil.model.Contato;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ContatoDAO {
    public static void addContatoDao(@NotNull Contato contato) {

    }

    public static void delContatoDao(@NotNull Contato contato) {

    }

    public static void updateContatoDao(@org.jetbrains.annotations.NotNull Contato contato) {

    }

    public Contato getContatoDaoId(int id);

    public static Contato getContatoDaoNome(String nome) {
     return null;
    }
    public Contato getContatoDaoEmail(String Email);
    public List<Contato> getContatoDaoGorup(int id);

}
