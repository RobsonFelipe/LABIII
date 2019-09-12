package br.unifil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {


        public static void main(String[] args) {
            Connection conn;
            try {
                // The newInstance() call is a work around for some
                // broken Java implementations

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                try {
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/3306/agenda" +
                                                            "user=agenda&password=Senha$00");
                    conn.createStatement();
                } catch (SQLException ex) {
                    // handle any errors
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                }

            } catch (Exception ex) {
                // handle the error
            }
        }
    }

