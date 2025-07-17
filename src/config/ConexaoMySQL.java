package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String HOST = "jdbc:mysql://localhost:3312/industria";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // método
    public static Connection getConnection(){
        try {

            Connection conn = DriverManager.getConnection(HOST, USER, PASSWORD);
            System.out.println("Conectado ao banco com sucesso.");

            return conn;

        } catch (SQLException e) {
              System.out.println("Erro ao se conectar ao banco." + e.getMessage());

        }

        return null;


    }





}
