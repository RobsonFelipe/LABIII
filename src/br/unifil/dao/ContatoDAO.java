package br.unifil.dao;

import br.unifil.model.Contato;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;

public interface ContatoDAO {
    public void addContatoDao(@NotNull Contato contato);
    public void delContatoDao(@NotNull Contato contato);
    public void updateContatoDao(@org.jetbrains.annotations.NotNull Contato contato);
    public void getContatoDao(int id);
}
