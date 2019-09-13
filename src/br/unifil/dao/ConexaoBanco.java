package br.unifil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {


        public static void main(String[] args) {
            Conexao conexao = new Conexao();
            conexao.getConn();
        }
    }

