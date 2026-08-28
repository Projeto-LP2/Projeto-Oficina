package com.github.projetolp2.repository;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Conexao {

    private static String driver;
    private static String endereco;
    private static String usuario;
    private static String senha;

    static{
        try (InputStream input = Conexao.class.getClassLoader()
                .getResourceAsStream("application.properties")){

            Properties prop = new Properties();
            prop.load(input);

            driver = prop.getProperty("db.driver");
            endereco = prop.getProperty("db.endereco");
            usuario = prop.getProperty("db.usuario");
            senha = prop.getProperty("db.senha");

        } catch (Exception e) {
            System.err.println("Erro ao carregar application.properties: " + e.getMessage());
        }
    }
    public static Connection getConexao() {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(endereco, usuario, senha);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }

        return con;
    }

    public static void fecharConexao(Connection con) {
        try{
            if (con != null) con.close();
        } catch (SQLException e) {
            System.err.println("Erro ao fechar uma conexão com o banco: " + e.getMessage());
        }
    }

    public static void fecharConexao(Connection con, Statement stmt) {
        try {
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.err.println("Erro ao fechar uma conexão com o banco: " + e.getMessage());
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement stmt) {
        fecharConexao(con, (Statement) stmt);
    }

    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        fecharConexao(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar uma conexao com o banco: " + e.getMessage());
        }
    }

}