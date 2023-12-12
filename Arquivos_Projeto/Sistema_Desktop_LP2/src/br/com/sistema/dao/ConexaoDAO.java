package br.com.sistema.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

    private static ConexaoDAO instancia;
    private static Connection connection = null;

    public ConexaoDAO() {
    }

    public static ConexaoDAO getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoDAO();
        }
        return instancia;
    }

    public static Connection abrirConexao() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:resources/bdsistema.db");
                connection.setAutoCommit(false);
                System.out.println("Conexão com o banco de dados SQLite estabelecida.");
            }
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Problema ao abrir a conexão com o banco SQLite: " + e.getMessage());
            return null;
        }
    }

    public void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexão com o banco de dados SQLite fechada com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Problema ao fechar a conexão com o banco SQLite: " + e.getMessage());
        }
    }
}