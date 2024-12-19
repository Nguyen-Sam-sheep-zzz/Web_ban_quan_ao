package com.example.web_ban_quan_ao.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private String url = "jdbc:mysql://localhost:3306/Web_ban_quan_ao?useSSL=true&serverTimezone=UTC";

    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
